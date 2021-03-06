
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class MunicipalityImageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer municipalityImageID;
    private String fileName;
    private Date dateUploaded;
    private Date dateTaken;
    private Double latitude;
    private Double longitude;
    private Integer municipalityID;
    private Boolean activeFlag;

    public MunicipalityImageDTO() {
    }

    public MunicipalityImageDTO(Integer municipalityImageID) {
        this.municipalityImageID = municipalityImageID;
    }

    public MunicipalityImageDTO(MunicipalityImage a) {
        this.municipalityImageID = a.getMunicipalityImageID();
        this.fileName = a.getFileName();
        this.dateUploaded = a.getDateUploaded();
        this.dateTaken = a.getDateTaken();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        activeFlag = a.getActiveFlag();
    }

    public Boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    
    public Integer getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(Integer municipalityID) {
        this.municipalityID = municipalityID;
    }

    public Integer getMunicipalityImageID() {
        return municipalityImageID;
    }

    public void setMunicipalityImageID(Integer municipalityImageID) {
        this.municipalityImageID = municipalityImageID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipalityImageID != null ? municipalityImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipalityImageDTO)) {
            return false;
        }
        MunicipalityImageDTO other = (MunicipalityImageDTO) object;
        if ((this.municipalityImageID == null && other.municipalityImageID != null) || (this.municipalityImageID != null && !this.municipalityImageID.equals(other.municipalityImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.MunicipalityImage[ municipalityImageID=" + municipalityImageID + " ]";
    }
    
}
