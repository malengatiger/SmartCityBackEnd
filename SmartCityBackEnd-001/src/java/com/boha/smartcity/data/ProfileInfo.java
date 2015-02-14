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
@Table(name = "profileInfo")
@NamedQueries({
    @NamedQuery(name = "ProfileInfo.login", 
            query = "SELECT p FROM ProfileInfo p where p.iDNumber = :idNumber and p.password = :password"),
    
})
public class ProfileInfo implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @OneToMany(mappedBy = "profileInfo", fetch = FetchType.LAZY)
    private List<ErrorStoreAndroid> errorStoreAndroidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileInfo", fetch = FetchType.LAZY)
    private List<CustomerEmail> customerEmailList;
    @OneToMany(mappedBy = "profileInfo", fetch = FetchType.LAZY)
    private List<GcmDevice> gcmDeviceList;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;
    @JoinColumn(name = "countryID", referencedColumnName = "countryID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @JoinColumn(name = "customerTypeID", referencedColumnName = "customerTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerType customerType;
    @JoinColumn(name = "customerStatusID", referencedColumnName = "customerStatusID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerStatus customerStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileInfo", fetch = FetchType.LAZY)
    private List<ProfileImage> profileImageList;
    @OneToMany(mappedBy = "profileInfo", fetch = FetchType.LAZY)
    private List<Alert> alertList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profileInfoID")
    private Integer profileInfoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customerID")
    private int customerID;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IDNumber")
    private String iDNumber;
   
    @Size(max = 15)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "cellNumber")
    private String cellNumber;
    @Size(max = 45)
    @Column(name = "homeNumber")
    private String homeNumber;
    @Size(max = 45)
    @Column(name = "workNumber")
    private String workNumber;
    @Column(name = "manAgent")
    private Boolean manAgent;
    @Size(max = 255)
    @Column(name = "orgName")
    private String orgName;
    @Size(max = 255)
    @Column(name = "contactPerson")
    private String contactPerson;
    @Size(max = 45)
    @Column(name = "contactPos")
    private String contactPos;
    @Column(name = "govDepID")
    private Integer govDepID;
    @Size(max = 45)
    @Column(name = "govBranch")
    private String govBranch;
    @Size(max = 255)
    @Column(name = "email1")
    private String email1;
    @Size(max = 45)
    @Column(name = "email1Status")
    private String email1Status;
    @Size(max = 255)
    @Column(name = "email2")
    private String email2;
    @Column(name = "dateActivated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateActivated;
    @Size(max = 255)
    @Column(name = "empName")
    private String empName;
    @Size(max = 45)
    @Column(name = "custStatus")
    private String custStatus;
    @Column(name = "capUserID")
    private Integer capUserID;
    @Column(name = "capDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date capDate;
    @Size(max = 255)
    @Column(name = "secondaryEmail")
    private String secondaryEmail;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileInfo")
    private List<Complaint> complaintList;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileInfo")
    private List<Account> accountList;

    public ProfileInfo() {
    }

    public ProfileInfo(Integer profileInfoID) {
        this.profileInfoID = profileInfoID;
    }

    public ProfileInfo(Integer profileInfoID, int customerID, String iDNumber, String firstName, String lastName) {
        this.profileInfoID = profileInfoID;
        this.customerID = customerID;
        this.iDNumber = iDNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getProfileInfoID() {
        return profileInfoID;
    }

    public void setProfileInfoID(Integer profileInfoID) {
        this.profileInfoID = profileInfoID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

  

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public Boolean getManAgent() {
        return manAgent;
    }

    public void setManAgent(Boolean manAgent) {
        this.manAgent = manAgent;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPos() {
        return contactPos;
    }

    public void setContactPos(String contactPos) {
        this.contactPos = contactPos;
    }

    public Integer getGovDepID() {
        return govDepID;
    }

    public void setGovDepID(Integer govDepID) {
        this.govDepID = govDepID;
    }

    public String getGovBranch() {
        return govBranch;
    }

    public void setGovBranch(String govBranch) {
        this.govBranch = govBranch;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail1Status() {
        return email1Status;
    }

    public void setEmail1Status(String email1Status) {
        this.email1Status = email1Status;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Date getDateActivated() {
        return dateActivated;
    }

    public void setDateActivated(Date dateActivated) {
        this.dateActivated = dateActivated;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public Integer getCapUserID() {
        return capUserID;
    }

    public void setCapUserID(Integer capUserID) {
        this.capUserID = capUserID;
    }

    public Date getCapDate() {
        return capDate;
    }

    public void setCapDate(Date capDate) {
        this.capDate = capDate;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public String getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileInfoID != null ? profileInfoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileInfo)) {
            return false;
        }
        ProfileInfo other = (ProfileInfo) object;
        if ((this.profileInfoID == null && other.profileInfoID != null) || (this.profileInfoID != null && !this.profileInfoID.equals(other.profileInfoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ProfileInfo[ profileInfoID=" + profileInfoID + " ]";
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProfileImage> getProfileImageList() {
        return profileImageList;
    }

    public void setProfileImageList(List<ProfileImage> profileImageList) {
        this.profileImageList = profileImageList;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    public List<ErrorStoreAndroid> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroid> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public List<CustomerEmail> getCustomerEmailList() {
        return customerEmailList;
    }

    public void setCustomerEmailList(List<CustomerEmail> customerEmailList) {
        this.customerEmailList = customerEmailList;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
