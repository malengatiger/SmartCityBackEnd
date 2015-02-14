/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "municipality")
@NamedQueries({
    @NamedQuery(name = "Municipality.findAll", query = "SELECT m FROM Municipality m"),
    @NamedQuery(name = "Municipality.findByMunicipalityID", query = "SELECT m FROM Municipality m WHERE m.municipalityID = :municipalityID"),
    @NamedQuery(name = "Municipality.findByMunicipalityName", query = "SELECT m FROM Municipality m WHERE m.municipalityName = :municipalityName"),
    @NamedQuery(name = "Municipality.findByEmail", query = "SELECT m FROM Municipality m WHERE m.email = :email"),
    @NamedQuery(name = "Municipality.findByCellphone", query = "SELECT m FROM Municipality m WHERE m.cellphone = :cellphone"),
    @NamedQuery(name = "Municipality.findByLatitude", query = "SELECT m FROM Municipality m WHERE m.latitude = :latitude"),
    @NamedQuery(name = "Municipality.findByLongitude", query = "SELECT m FROM Municipality m WHERE m.longitude = :longitude"),
    @NamedQuery(name = "Municipality.findByDateRegistered", query = "SELECT m FROM Municipality m WHERE m.dateRegistered = :dateRegistered")})
public class Municipality implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @Size(max = 200)
    @Column(name = "serviceURI")
    private String serviceURI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<ErrorStoreAndroid> errorStoreAndroidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<MunicipalityImage> municipalityImageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<GcmDevice> gcmDeviceList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipalityID")
    private Integer municipalityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "municipalityName")
    private String municipalityName;
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<MunicipalityCity> municipalityCityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<AlertType> alertTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muncipality", fetch = FetchType.LAZY)
    private List<NewsArticle> newsArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<ProfileInfo> profileInfoList;
    @JoinColumn(name = "countryID", referencedColumnName = "countryID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<NewsArticleType> newsArticleTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<MunicipalityStaff> municipalityStaffList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<Alert> alertList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<Complaint> complaintList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<ComplaintType> complaintTypeList;

    public Municipality() {
    }

    public Municipality(Integer municipalityID) {
        this.municipalityID = municipalityID;
    }

    public Municipality(Integer municipalityID, String municipalityName) {
        this.municipalityID = municipalityID;
        this.municipalityName = municipalityName;
    }

    public Integer getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(Integer municipalityID) {
        this.municipalityID = municipalityID;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<MunicipalityCity> getMunicipalityCityList() {
        return municipalityCityList;
    }

    public void setMunicipalityCityList(List<MunicipalityCity> municipalityCityList) {
        this.municipalityCityList = municipalityCityList;
    }

    public List<AlertType> getAlertTypeList() {
        return alertTypeList;
    }

    public void setAlertTypeList(List<AlertType> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }

    public List<NewsArticle> getNewsArticleList() {
        return newsArticleList;
    }

    public void setNewsArticleList(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    public List<ProfileInfo> getProfileInfoList() {
        return profileInfoList;
    }

    public void setProfileInfoList(List<ProfileInfo> profileInfoList) {
        this.profileInfoList = profileInfoList;
    }


    public List<NewsArticleType> getNewsArticleTypeList() {
        return newsArticleTypeList;
    }

    public void setNewsArticleTypeList(List<NewsArticleType> newsArticleTypeList) {
        this.newsArticleTypeList = newsArticleTypeList;
    }

    public List<MunicipalityStaff> getMunicipalityStaffList() {
        return municipalityStaffList;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setMunicipalityStaffList(List<MunicipalityStaff> municipalityStaffList) {
        this.municipalityStaffList = municipalityStaffList;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public List<ComplaintType> getComplaintTypeList() {
        return complaintTypeList;
    }

    public void setComplaintTypeList(List<ComplaintType> complaintTypeList) {
        this.complaintTypeList = complaintTypeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipalityID != null ? municipalityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipality)) {
            return false;
        }
        Municipality other = (Municipality) object;
        if ((this.municipalityID == null && other.municipalityID != null) || (this.municipalityID != null && !this.municipalityID.equals(other.municipalityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Municipality[ municipalityID=" + municipalityID + " ]";
    }

    public List<ErrorStoreAndroid> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroid> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public List<MunicipalityImage> getMunicipalityImageList() {
        return municipalityImageList;
    }

    public void setMunicipalityImageList(List<MunicipalityImage> municipalityImageList) {
        this.municipalityImageList = municipalityImageList;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public String getServiceURI() {
        return serviceURI;
    }

    public void setServiceURI(String serviceURI) {
        this.serviceURI = serviceURI;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
