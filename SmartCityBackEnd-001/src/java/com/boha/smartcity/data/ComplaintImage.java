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
@Table(name = "complaintImage")
@NamedQueries({
    @NamedQuery(name = "ComplaintImage.findAll", query = "SELECT c FROM ComplaintImage c"),
    @NamedQuery(name = "ComplaintImage.findByComplaintImageID", query = "SELECT c FROM ComplaintImage c WHERE c.complaintImageID = :complaintImageID"),
    @NamedQuery(name = "ComplaintImage.findByFileName", query = "SELECT c FROM ComplaintImage c WHERE c.fileName = :fileName"),
    @NamedQuery(name = "ComplaintImage.findByDateUploaded", query = "SELECT c FROM ComplaintImage c WHERE c.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "ComplaintImage.findByDateTaken", query = "SELECT c FROM ComplaintImage c WHERE c.dateTaken = :dateTaken"),
    @NamedQuery(name = "ComplaintImage.findByLatitude", query = "SELECT c FROM ComplaintImage c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "ComplaintImage.findByLongitude", query = "SELECT c FROM ComplaintImage c WHERE c.longitude = :longitude")})
public class ComplaintImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complaintImageID")
    private Integer complaintImageID;
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
    @JoinColumn(name = "complaintID", referencedColumnName = "complaintID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Complaint complaint;

    public ComplaintImage() {
    }

    public ComplaintImage(Integer complaintImageID) {
        this.complaintImageID = complaintImageID;
    }

    public ComplaintImage(Integer complaintImageID, String fileName, Date dateUploaded, Date dateTaken) {
        this.complaintImageID = complaintImageID;
        this.fileName = fileName;
        this.dateUploaded = dateUploaded;
        this.dateTaken = dateTaken;
    }

    public Integer getComplaintImageID() {
        return complaintImageID;
    }

    public void setComplaintImageID(Integer complaintImageID) {
        this.complaintImageID = complaintImageID;
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

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintImageID != null ? complaintImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintImage)) {
            return false;
        }
        ComplaintImage other = (ComplaintImage) object;
        if ((this.complaintImageID == null && other.complaintImageID != null) || (this.complaintImageID != null && !this.complaintImageID.equals(other.complaintImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ComplaintImage[ complaintImageID=" + complaintImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
