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
@Table(name = "profileImage")
@NamedQueries({
    @NamedQuery(name = "ProfileImage.findAll", query = "SELECT p FROM ProfileImage p"),
    @NamedQuery(name = "ProfileImage.findByProfileImageID", query = "SELECT p FROM ProfileImage p WHERE p.profileImageID = :profileImageID"),
    @NamedQuery(name = "ProfileImage.findByFileName", query = "SELECT p FROM ProfileImage p WHERE p.fileName = :fileName"),
    @NamedQuery(name = "ProfileImage.findByDateTaken", query = "SELECT p FROM ProfileImage p WHERE p.dateTaken = :dateTaken"),
    @NamedQuery(name = "ProfileImage.findByDateUploaded", query = "SELECT p FROM ProfileImage p WHERE p.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "ProfileImage.findByLatitude", query = "SELECT p FROM ProfileImage p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "ProfileImage.findByLongitude", query = "SELECT p FROM ProfileImage p WHERE p.longitude = :longitude")})
public class ProfileImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profileImageID")
    private Integer profileImageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 105)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTaken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "profileInfoID", referencedColumnName = "profileInfoID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfileInfo profileInfo;

    public ProfileImage() {
    }

    public ProfileImage(Integer profileImageID) {
        this.profileImageID = profileImageID;
    }

    public ProfileImage(Integer profileImageID, String fileName, Date dateTaken, Date dateUploaded) {
        this.profileImageID = profileImageID;
        this.fileName = fileName;
        this.dateTaken = dateTaken;
        this.dateUploaded = dateUploaded;
    }

    public Integer getProfileImageID() {
        return profileImageID;
    }

    public void setProfileImageID(Integer profileImageID) {
        this.profileImageID = profileImageID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
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

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileImageID != null ? profileImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileImage)) {
            return false;
        }
        ProfileImage other = (ProfileImage) object;
        if ((this.profileImageID == null && other.profileImageID != null) || (this.profileImageID != null && !this.profileImageID.equals(other.profileImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ProfileImage[ profileImageID=" + profileImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
