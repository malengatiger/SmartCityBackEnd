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
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;

public class CommsUtil {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        sendGet();
    }

    // HTTP GET request
    private static void sendGet() throws Exception {

        String url = "http://41.160.126.146/esbapi/V2/userlogin?username=7406190168080&password=vatawa&latitude=-29.859701442126745&longitude=31.014404296875 ";
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
        StringBuilder sb = new StringBuilder();
        String response = null;
        InputStream is = con.getInputStream();
        GZIPInputStream zis;
        try {
            if ("gzip".equals(con.getContentEncoding())) {
                zis = new GZIPInputStream(is);
                decompress(zis);
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            response = sb.toString();
            

        } catch (IOException e) {
            System.out.println("Unable to de-compress zipped file");
            e.printStackTrace();
        }

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        System.out.println("Response Message : " + responseMessage);

    }
    static final int BUFFER = 2048;

    public static String decompress(GZIPInputStream in) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        String resp;
        try {
            ByteArrayOutputStream contents = new ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            int len, totalLen = 0;

            while ((len = in.read(buf)) > 0) {
                contents.write(buf, 0, len);
                totalLen += len;
            }
            resp = contents.toString();
//            JSONObject obj = new JSONObject(resp);
//            boolean isNull = obj.isNull("ProfileInfo");
//            if (!isNull) {
//                String s = obj.getString("ProfileInfo");
//                System.out.println(s);
//            }
            
            System.out.println(resp);
        } finally {
            in.close();
        }
    
    return null;
    }
    static Gson gson = new Gson();
}
