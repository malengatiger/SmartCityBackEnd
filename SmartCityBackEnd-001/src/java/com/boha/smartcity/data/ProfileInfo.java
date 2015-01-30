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
    @NamedQuery(name = "ProfileInfo.findAll", query = "SELECT p FROM ProfileInfo p"),
    @NamedQuery(name = "ProfileInfo.findByProfileInfoID", query = "SELECT p FROM ProfileInfo p WHERE p.profileInfoID = :profileInfoID"),
    @NamedQuery(name = "ProfileInfo.findByCustomerID", query = "SELECT p FROM ProfileInfo p WHERE p.customerID = :customerID"),
    @NamedQuery(name = "ProfileInfo.findByCustomerType", query = "SELECT p FROM ProfileInfo p WHERE p.customerType = :customerType"),
    @NamedQuery(name = "ProfileInfo.findByIDNumber", query = "SELECT p FROM ProfileInfo p WHERE p.iDNumber = :iDNumber"),
    @NamedQuery(name = "ProfileInfo.findByIDCountry", query = "SELECT p FROM ProfileInfo p WHERE p.iDCountry = :iDCountry"),
    @NamedQuery(name = "ProfileInfo.findByTitle", query = "SELECT p FROM ProfileInfo p WHERE p.title = :title"),
    @NamedQuery(name = "ProfileInfo.findByFirstName", query = "SELECT p FROM ProfileInfo p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "ProfileInfo.findByLastName", query = "SELECT p FROM ProfileInfo p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "ProfileInfo.findByCellNumber", query = "SELECT p FROM ProfileInfo p WHERE p.cellNumber = :cellNumber"),
    @NamedQuery(name = "ProfileInfo.findByHomeNumber", query = "SELECT p FROM ProfileInfo p WHERE p.homeNumber = :homeNumber"),
    @NamedQuery(name = "ProfileInfo.findByWorkNumber", query = "SELECT p FROM ProfileInfo p WHERE p.workNumber = :workNumber"),
    @NamedQuery(name = "ProfileInfo.findByManAgent", query = "SELECT p FROM ProfileInfo p WHERE p.manAgent = :manAgent"),
    @NamedQuery(name = "ProfileInfo.findByOrgName", query = "SELECT p FROM ProfileInfo p WHERE p.orgName = :orgName"),
    @NamedQuery(name = "ProfileInfo.findByContactPerson", query = "SELECT p FROM ProfileInfo p WHERE p.contactPerson = :contactPerson"),
    @NamedQuery(name = "ProfileInfo.findByContactPos", query = "SELECT p FROM ProfileInfo p WHERE p.contactPos = :contactPos"),
    @NamedQuery(name = "ProfileInfo.findByGovDepID", query = "SELECT p FROM ProfileInfo p WHERE p.govDepID = :govDepID"),
    @NamedQuery(name = "ProfileInfo.findByGovBranch", query = "SELECT p FROM ProfileInfo p WHERE p.govBranch = :govBranch"),
    @NamedQuery(name = "ProfileInfo.findByEmail1", query = "SELECT p FROM ProfileInfo p WHERE p.email1 = :email1"),
    @NamedQuery(name = "ProfileInfo.findByEmail1Status", query = "SELECT p FROM ProfileInfo p WHERE p.email1Status = :email1Status"),
    @NamedQuery(name = "ProfileInfo.findByEmail2", query = "SELECT p FROM ProfileInfo p WHERE p.email2 = :email2"),
    @NamedQuery(name = "ProfileInfo.findByDateActivated", query = "SELECT p FROM ProfileInfo p WHERE p.dateActivated = :dateActivated"),
    @NamedQuery(name = "ProfileInfo.findByEmpName", query = "SELECT p FROM ProfileInfo p WHERE p.empName = :empName"),
    @NamedQuery(name = "ProfileInfo.findByCustStatus", query = "SELECT p FROM ProfileInfo p WHERE p.custStatus = :custStatus"),
    @NamedQuery(name = "ProfileInfo.findByCapUserID", query = "SELECT p FROM ProfileInfo p WHERE p.capUserID = :capUserID"),
    @NamedQuery(name = "ProfileInfo.findByCapDate", query = "SELECT p FROM ProfileInfo p WHERE p.capDate = :capDate"),
    @NamedQuery(name = "ProfileInfo.findBySecondaryEmail", query = "SELECT p FROM ProfileInfo p WHERE p.secondaryEmail = :secondaryEmail"),
    @NamedQuery(name = "ProfileInfo.findByPassword", query = "SELECT p FROM ProfileInfo p WHERE p.password = :password")})
public class ProfileInfo implements Serializable {
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
    @Size(max = 45)
    @Column(name = "customerType")
    private String customerType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IDNumber")
    private String iDNumber;
    @Size(max = 255)
    @Column(name = "IDCountry")
    private String iDCountry;
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
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false)
    private City city;
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getIDCountry() {
        return iDCountry;
    }

    public void setIDCountry(String iDCountry) {
        this.iDCountry = iDCountry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getiDCountry() {
        return iDCountry;
    }

    public void setiDCountry(String iDCountry) {
        this.iDCountry = iDCountry;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
    
}
