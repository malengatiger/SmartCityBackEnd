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
@Entity
@Table(name = "complaint")
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c"),
    @NamedQuery(name = "Complaint.findByComplaintID", query = "SELECT c FROM Complaint c WHERE c.complaintID = :complaintID"),
    @NamedQuery(name = "Complaint.findByComplaintDate", query = "SELECT c FROM Complaint c WHERE c.complaintDate = :complaintDate"),
    @NamedQuery(name = "Complaint.findByLatitude", query = "SELECT c FROM Complaint c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Complaint.findByLongitude", query = "SELECT c FROM Complaint c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Complaint.findByActiveFlag", query = "SELECT c FROM Complaint c WHERE c.activeFlag = :activeFlag")})
public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complaintID")
    private Integer complaintID;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "complaintDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date complaintDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @JoinColumn(name = "profileInfoID", referencedColumnName = "profileInfoID")
    @ManyToOne(optional = false)
    private ProfileInfo profileInfo;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false)
    private City city;
    @JoinColumn(name = "complaintTypeID", referencedColumnName = "complaintTypeID")
    @ManyToOne(optional = false)
    private ComplaintType complaintType;

    public Complaint() {
    }

    public Complaint(Integer complaintID) {
        this.complaintID = complaintID;
    }

    public Complaint(Integer complaintID, Date complaintDate) {
        this.complaintID = complaintID;
        this.complaintDate = complaintDate;
    }

    public Integer getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(Integer complaintID) {
        this.complaintID = complaintID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
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

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ComplaintType getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(ComplaintType complaintType) {
        this.complaintType = complaintType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintID != null ? complaintID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.complaintID == null && other.complaintID != null) || (this.complaintID != null && !this.complaintID.equals(other.complaintID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Complaint[ complaintID=" + complaintID + " ]";
    }
    
}
