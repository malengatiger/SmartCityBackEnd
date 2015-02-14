/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Entity
@Table(name = "alertImage")
@NamedQueries({
    @NamedQuery(name = "AlertImage.findAll", query = "SELECT a FROM AlertImage a"),
    @NamedQuery(name = "AlertImage.findByAlertImageID", query = "SELECT a FROM AlertImage a WHERE a.alertImageID = :alertImageID"),
    @NamedQuery(name = "AlertImage.findByFileName", query = "SELECT a FROM AlertImage a WHERE a.fileName = :fileName"),
    @NamedQuery(name = "AlertImage.findByDateUploaded", query = "SELECT a FROM AlertImage a WHERE a.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "AlertImage.findByDateTaken", query = "SELECT a FROM AlertImage a WHERE a.dateTaken = :dateTaken"),
    @NamedQuery(name = "AlertImage.findByLatitude", query = "SELECT a FROM AlertImage a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "AlertImage.findByLongitude", query = "SELECT a FROM AlertImage a WHERE a.longitude = :longitude")})
public class AlertImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alertImageID")
    private Integer alertImageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 105)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTaken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "alertID", referencedColumnName = "alertID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alert alert;

    public AlertImage() {
    }

    public AlertImage(Integer alertImageID) {
        this.alertImageID = alertImageID;
    }

    public AlertImage(Integer alertImageID, String fileName, Date dateUploaded, Date dateTaken) {
        this.alertImageID = alertImageID;
        this.fileName = fileName;
        this.dateUploaded = dateUploaded;
        this.dateTaken = dateTaken;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public Integer getAlertImageID() {
        return alertImageID;
    }

    public void setAlertImageID(Integer alertImageID) {
        this.alertImageID = alertImageID;
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
        hash += (alertImageID != null ? alertImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertImage)) {
            return false;
        }
        AlertImage other = (AlertImage) object;
        if ((this.alertImageID == null && other.alertImageID != null) || (this.alertImageID != null && !this.alertImageID.equals(other.alertImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.AlertImage[ alertImageID=" + alertImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
