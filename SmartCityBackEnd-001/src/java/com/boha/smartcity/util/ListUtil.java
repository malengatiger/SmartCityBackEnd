/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.util;

import com.boha.smartcity.data.Account;
import com.boha.smartcity.data.Alert;
import com.boha.smartcity.data.AlertType;
import com.boha.smartcity.data.ProfileInfo;
import com.boha.smartcity.dto.AccountDTO;
import com.boha.smartcity.dto.AlertDTO;
import com.boha.smartcity.dto.AlertTypeDTO;
import com.boha.smartcity.dto.ProfileInfoDTO;
import com.boha.smartcity.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aubreyM
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class ListUtil {
     @PersistenceContext
    EntityManager em;
     static final Logger log = Logger.getLogger(ListUtil.class.getSimpleName());
     
     public ResponseDTO login(String userName, String password, double latitude, double longitude) throws DataException {
         ResponseDTO resp = new ResponseDTO();
         try {
             Query q = em.createNamedQuery("ProfileInfo.login", ProfileInfo.class);
             q.setParameter("idNumber", userName);
             q.setParameter("password", password);
             q.setMaxResults(1);
             ProfileInfo pf = (ProfileInfo) q.getSingleResult();
             ProfileInfoDTO dto = new ProfileInfoDTO(pf);
             dto.setAccountList(getUserAccounts(pf.getProfileInfoID()));
             resp.setProfileInfoList(new ArrayList<>());
             resp.getProfileInfoList().add(dto);
             resp.setAlertList(getAlerts());
             resp.setAlertTypeList(getAlertTypeList());
             resp.setStatusCode(0);
             resp.setMessage("Successful login");
             
         } catch (NoResultException e) {
             resp.setStatusCode(9);
             resp.setMessage("Invalid userName or password");
             
         } catch (Exception e) {
             log.log(Level.SEVERE, "Failed to login", e);
             throw new DataException("Failed to login\n" + getErrorString(e));        
         }
         
         
         return resp;
     }
    
     public List<AlertTypeDTO> getAlertTypeList() throws DataException {
        List<AlertTypeDTO> list = new ArrayList<>();
          try {
             Query q = em.createNamedQuery("AlertType.findAll", AlertType.class);
             List<AlertType> pf =  q.getResultList();
              for (AlertType a : pf) {
                  list.add(new AlertTypeDTO(a));
              }
             
         } catch (Exception e) {
             log.log(Level.SEVERE, "Failed to login", e);
             throw new DataException("Failed to login\n" + getErrorString(e));        
         }
          
          
          return list; 
     }
      private List<AlertDTO> getAlerts() throws DataException {
          List<AlertDTO> list = new ArrayList<>();
          try {
             Query q = em.createNamedQuery("Alert.findAll", Alert.class);
             List<Alert> pf =  q.getResultList();
              for (Alert a : pf) {
                  list.add(new AlertDTO(a));
              }
             
         } catch (Exception e) {
             log.log(Level.SEVERE, "Failed to login", e);
             throw new DataException("Failed to login\n" + getErrorString(e));        
         }
          
          
          return list;
      }
      private List<AccountDTO> getUserAccounts(Integer profileInfoID) throws DataException {
          List<AccountDTO> list = new ArrayList<>();
          try {
             Query q = em.createNamedQuery("Account.findByProfileInfo", Account.class);
             q.setParameter("profileInfoID", profileInfoID);
             List<Account> pf =  q.getResultList();
              for (Account account : pf) {
                  list.add(new AccountDTO(account));
              }
             
         } catch (Exception e) {
             log.log(Level.SEVERE, "Failed to login", e);
             throw new DataException("Failed to login\n" + getErrorString(e));        
         }
          
          
          return list;
      }
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
