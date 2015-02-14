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
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "customerType")
@NamedQueries({
    @NamedQuery(name = "CustomerType.findAll", query = "SELECT c FROM CustomerType c"),
    @NamedQuery(name = "CustomerType.findByCustomerTypeID", query = "SELECT c FROM CustomerType c WHERE c.customerTypeID = :customerTypeID"),
    @NamedQuery(name = "CustomerType.findByCustomerTypeName", query = "SELECT c FROM CustomerType c WHERE c.customerTypeName = :customerTypeName")})
public class CustomerType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerTypeID")
    private Integer customerTypeID;
    @Size(max = 55)
    @Column(name = "customerTypeName")
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType", fetch = FetchType.LAZY)
    private List<ProfileInfo> profileInfoList;

    public CustomerType() {
    }

    public CustomerType(Integer customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public Integer getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(Integer customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
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
        hash += (customerTypeID != null ? customerTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerType)) {
            return false;
        }
        CustomerType other = (CustomerType) object;
        if ((this.customerTypeID == null && other.customerTypeID != null) || (this.customerTypeID != null && !this.customerTypeID.equals(other.customerTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.CustomerType[ customerTypeID=" + customerTypeID + " ]";
    }
    
}
