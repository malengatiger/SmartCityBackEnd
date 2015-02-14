/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.transfer;

import com.boha.smartcity.dto.AlertDTO;
import com.boha.smartcity.dto.ComplaintDTO;

/**
 *
 * @author aubreyM
 */
public class RequestDTO {
    private int requestType, radius;
    private String userName, password;
    private double latitude, longitude;
    private AlertDTO alert;
    private boolean zipResponse;
    
    private ComplaintDTO complaint;
    
    public static final int LOGIN = 1,
            ADD_ALERT = 2,
            GET_ALERTS = 3;

    public boolean isZipResponse() {
        return zipResponse;
    }

    public void setZipResponse(boolean zipResponse) {
        this.zipResponse = zipResponse;
    }

    
    public int getRequestType() {
        return requestType;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getUserName() {
        return userName;
    }

    public AlertDTO getAlert() {
        return alert;
    }

    public void setAlert(AlertDTO alert) {
        this.alert = alert;
    }

    public ComplaintDTO getComplaint() {
        return complaint;
    }

    public void setComplaint(ComplaintDTO complaint) {
        this.complaint = complaint;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
}
