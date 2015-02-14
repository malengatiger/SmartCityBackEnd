
package com.boha.smartcity.transfer;

import com.boha.smartcity.dto.AccountDTO;
import com.boha.smartcity.dto.AlertDTO;
import com.boha.smartcity.dto.AlertTypeDTO;
import com.boha.smartcity.dto.CityDTO;
import com.boha.smartcity.dto.ComplaintDTO;
import com.boha.smartcity.dto.ComplaintTypeDTO;
import com.boha.smartcity.dto.ComplaintUpdateStatusDTO;
import com.boha.smartcity.dto.CountryDTO;
import com.boha.smartcity.dto.CustomerStatusDTO;
import com.boha.smartcity.dto.CustomerTypeDTO;
import com.boha.smartcity.dto.ErrorStoreAndroidDTO;
import com.boha.smartcity.dto.ErrorStoreDTO;
import com.boha.smartcity.dto.GcmDeviceDTO;
import com.boha.smartcity.dto.MunicipalityDTO;
import com.boha.smartcity.dto.MunicipalityStaffDTO;
import com.boha.smartcity.dto.NewsArticleDTO;
import com.boha.smartcity.dto.NewsArticleTypeDTO;
import com.boha.smartcity.dto.ProfileInfoDTO;
import com.boha.smartcity.dto.ProvinceDTO;
import com.boha.smartcity.dto.StaffTypeDTO;
import java.util.List;

/**
 * This class represents the response from the server. A status code of 0 indicates
 * successful completion of the request. An non-zero status code indicates an error that is 
 * described in the message property.
 * 
 * SmartCity Cloud Platform application always returns an object of this class.
 * 
 * If incoming request had zipResponse set to true, this object will be compressed by GZip.
 * 
 * @author aubreyM
 */
public class ResponseDTO {
    //response status
    private int statusCode;
    private String message, sessionID;
    private double requestResponseTimeSeconds;
    
    //response lists
    private List<AlertDTO> alertList;
    private List<AccountDTO> accountList;
    private List<ProfileInfoDTO> profileInfoList;
    private List<ComplaintTypeDTO> complaintTypeList;
    private List<ComplaintDTO> complaintList;
    private List<AlertTypeDTO> alertTypeList;
    private List<CityDTO> cityList;
    private List<ProvinceDTO> provinceList;
    private List<ComplaintUpdateStatusDTO> complaintUpdateStatusList;
    private List<CountryDTO> countryList;
    private List<CustomerStatusDTO> customerStatusList;
    private List<CustomerTypeDTO> customerTypeList;
    private List<ErrorStoreDTO> errorStoreList;
    private List<ErrorStoreAndroidDTO> errorStoreAndroidList;
    private List<GcmDeviceDTO> gcmDeviceList;
    private List<MunicipalityDTO> municipalityList;
    private List<MunicipalityStaffDTO> municipalityStaffList;
    private List<NewsArticleTypeDTO> newsArticleTypeList;
    private List<NewsArticleDTO> newsArticleList;
    private List<StaffTypeDTO> staffTypeList;

    public List<ProfileInfoDTO> getProfileInfoList() {
        return profileInfoList;
    }

    public void setProfileInfoList(List<ProfileInfoDTO> profileInfoList) {
        this.profileInfoList = profileInfoList;
    }

    public List<CityDTO> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityDTO> cityList) {
        this.cityList = cityList;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

    public List<ComplaintUpdateStatusDTO> getComplaintUpdateStatusList() {
        return complaintUpdateStatusList;
    }

    public void setComplaintUpdateStatusList(List<ComplaintUpdateStatusDTO> complaintUpdateStatusList) {
        this.complaintUpdateStatusList = complaintUpdateStatusList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

    public List<CustomerStatusDTO> getCustomerStatusList() {
        return customerStatusList;
    }

    public void setCustomerStatusList(List<CustomerStatusDTO> customerStatusList) {
        this.customerStatusList = customerStatusList;
    }

    public List<CustomerTypeDTO> getCustomerTypeList() {
        return customerTypeList;
    }

    public void setCustomerTypeList(List<CustomerTypeDTO> customerTypeList) {
        this.customerTypeList = customerTypeList;
    }

    public List<ErrorStoreDTO> getErrorStoreList() {
        return errorStoreList;
    }

    public void setErrorStoreList(List<ErrorStoreDTO> errorStoreList) {
        this.errorStoreList = errorStoreList;
    }

    public List<ErrorStoreAndroidDTO> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroidDTO> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public List<GcmDeviceDTO> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDeviceDTO> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public List<MunicipalityDTO> getMunicipalityList() {
        return municipalityList;
    }

    public void setMunicipalityList(List<MunicipalityDTO> municipalityList) {
        this.municipalityList = municipalityList;
    }

    public List<MunicipalityStaffDTO> getMunicipalityStaffList() {
        return municipalityStaffList;
    }

    public void setMunicipalityStaffList(List<MunicipalityStaffDTO> municipalityStaffList) {
        this.municipalityStaffList = municipalityStaffList;
    }

    public List<NewsArticleTypeDTO> getNewsArticleTypeList() {
        return newsArticleTypeList;
    }

    public void setNewsArticleTypeList(List<NewsArticleTypeDTO> newsArticleTypeList) {
        this.newsArticleTypeList = newsArticleTypeList;
    }

    public List<NewsArticleDTO> getNewsArticleList() {
        return newsArticleList;
    }

    public void setNewsArticleList(List<NewsArticleDTO> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    public List<StaffTypeDTO> getStaffTypeList() {
        return staffTypeList;
    }

    public void setStaffTypeList(List<StaffTypeDTO> staffTypeList) {
        this.staffTypeList = staffTypeList;
    }
    
    
    

    public List<AlertTypeDTO> getAlertTypeList() {
        return alertTypeList;
    }

    public void setAlertTypeList(List<AlertTypeDTO> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }
    
    

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    
    public double getRequestResponseTimeSeconds() {
        return requestResponseTimeSeconds;
    }

    public void setRequestResponseTimeSeconds(double requestResponseTimeSeconds) {
        this.requestResponseTimeSeconds = requestResponseTimeSeconds;
    }

    
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AlertDTO> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<AlertDTO> alertList) {
        this.alertList = alertList;
    }

    public List<AccountDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountDTO> accountList) {
        this.accountList = accountList;
    }


    public List<ComplaintTypeDTO> getComplaintTypeList() {
        return complaintTypeList;
    }

    public void setComplaintTypeList(List<ComplaintTypeDTO> complaintTypeList) {
        this.complaintTypeList = complaintTypeList;
    }

    public List<ComplaintDTO> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<ComplaintDTO> complaintList) {
        this.complaintList = complaintList;
    }
    
    
}
