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
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import org.jboss.logging.Logger;

/**
 *
 * @author Rogers
 */
public class TestAPI {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        TestAPI http = new TestAPI();

        System.out.println("ISM Login - Going to Login the User");
        http.sendGet();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        try {
            String url = "http://41.160.126.146/esbapi/V2/userlogin?username=7406190168080&password=vatawa"
                    + "&latitude=-29.859701442126745&longitude=31.014404296875 ";
            //String url = "http://41.160.126.146/esbapi/V1/newsCategories ";
            System.out.println("ISM Login - URL: " + url);

            String name = "mobileapp";
            String password = "mobileapp";

            String authString = name + ":" + password;
            System.out.println("auth string: " + authString);
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("Base64 encoded auth string: " + authStringEnc);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setRequestProperty("Authorization", "Basic " + authStringEnc);

            int responseCode = con.getResponseCode();
            String responseMessage = con.getResponseMessage();

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Message : " + responseMessage);
        } catch (Exception e) {
            log.log(Logger.Level.FATAL, e);
        }

    }

    static final Logger log = Logger.getLogger("TestAPI");

}
