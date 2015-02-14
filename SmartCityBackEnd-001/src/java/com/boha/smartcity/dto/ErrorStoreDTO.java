
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class ErrorStoreDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer errorStoreID;
    private int statusCode;
    private String message;
    private Date dateOccured;
    private String origin;

    public ErrorStoreDTO() {
    }

    public ErrorStoreDTO(Integer errorStoreID) {
        this.errorStoreID = errorStoreID;
    }

    public ErrorStoreDTO(ErrorStore a) {
        this.errorStoreID = a.getErrorStoreID();
        this.statusCode = a.getStatusCode();
        this.message = a.getMessage();
        this.dateOccured = a.getDateOccured();
        this.origin = a.getOrigin();
    }

    public Integer getErrorStoreID() {
        return errorStoreID;
    }

    public void setErrorStoreID(Integer errorStoreID) {
        this.errorStoreID = errorStoreID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOccured() {
        return dateOccured;
    }

    public void setDateOccured(Date dateOccured) {
        this.dateOccured = dateOccured;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorStoreID != null ? errorStoreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorStoreDTO)) {
            return false;
        }
        ErrorStoreDTO other = (ErrorStoreDTO) object;
        if ((this.errorStoreID == null && other.errorStoreID != null) || (this.errorStoreID != null && !this.errorStoreID.equals(other.errorStoreID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ErrorStore[ errorStoreID=" + errorStoreID + " ]";
    }
    
}
