
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class MunicipalityDTO implements Serializable {
    private String serviceURI;
    private List<ErrorStoreAndroidDTO> errorStoreAndroidList;
    private List<MunicipalityImageDTO> municipalityImageList;
    private List<GcmDeviceDTO> gcmDeviceList;
    private static final long serialVersionUID = 1L;
    private Integer municipalityID;
    private String municipalityName;
    private String email;
    private String cellphone;
    private Double latitude;
    private Double longitude;
    private Date dateRegistered;
    private Boolean activeFlag;
    private List<MunicipalityCityDTO> municipalityCityList;
    private List<AlertTypeDTO> alertTypeList;
    private List<NewsArticleDTO> newsArticleList;
    private List<ProfileInfoDTO> profileInfoList;
    private CountryDTO countryID;
    private List<NewsArticleTypeDTO> newsArticleTypeList;
    private List<MunicipalityStaffDTO> municipalityStaffList;
    private List<AlertDTO> alertList;
    private List<ComplaintDTO> complaintList;
    private List<ComplaintTypeDTO> complaintTypeList;
    private List<FaqDTO> faqList;

    public MunicipalityDTO() {
    }

    public MunicipalityDTO(Integer municipalityID) {
        this.municipalityID = municipalityID;
    }

    public MunicipalityDTO(Municipality a) {
        this.municipalityID = a.getMunicipalityID();
        this.municipalityName = a.getMunicipalityName();
        cellphone = a.getCellphone();
        email = a.getEmail();
        serviceURI = a.getServiceURI();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        dateRegistered = a.getDateRegistered();
        activeFlag = a.getActiveFlag();
    }

    public Boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<FaqDTO> getFaqList() {
        return faqList;
    }

    public void setFaqList(List<FaqDTO> faqList) {
        this.faqList = faqList;
    }
    

    public List<AlertTypeDTO> getAlertTypeList() {
        return alertTypeList;
    }

    public void setAlertTypeList(List<AlertTypeDTO> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }

    public List<NewsArticleDTO> getNewsArticleList() {
        return newsArticleList;
    }

    public void setNewsArticleList(List<NewsArticleDTO> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    public List<ProfileInfoDTO> getProfileInfoList() {
        return profileInfoList;
    }

    public void setProfileInfoList(List<ProfileInfoDTO> profileInfoList) {
        this.profileInfoList = profileInfoList;
    }

    public CountryDTO getCountryID() {
        return countryID;
    }

    public void setCountryID(CountryDTO countryID) {
        this.countryID = countryID;
    }

    public List<AlertDTO> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<AlertDTO> alertList) {
        this.alertList = alertList;
    }

    public List<ComplaintDTO> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<ComplaintDTO> complaintList) {
        this.complaintList = complaintList;
    }

    public List<ComplaintTypeDTO> getComplaintTypeList() {
        return complaintTypeList;
    }

    public void setComplaintTypeList(List<ComplaintTypeDTO> complaintTypeList) {
        this.complaintTypeList = complaintTypeList;
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

    public List<MunicipalityCityDTO> getMunicipalityCityList() {
        return municipalityCityList;
    }

    public void setMunicipalityCityList(List<MunicipalityCityDTO> municipalityCityList) {
        this.municipalityCityList = municipalityCityList;
    }


    public List<NewsArticleTypeDTO> getNewsArticleTypeList() {
        return newsArticleTypeList;
    }

    public void setNewsArticleTypeList(List<NewsArticleTypeDTO> newsArticleTypeList) {
        this.newsArticleTypeList = newsArticleTypeList;
    }

    public List<MunicipalityStaffDTO> getMunicipalityStaffList() {
        return municipalityStaffList;
    }

    public void setMunicipalityStaffList(List<MunicipalityStaffDTO> municipalityStaffList) {
        this.municipalityStaffList = municipalityStaffList;
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
        if (!(object instanceof MunicipalityDTO)) {
            return false;
        }
        MunicipalityDTO other = (MunicipalityDTO) object;
        if ((this.municipalityID == null && other.municipalityID != null) || (this.municipalityID != null && !this.municipalityID.equals(other.municipalityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Municipality[ municipalityID=" + municipalityID + " ]";
    }

    public List<ErrorStoreAndroidDTO> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroidDTO> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public List<MunicipalityImageDTO> getMunicipalityImageList() {
        return municipalityImageList;
    }

    public void setMunicipalityImageList(List<MunicipalityImageDTO> municipalityImageList) {
        this.municipalityImageList = municipalityImageList;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public String getServiceURI() {
        return serviceURI;
    }

    public void setServiceURI(String serviceURI) {
        this.serviceURI = serviceURI;
    }
    
}
