/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "customerStatus")
@NamedQueries({
    @NamedQuery(name = "CustomerStatus.findAll", query = "SELECT c FROM CustomerStatus c"),
    @NamedQuery(name = "CustomerStatus.findByCustomerStatusID", query = "SELECT c FROM CustomerStatus c WHERE c.customerStatusID = :customerStatusID"),
    @NamedQuery(name = "CustomerStatus.findByCustomerStatusName", query = "SELECT c FROM CustomerStatus c WHERE c.customerStatusName = :customerStatusName")})
public class CustomerStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerStatusID")
    private Integer customerStatusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "customerStatusName")
    private String customerStatusName;
    @OneToMany(mappedBy = "customerStatus", fetch = FetchType.LAZY)
    private List<ProfileInfo> profileInfoList;

    public CustomerStatus() {
    }

    public CustomerStatus(Integer customerStatusID) {
        this.customerStatusID = customerStatusID;
    }

    public CustomerStatus(Integer customerStatusID, String customerStatusName) {
        this.customerStatusID = customerStatusID;
        this.customerStatusName = customerStatusName;
    }

    public Integer getCustomerStatusID() {
        return customerStatusID;
    }

    public void setCustomerStatusID(Integer customerStatusID) {
        this.customerStatusID = customerStatusID;
    }

    public String getCustomerStatusName() {
        return customerStatusName;
    }

    public void setCustomerStatusName(String customerStatusName) {
        this.customerStatusName = customerStatusName;
    }

    public List<ProfileInfo> getProfileInfoList() {
        return profileInfoList;
    }

    public void setProfileInfoList(List<ProfileInfo> profileInfoList) {
        this.profileInfoList = profileInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerStatusID != null ? customerStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerStatus)) {
            return false;
        }
        CustomerStatus other = (CustomerStatus) object;
        if ((this.customerStatusID == null && other.customerStatusID != null) || (this.customerStatusID != null && !this.customerStatusID.equals(other.customerStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.CustomerStatus[ customerStatusID=" + customerStatusID + " ]";
    }
    
}
