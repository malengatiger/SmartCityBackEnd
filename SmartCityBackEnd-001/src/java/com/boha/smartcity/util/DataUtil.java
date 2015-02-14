/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.smartcity.util;

import com.boha.smartcity.data.Alert;
import com.boha.smartcity.data.AlertType;
import com.boha.smartcity.data.City;
import com.boha.smartcity.dto.AlertDTO;
import com.boha.smartcity.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DataUtil {

    @PersistenceContext
    EntityManager em;
    static final Logger log = Logger.getLogger(DataUtil.class.getSimpleName());
//
//    public ResponseDTO addPhotoUpload(PhotoUploadDTO p) throws DataException {
//        ResponseDTO resp = new ResponseDTO();
//        try {
//            PhotoUpload a = new PhotoUpload();
//            a.setAlert(em.find(Alert.class, p.getAlertID()));
//            a.setAccuracy(p.getAccuracy());
//            a.setDateTaken(p.getDateTaken());
//            a.setDateUploaded(p.getDateUploaded());
//            a.setLatitude(p.getLatitude());
//            a.setLongitude(p.getLongitude());
//            a.setUri(p.getUri());
//            
//            em.persist(a);
//            em.flush();
//            
//            log.log(Level.WARNING, "## photo added to db, id: {0}", a.getAlert().getAlertType().getAlertTypeNmae());
//
//        } catch (Exception e) {
//            log.log(Level.SEVERE, "Failed to add photo", e);
//            throw new DataException("Failed to add photo\n" + getErrorString(e));
//
//        }
//
//        resp.setStatusCode(0);
//        return resp;
//    }
//    public ResponseDTO addAlert(AlertDTO alert) throws DataException {
//        ResponseDTO resp = new ResponseDTO();
//        try {
//            Alert a = new Alert();
//            a.setCategory(em.find(Category.class, alert.getCategoryID()));
//            a.setCity(em.find(City.class, alert.getCityID()));
//            a.setDescription(alert.getDescription());
//            a.setLatitude(alert.getLatitude());
//            a.setLongitude(alert.getLongitude());
//            a.setTitle(alert.getTitle());
//            a.setUpdated(new Date());
//            a.setAlertType(em.find(AlertType.class, alert.getAlertType().getAlertTypeID()));
//            
//            em.persist(a);
//            em.flush();
//            resp.setAlertList(new ArrayList<>());
//            resp.getAlertList().add(new AlertDTO(a));
//            log.log(Level.WARNING, "## alert added, id: {0}", a.getAlertID());
//
//        } catch (Exception e) {
//            log.log(Level.SEVERE, "Failed to login", e);
//            throw new DataException("Failed to login\n" + getErrorString(e));
//
//        }
//
//        resp.setStatusCode(0);
//        return resp;
//    }

    public String getErrorString(Exception e) {

        StringBuilder sb = new StringBuilder();
        try {
            if (e.getMessage() != null) {
                sb.append(e.getMessage()).append("\n\n");
            }
            if (e.toString() != null) {
                sb.append(e.toString()).append("\n\n");
            }
            StackTraceElement[] s = e.getStackTrace();
            if (s.length > 0) {
                StackTraceElement ss = s[0];
                String method = ss.getMethodName();
                String cls = ss.getClassName();
                int line = ss.getLineNumber();
                sb.append("Class: ").append(cls).append("\n");
                sb.append("Method: ").append(method).append("\n");
                sb.append("Line Number: ").append(line).append("\n");
            }
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Failed, ignored " + ex.getMessage());
        }

        return sb.toString();
    }

}
