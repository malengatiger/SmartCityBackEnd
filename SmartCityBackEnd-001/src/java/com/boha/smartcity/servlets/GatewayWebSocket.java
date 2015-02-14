/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.smartcity.servlets;

import com.boha.smartcity.transfer.RequestDTO;
import com.boha.smartcity.transfer.ResponseDTO;
import com.boha.smartcity.util.DataUtil;
import com.boha.smartcity.util.GZipUtility;
import com.boha.smartcity.util.ListUtil;
import com.boha.smartcity.util.TrafficCop;
import com.boha.smartcity.util.AlertWorkerBee;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 * This websocket is the main entry point to the SmartCity Cloud Platform when the requestor uses the
 * websocket protocol to request services. The websocket expects a single parameter named JSON that contains 
 * a JSON string that is converted into a RequestDTO object instance.
 * 
 * The RequestDTO object is handed off to the TrafficCop EJB for processing. If the zipResponse
 * property is set to true, the ResponseDTO result is compressed before transfer.
 * 
 * The platform also supports requests made via the
 * websocket protocol. (see GatewayWebSocket).
 * 
 * @author aubreyM
 */
@ServerEndpoint("/wssmart")
@Stateless
public class GatewayWebSocket {

    @EJB
    DataUtil dataUtil;
    @EJB
    ListUtil listUtil;

    @EJB
    TrafficCop trafficCop;
    @EJB
    AlertWorkerBee bee;

    static final String SOURCE = "GatewayWebSocket";
    //TODO - clean up expired sessions!!!! - how?
    public static final Set<Session> peers
            = Collections.synchronizedSet(new HashSet<Session>());

    public void sendAlert(ResponseDTO alert) {
        int count = 0;
        for (Session session : peers) {
            try {
                session.getBasicRemote().sendBinary(GZipUtility.getZippedResponse(alert));
                count++;

            } catch (Exception ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
        log.log(Level.OFF, "Unsolicited alerts sent: {0}", count);

    }
    public void sendZippedResponse(ByteBuffer bb) {
        int count = 0;
        for (Session session : peers) {
            try {
                session.getBasicRemote().sendBinary(bb);
                count++;

            } catch (Exception ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
        log.log(Level.OFF, "Unsolicited alerts sent: {0}", count);

    }

    @OnMessage
    public ByteBuffer onMessage(String message) {
        log.log(Level.WARNING, "###### onMessage: {0}", message);
        ResponseDTO resp = new ResponseDTO();
        ByteBuffer bb = null;

        try {
            RequestDTO dto = gson.fromJson(message, RequestDTO.class);
            resp = trafficCop.processRequest(dto,
                    dataUtil, listUtil, bee);
            if (dto.getRequestType() == RequestDTO.ADD_ALERT) {
                resp.setMessage("ADDED");                
            }
            bb = GZipUtility.getZippedResponse(resp);
            
            if (dto.getRequestType() == RequestDTO.ADD_ALERT) {
                resp.setMessage("UNSOLICITED");
                sendZippedResponse(GZipUtility.getZippedResponse(resp));
                
            }
        } catch (Exception ex) {
            log.log(Level.SEVERE, null, ex);
            resp.setStatusCode(111);
            resp.setMessage("Problem processing request on server");
            try {
                bb = GZipUtility.getZippedResponse(resp);
            } catch (Exception ex1) {
                log.log(Level.SEVERE, "Failed to zip error response! What???", ex1);
                throw new UnsupportedOperationException("Failed to compress response");
            }
        }
        return bb;
    }

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
        try {
            ResponseDTO r = new ResponseDTO();
            r.setSessionID(session.getId());
            r.setStatusCode(0);
            session.getBasicRemote().sendText(gson.toJson(r));
            log.log(Level.WARNING, "########## onOpen...sent session id: {0}", session.getId());
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Failed to send websocket sessionID", ex);
        }
    }

    @OnClose
    public void onClose(Session session
    ) {
        log.log(Level.WARNING, "onClose - remove session: {0}", session.getId());
        for (Session mSession : peers) {
            if (session.getId().equalsIgnoreCase(mSession.getId())) {
                peers.remove(mSession);
                break;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable t) {
        log.log(Level.SEVERE, "### @OnError, websocket failed.......");
        try {
            ResponseDTO r = new ResponseDTO();
            r.setStatusCode(117);
            r.setMessage("Error encountered in cloud server");
            session.getBasicRemote().sendText(gson.toJson(r));
        } catch (IOException ex) {
            Logger.getLogger(GatewayWebSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Gson gson = new Gson();
    static final Logger log = Logger.getLogger(GatewayWebSocket.class.getSimpleName());
}
