/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
public class AlertDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer alertID;
    private Date updated;
    private Integer id;
    private String description, categoryName;
    private String title;
    private Double latitude;
    private Double longitude;
    private String thumbnailURL;
    private String href;
    private Boolean activeFlag;
    private Integer categoryID;
    private Integer cityID;

    public AlertDTO() {
    }

    public AlertDTO(Alert a) {
        this.alertID = a.getAlertID();
        this.updated = a.getUpdated();
        id = a.getId();
        description = a.getDescription();
        categoryID = a.getCategory().getCategoryID();
        categoryName = a.getCategory().getCategoryName();
        title = a.getTitle();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        thumbnailURL = a.getThumbnailURL();
        href = a.getHref();
        activeFlag = a.getActiveFlag();
        cityID = a.getCity().getCityID();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getAlertID() {
        return alertID;
    }

    public void setAlertID(Integer alertID) {
        this.alertID = alertID;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertID != null ? alertID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertDTO)) {
            return false;
        }
        AlertDTO other = (AlertDTO) object;
        if ((this.alertID == null && other.alertID != null) || (this.alertID != null && !this.alertID.equals(other.alertID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Alert[ alertID=" + alertID + " ]";
    }
    
}
