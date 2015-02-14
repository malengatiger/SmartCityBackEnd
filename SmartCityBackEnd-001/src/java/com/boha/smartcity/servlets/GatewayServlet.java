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
import com.oreilly.servlet.ServletUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aubreyM
 */
@WebServlet(name = "GatewayServlet", urlPatterns = {"/smart"})
public class GatewayServlet extends HttpServlet {

    @EJB
    DataUtil dataUtil;
    @EJB
    ListUtil listUtil;

    @EJB
    TrafficCop trafficCop;

    @EJB
    AlertWorkerBee bee;

    static final String SOURCE = "GatewayServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long start = System.currentTimeMillis();

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        RequestDTO dto = getRequest(gson, request);
        ResponseDTO resp = new ResponseDTO();
        resp.setStatusCode(0);
        log.log(Level.INFO, "{0} started ..requestType: {1}",
                new Object[]{GatewayServlet.class.getSimpleName(), dto.getRequestType()});
        try {
            resp = trafficCop.processRequest(dto,
                    dataUtil, listUtil, bee);
        } finally {         
            String json = gson.toJson(resp);
            if (dto.isZipResponse()) {
                try {
                    File zipped;
                    response.setContentType("application/zip;charset=UTF-8");
                    zipped = GZipUtility.getZipped(json);
                    ServletUtils.returnFile(zipped.getAbsolutePath(), response.getOutputStream());
                    response.getOutputStream().close();
                    log.log(Level.OFF, "### Zipped Length of Response: {0} -  "
                            + "unzipped length: {1}", new Object[]{zipped.length(), json.length()});
                } catch (Exception e) {
                    log.log(Level.SEVERE, "Zipping problem - probably the zipper cannot find the zipped file", e);
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");                
                out.println(json);
                out.close();
            }

            
            long end = System.currentTimeMillis();
            log.log(Level.INFO, "---> GatewayServlet completed in {0} seconds", getElapsed(start, end));
        }
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }

    private RequestDTO getRequest(Gson gson, HttpServletRequest req) {
        RequestDTO cr = new RequestDTO();
        String json = req.getParameter("JSON");
        if (json == null) {
            return cr;
        }
        try {
            cr = gson.fromJson(json, RequestDTO.class);

        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed JSON", e);
        }
        return cr;
    }
    private static final Logger log = Logger.getLogger(GatewayServlet.class.getSimpleName());
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
