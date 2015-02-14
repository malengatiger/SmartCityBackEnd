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
@Table(name = "gcmDevice")
@NamedQueries({
    @NamedQuery(name = "GcmDevice.findAll", query = "SELECT g FROM GcmDevice g"),
    @NamedQuery(name = "GcmDevice.findByGcmDeviceID", query = "SELECT g FROM GcmDevice g WHERE g.gcmDeviceID = :gcmDeviceID"),
    @NamedQuery(name = "GcmDevice.findByManufacturer", query = "SELECT g FROM GcmDevice g WHERE g.manufacturer = :manufacturer"),
    @NamedQuery(name = "GcmDevice.findByModel", query = "SELECT g FROM GcmDevice g WHERE g.model = :model"),
    @NamedQuery(name = "GcmDevice.findByMessageCount", query = "SELECT g FROM GcmDevice g WHERE g.messageCount = :messageCount"),
    @NamedQuery(name = "GcmDevice.findByDateRegistered", query = "SELECT g FROM GcmDevice g WHERE g.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "GcmDevice.findBySerialNumber", query = "SELECT g FROM GcmDevice g WHERE g.serialNumber = :serialNumber"),
    @NamedQuery(name = "GcmDevice.findByAndroidVersion", query = "SELECT g FROM GcmDevice g WHERE g.androidVersion = :androidVersion")})
public class GcmDevice implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gcmDeviceID")
    private Integer gcmDeviceID;
    @Size(max = 45)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Column(name = "messageCount")
    private Integer messageCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Size(max = 105)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Size(max = 45)
    @Column(name = "androidVersion")
    private String androidVersion;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;
    @JoinColumn(name = "municipalityStaffID", referencedColumnName = "municipalityStaffID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MunicipalityStaff municipalityStaff;
    @JoinColumn(name = "profileInfoID", referencedColumnName = "profileInfoID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProfileInfo profileInfo;

    public GcmDevice() {
    }

    public GcmDevice(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public GcmDevice(Integer gcmDeviceID, Date dateRegistered) {
        this.gcmDeviceID = gcmDeviceID;
        this.dateRegistered = dateRegistered;
    }

    public Integer getGcmDeviceID() {
        return gcmDeviceID;
    }

    public void setGcmDeviceID(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public MunicipalityStaff getMunicipalityStaff() {
        return municipalityStaff;
    }

    public void setMunicipalityStaff(MunicipalityStaff municipalityStaff) {
        this.municipalityStaff = municipalityStaff;
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
        hash += (gcmDeviceID != null ? gcmDeviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GcmDevice)) {
            return false;
        }
        GcmDevice other = (GcmDevice) object;
        if ((this.gcmDeviceID == null && other.gcmDeviceID != null) || (this.gcmDeviceID != null && !this.gcmDeviceID.equals(other.gcmDeviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.GcmDevice[ gcmDeviceID=" + gcmDeviceID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
