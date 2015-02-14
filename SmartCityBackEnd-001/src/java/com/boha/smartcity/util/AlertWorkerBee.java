/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.smartcity.util;

/**
 *
 * @author aubreyM
 */

import com.boha.smartcity.transfer.ResponseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AlertWorkerBee {

    @PersistenceContext
    EntityManager em;

    private PreparedStatement preparedStatement;
    
    //$mysql = "SELECT *, ( 3959 * acos( cos( radians('$search_lat') ) 
// * cos( radians( lat ) ) * cos( radians( longi ) - radians('$search_lng') ) 
//+ sin( radians('$search_lat') ) * sin( radians( lat ) ) ) ) AS distance FROM points HAVING distance < '$radius'";

    private static final String SQL_STATEMENT = "select a.alertID, a.description, a.latitude, a.longitude, a.title, alertTypeID, a.updated, "
            + "( ? * acos( cos( radians(?) ) * cos( radians( a.latitude) ) "
            + "* cos( radians( a.longitude ) - radians(?) ) + sin( radians(?) ) "
            + "* sin( radians( a.latitude ) ) ) ) "
            + "AS distance FROM alert a HAVING distance < ? order by a.updated desc";

    public static final int KILOMETRES = 1, MILES = 2, PARM_KM = 6371, PARM_MILES = 3959;

    private Connection conn;

    public ResponseDTO getAlertsWithinRadius(double latitude, double longitude,
            int radius, int type)
            throws Exception {
        if (conn == null || conn.isClosed()) {
            conn = em.unwrap(Connection.class);
            log.log(Level.INFO, "..........SQL Connection unwrapped from EntityManager");
        }
        if (preparedStatement == null || preparedStatement.isClosed()) {
            preparedStatement = conn.prepareStatement(SQL_STATEMENT);
            log.log(Level.INFO, "..........SQL Statement prepared from Connection");
        }
        switch (type) {
            case KILOMETRES:
                preparedStatement.setInt(1, PARM_KM);
                break;
            case MILES:
                preparedStatement.setInt(1, PARM_MILES);
                break;
            case 0:
                preparedStatement.setInt(1, PARM_KM);
                break;
        }
        ResultSet resultSet;
        preparedStatement.setDouble(2, latitude);
        preparedStatement.setDouble(3, longitude);
        preparedStatement.setDouble(4, latitude);
        preparedStatement.setInt(5, radius);
        resultSet = preparedStatement.executeQuery();
        return buildAlertList(resultSet);

    }

    private ResponseDTO buildAlertList(ResultSet resultSet) throws SQLException {
        ResponseDTO resp = new ResponseDTO();
//        List<AlertDTO> list = new ArrayList<>();
//        while (resultSet.next()) {
//            int id = resultSet.getInt("alertID");
//            Alert xx = em.find(Alert.class, id);
//            AlertDTO alert = new AlertDTO(xx);
//            alert.setPhotoUploadList(new ArrayList<>());
//            Query q = em.createNamedQuery("PhotoUpload.findByAlert", PhotoUpload.class);
//            q.setParameter("alertID", id);
//            List<PhotoUpload> pList = q.getResultList();
//
//            for (PhotoUpload a : pList) {
//                alert.getPhotoUploadList().add(new PhotoUploadDTO(a));
//            }
//            System.out.println("---- alert photos found: " + alert.getPhotoUploadList().size());
//            list.add(alert);
//        }
//        System.out.println("---- all alerts found: " + list.size());
//        resp.setAlertList(list);
//        resultSet.close();
        return resp;
    }

    public static final int ROWS_PER_PAGE = 100;
    static final Logger log = Logger.getLogger(AlertWorkerBee.class.getName());
}
