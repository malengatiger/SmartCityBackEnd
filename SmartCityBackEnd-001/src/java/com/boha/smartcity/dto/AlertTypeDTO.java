
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class AlertTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer alertTypeID;
    private String alertTypeName;
    private Integer color;

    public AlertTypeDTO() {
    }

    public AlertTypeDTO(AlertType a) {
        this.alertTypeID = a.getAlertTypeID();
        this.alertTypeName = a.getAlertTypeNmae();
        color = a.getColor();
    }

  
    public Integer getAlertTypeID() {
        return alertTypeID;
    }

    public void setAlertTypeID(Integer alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public String getAlertTypeNmae() {
        return alertTypeName;
    }

    public void setAlertTypeNmae(String alertTypeNmae) {
        this.alertTypeName = alertTypeNmae;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertTypeID != null ? alertTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertTypeDTO)) {
            return false;
        }
        AlertTypeDTO other = (AlertTypeDTO) object;
        if ((this.alertTypeID == null && other.alertTypeID != null) || (this.alertTypeID != null && !this.alertTypeID.equals(other.alertTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.AlertType[ alertTypeID=" + alertTypeID + " ]";
    }
    
}
