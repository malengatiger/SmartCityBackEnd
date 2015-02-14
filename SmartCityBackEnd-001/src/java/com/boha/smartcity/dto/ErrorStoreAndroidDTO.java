
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class ErrorStoreAndroidDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer errorStoreAndroidID;
    private Date errorDate;
    private String packageName;
    private String appVersionName;
    private String appVersionCode;
    private String brand;
    private String phoneModel;
    private String androidVersion;
    private String stackTrace;
    private String logCat;
    private MunicipalityDTO municipality;
    private MunicipalityStaffDTO municipalityStaff;
    private ProfileInfoDTO profileInfo;

    public ErrorStoreAndroidDTO() {
    }

    public ErrorStoreAndroidDTO(Integer errorStoreAndroidID) {
        this.errorStoreAndroidID = errorStoreAndroidID;
    }

    public ErrorStoreAndroidDTO(ErrorStoreAndroid a) {
        this.errorStoreAndroidID = a.getErrorStoreAndroidID();
        this.errorDate = a.getErrorDate();
        this.packageName = a.getPackageName();
        this.appVersionName = a.getAppVersionName();
        this.appVersionCode = a.getAppVersionCode();
        this.brand = a.getBrand();
        this.phoneModel = a.getPhoneModel();
        this.androidVersion = a.getAndroidVersion();
        this.stackTrace = a.getStackTrace();
        this.logCat = a.getLogCat();
        
        if (a.getMunicipality() != null) {
            municipality = new MunicipalityDTO(a.getMunicipality());
        }
        if (a.getProfileInfo() != null) {
            profileInfo = new ProfileInfoDTO(a.getProfileInfo());
        }
        if (a.getMunicipalityStaff() != null) {
            municipalityStaff = new MunicipalityStaffDTO(a.getMunicipalityStaff());
        }
    }

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDTO municipality) {
        this.municipality = municipality;
    }

    public MunicipalityStaffDTO getMunicipalityStaff() {
        return municipalityStaff;
    }

    public void setMunicipalityStaff(MunicipalityStaffDTO municipalityStaff) {
        this.municipalityStaff = municipalityStaff;
    }

    public ProfileInfoDTO getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfoDTO profileInfo) {
        this.profileInfo = profileInfo;
    }

    public Integer getErrorStoreAndroidID() {
        return errorStoreAndroidID;
    }

    public void setErrorStoreAndroidID(Integer errorStoreAndroidID) {
        this.errorStoreAndroidID = errorStoreAndroidID;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    public String getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getLogCat() {
        return logCat;
    }

    public void setLogCat(String logCat) {
        this.logCat = logCat;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorStoreAndroidID != null ? errorStoreAndroidID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorStoreAndroidDTO)) {
            return false;
        }
        ErrorStoreAndroidDTO other = (ErrorStoreAndroidDTO) object;
        if ((this.errorStoreAndroidID == null && other.errorStoreAndroidID != null) || (this.errorStoreAndroidID != null && !this.errorStoreAndroidID.equals(other.errorStoreAndroidID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ErrorStoreAndroid[ errorStoreAndroidID=" + errorStoreAndroidID + " ]";
    }
    
}
