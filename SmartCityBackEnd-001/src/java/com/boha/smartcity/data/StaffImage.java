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
@Table(name = "staffImage")
@NamedQueries({
    @NamedQuery(name = "StaffImage.findAll", query = "SELECT s FROM StaffImage s"),
    @NamedQuery(name = "StaffImage.findByStaffImageID", query = "SELECT s FROM StaffImage s WHERE s.staffImageID = :staffImageID"),
    @NamedQuery(name = "StaffImage.findByFileName", query = "SELECT s FROM StaffImage s WHERE s.fileName = :fileName"),
    @NamedQuery(name = "StaffImage.findByDateUploaded", query = "SELECT s FROM StaffImage s WHERE s.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "StaffImage.findByDateTaken", query = "SELECT s FROM StaffImage s WHERE s.dateTaken = :dateTaken"),
    @NamedQuery(name = "StaffImage.findByLatitude", query = "SELECT s FROM StaffImage s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "StaffImage.findByLongitude", query = "SELECT s FROM StaffImage s WHERE s.longitude = :longitude")})
public class StaffImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staffImageID")
    private Integer staffImageID;
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
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "municipalityStaffID", referencedColumnName = "municipalityStaffID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MunicipalityStaff municipalityStaff;

    public StaffImage() {
    }

    public StaffImage(Integer staffImageID) {
        this.staffImageID = staffImageID;
    }

    public StaffImage(Integer staffImageID, String fileName, Date dateUploaded, Date dateTaken) {
        this.staffImageID = staffImageID;
        this.fileName = fileName;
        this.dateUploaded = dateUploaded;
        this.dateTaken = dateTaken;
    }

    public Integer getStaffImageID() {
        return staffImageID;
    }

    public void setStaffImageID(Integer staffImageID) {
        this.staffImageID = staffImageID;
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

    public MunicipalityStaff getMunicipalityStaff() {
        return municipalityStaff;
    }

    public void setMunicipalityStaff(MunicipalityStaff municipalityStaff) {
        this.municipalityStaff = municipalityStaff;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffImageID != null ? staffImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffImage)) {
            return false;
        }
        StaffImage other = (StaffImage) object;
        if ((this.staffImageID == null && other.staffImageID != null) || (this.staffImageID != null && !this.staffImageID.equals(other.staffImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.StaffImage[ staffImageID=" + staffImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
