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
@Table(name = "municipalityStaff")
@NamedQueries({
    @NamedQuery(name = "MunicipalityStaff.findAll", query = "SELECT m FROM MunicipalityStaff m"),
    @NamedQuery(name = "MunicipalityStaff.findByMunicipalityStaffID", query = "SELECT m FROM MunicipalityStaff m WHERE m.municipalityStaffID = :municipalityStaffID"),
    @NamedQuery(name = "MunicipalityStaff.findByFirstName", query = "SELECT m FROM MunicipalityStaff m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "MunicipalityStaff.findByLastName", query = "SELECT m FROM MunicipalityStaff m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "MunicipalityStaff.findByEmail", query = "SELECT m FROM MunicipalityStaff m WHERE m.email = :email"),
    @NamedQuery(name = "MunicipalityStaff.findByCellphone", query = "SELECT m FROM MunicipalityStaff m WHERE m.cellphone = :cellphone"),
    @NamedQuery(name = "MunicipalityStaff.findByDateRegistered", query = "SELECT m FROM MunicipalityStaff m WHERE m.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "MunicipalityStaff.findByPassword", query = "SELECT m FROM MunicipalityStaff m WHERE m.password = :password"),
    @NamedQuery(name = "MunicipalityStaff.findByActiveFlag", query = "SELECT m FROM MunicipalityStaff m WHERE m.activeFlag = :activeFlag")})
public class MunicipalityStaff implements Serializable {
    @OneToMany(mappedBy = "municipalityStaff", fetch = FetchType.LAZY)
    private List<Alert> alertList;
    @OneToMany(mappedBy = "municipalityStaff", fetch = FetchType.LAZY)
    private List<ErrorStoreAndroid> errorStoreAndroidList;
    @OneToMany(mappedBy = "municipalityStaff", fetch = FetchType.LAZY)
    private List<ComplaintUpdateStatus> complaintUpdateStatusList;
    @OneToMany(mappedBy = "municipalityStaff", fetch = FetchType.LAZY)
    private List<GcmDevice> gcmDeviceList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipalityStaffID")
    private Integer municipalityStaffID;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cellphone")
    private String cellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipalityStaff", fetch = FetchType.LAZY)
    private List<StaffImage> staffImageList;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;
    @JoinColumn(name = "staffTypeID", referencedColumnName = "staffTypeID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StaffType staffType;

    public MunicipalityStaff() {
    }

    public MunicipalityStaff(Integer municipalityStaffID) {
        this.municipalityStaffID = municipalityStaffID;
    }

    public MunicipalityStaff(Integer municipalityStaffID, String firstName, String lastName, String email, Date dateRegistered, String password) {
        this.municipalityStaffID = municipalityStaffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateRegistered = dateRegistered;
        this.password = password;
    }

    public Integer getMunicipalityStaffID() {
        return municipalityStaffID;
    }

    public void setMunicipalityStaffID(Integer municipalityStaffID) {
        this.municipalityStaffID = municipalityStaffID;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public List<StaffImage> getStaffImageList() {
        return staffImageList;
    }

    public void setStaffImageList(List<StaffImage> staffImageList) {
        this.staffImageList = staffImageList;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipalityStaffID != null ? municipalityStaffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipalityStaff)) {
            return false;
        }
        MunicipalityStaff other = (MunicipalityStaff) object;
        if ((this.municipalityStaffID == null && other.municipalityStaffID != null) || (this.municipalityStaffID != null && !this.municipalityStaffID.equals(other.municipalityStaffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.MunicipalityStaff[ municipalityStaffID=" + municipalityStaffID + " ]";
    }

    public List<ErrorStoreAndroid> getErrorStoreAndroidList() {
        return errorStoreAndroidList;
    }

    public void setErrorStoreAndroidList(List<ErrorStoreAndroid> errorStoreAndroidList) {
        this.errorStoreAndroidList = errorStoreAndroidList;
    }

    public List<ComplaintUpdateStatus> getComplaintUpdateStatusList() {
        return complaintUpdateStatusList;
    }

    public void setComplaintUpdateStatusList(List<ComplaintUpdateStatus> complaintUpdateStatusList) {
        this.complaintUpdateStatusList = complaintUpdateStatusList;
    }

    public List<GcmDevice> getGcmDeviceList() {
        return gcmDeviceList;
    }

    public void setGcmDeviceList(List<GcmDevice> gcmDeviceList) {
        this.gcmDeviceList = gcmDeviceList;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }
    
}
