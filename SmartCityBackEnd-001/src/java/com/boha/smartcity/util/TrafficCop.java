/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.smartcity.util;

import com.boha.smartcity.transfer.RequestDTO;
import com.boha.smartcity.transfer.ResponseDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is a convenience utility that executes the appropriate
 * method in the EJB's that is requested by specifying the requestType
 * along with the appropriate properties for the request.
 * @author aubreyM
 */
@Stateless
public class TrafficCop {

    /**
     * Process appropriate EJB method as specified by requestType.
     * @param req
     * @param dataUtil
     * @param listUtil
     * @param bee
     * @return ResponseDTO
     */
    public ResponseDTO processRequest(RequestDTO req,
            DataUtil dataUtil, ListUtil listUtil, AlertWorkerBee bee) {
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        resp.setStatusCode(0);
        try {
            switch (req.getRequestType()) {
                case RequestDTO.SIGN_IN_CITIZEN:
                    resp = listUtil.login(req.getUserName(), req.getPassword(), 
                            req.getLatitude(), req.getLongitude());
                    break;
                case RequestDTO.ADD_ALERT:
                    resp = dataUtil.addAlert(req.getAlert());
                    break;
                case RequestDTO.GET_ALERTS_WITHIN_RADIUS:
                    resp = bee.getAlertsWithinRadius(req.getLatitude(), req.getLongitude(), req.getRadius(), 
                            AlertWorkerBee.KILOMETRES);
                    break;
                default:
                    resp.setStatusCode(8);
                    resp.setMessage("Unknown request. Verboten");
                    break;
                    
            }
        } catch (DataException e) {
            resp.setStatusCode(101);
            resp.setMessage("Data service failed to process your request");
            logger.log(Level.SEVERE, "Database related failure", e);
        } catch (Exception e) {
            resp.setStatusCode(102);
            resp.setMessage("Server process failed to process your request");
            logger.log(Level.SEVERE, "Generic server related failure", e);
        }
       
        long end = System.currentTimeMillis();
        double elapsed = Elapsed.getElapsed(start, end);
        resp.setRequestResponseTimeSeconds(elapsed);
        logger.log(Level.WARNING, "*********** request elapsed time: {0} seconds", elapsed);
        return resp;
    }


    @PersistenceContext
    EntityManager em;
    static final Logger logger = Logger.getLogger(TrafficCop.class.getSimpleName());
}
