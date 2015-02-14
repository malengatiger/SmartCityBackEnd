/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boha.smartcity.servlets;

import com.boha.smartcity.transfer.RequestDTO;
import com.boha.smartcity.transfer.ResponseDTO;
import com.boha.smartcity.util.DataUtil;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * This servlet accepts image files uploaded from SmartCity devices and saves
 * them on disk according to the type of image being downloaded.
 * 
 * After image downloaded, the appropriate image record is inserted into
 * the SmartCity database
 *
 * @author aubreyM
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/photo"})
public class PhotoServlet extends HttpServlet {

    @EJB
    DataUtil dataUtil;

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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        long start = System.currentTimeMillis();

        ResponseDTO ur = new ResponseDTO();
        String json;
        Gson gson = new Gson();
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                //ur = downloadPhotos(request);
                ur.setStatusCode(0);
            } else {
                RequestDTO dto = getRequest(gson, request);
                switch (dto.getRequestType()) {

                }

            }

//        } catch (FileUploadException ex) {
//            logger.log(Level.SEVERE, "File upload fucked", ex);
//            ur.setStatusCode(111);
//            ur.setMessage("Error. Unable to download file(s) sent. Contact Support");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Servlet file upload fucked", e);
            ur.setStatusCode(113);
            ur.setMessage("Error. Generic server exception");

        } finally {
            json = gson.toJson(ur);
            out.println(json);
            out.close();
            long end = System.currentTimeMillis();
            logger.log(Level.INFO, "PhotoServlet done, elapsed: {0} seconds", getElapsed(start, end));
        }
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    static final Logger logger = Logger.getLogger("PhotoServlet");

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

    private RequestDTO getRequest(Gson gson, HttpServletRequest req) {

        String json = req.getParameter("JSON");
        RequestDTO cr = gson.fromJson(json, RequestDTO.class);

        if (cr == null) {
            cr = new RequestDTO();
        }

        return cr;
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

//    // ################################################################
//    public ResponseDTO downloadPhotos(HttpServletRequest request) throws FileUploadException {
//        logger.log(Level.INFO, "######### starting PHOTO DOWNLOAD process\n\n");
//        ResponseDTO resp = new ResponseDTO();
//        resp.setStatusCode(0);
//        InputStream stream = null;
//        File rootDir;
//        try {
//            rootDir = SmartProperties.getImageDir();
//            if (!rootDir.exists()) {
//                rootDir.mkdir();
//            }
//        } catch (Exception ex) {
//            logger.log(Level.SEVERE, "Properties file problem", ex);
//            resp.setMessage("Server file unavailable. Please try later");
//            resp.setStatusCode(114);
//
//            return resp;
//        }
//
//        PhotoUploadDTO dto = null;
//        Gson gson = new Gson();
//        File cityDir = null, alertDir = null;
//        try {
//            ServletFileUpload upload = new ServletFileUpload();
//            FileItemIterator iter = upload.getItemIterator(request);
//            while (iter.hasNext()) {
//                FileItemStream item = iter.next();
//                String name = item.getFieldName();
//                stream = item.openStream();
//                if (item.isFormField()) {
//                    if (name.equalsIgnoreCase("JSON")) {
//                        String json = Streams.asString(stream);
//                        if (json != null) {
//                            logger.log(Level.INFO, "picture with associated json: {0}", json);
//                            dto = gson.fromJson(json, PhotoUploadDTO.class);
//                            if (dto != null) {
//                                cityDir = createCityDirectory(rootDir, cityDir, dto.getCityID());
//                                alertDir = createAlertDirectory(cityDir, alertDir, dto.getAlertID());
//
//                            }
//                        } else {
//                            logger.log(Level.WARNING, "JSON input seems pretty fucked up! is NULL..");
//                            resp.setStatusCode(116);
//                            resp.setMessage("Invalid request JSON");
//                            return resp;
//                        }
//                    }
//                } else {
//                    File imageFile = null;
//                    if (dto == null) {
//                        continue;
//                    }
//                    DateTime dt = new DateTime();
//                    String fileName = "t" + dt.getMillis() + ".jpg";
//
//                    imageFile = new File(alertDir, fileName);
//
//                    writeFile(stream, imageFile);
//                    resp.setStatusCode(0);
//                    resp.setMessage("Photo downloaded from mobile app ");
//                    //add database
//                    logger.log(Level.SEVERE, "image downloaded OK: {0}", imageFile.getAbsolutePath());
//                    dto.setUri(imageFile.getName());
//                    dto.setDateUploaded(new Date());
//
//                    try {
//                        if (dto.getDateTaken() == null) {
//                            dto.setDateTaken(new Date());
//                        }
//                        dataUtil.addPhotoUpload(dto);
//                    } catch (DataException ex) {
//                        Logger.getLogger(PhotoServlet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    resp.setStatusCode(0);
//
//                }
//            }
//
//        } catch (FileUploadException | IOException | JsonSyntaxException ex) {
//            logger.log(Level.SEVERE, "Servlet failed on IOException, images NOT uploaded", ex);
//            throw new FileUploadException();
//        }
//
//        return resp;
//    }

    private File createAlertDirectory(File cityDir, File alertDir, int id) {
        alertDir = new File(cityDir, "alert" + id);
        //logger.log(Level.INFO, "just after new {0}", staffDir);
        if (!alertDir.exists()) {
            alertDir.mkdir();
            logger.log(Level.INFO, "alertDir created - {0}",
                    alertDir.getAbsolutePath());

        }
        return alertDir;
    }

    private File createCityDirectory(File rootDir, File cityDir, int id) {
        cityDir = new File(rootDir, "city" + id);
        if (!cityDir.exists()) {
            cityDir.mkdir();
            logger.log(Level.INFO, "cityDir directory created - {0}",
                    cityDir.getAbsolutePath());
        }

        return cityDir;
    }

    private void writeFile(InputStream stream, File imageFile) throws FileNotFoundException, IOException {

        if (imageFile == null) {
            throw new FileNotFoundException();
        }
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            int read;
            byte[] bytes = new byte[2048];
            while ((read = stream.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            stream.close();
            fos.flush();
        }

        logger.log(Level.WARNING, "### File downloaded: {0} size: {1}",
                new Object[]{imageFile.getAbsolutePath(), imageFile.length()});
    }
}
