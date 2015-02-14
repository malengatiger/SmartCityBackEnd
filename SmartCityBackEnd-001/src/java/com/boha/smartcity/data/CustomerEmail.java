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
@Table(name = "customerEmail")
@NamedQueries({
    @NamedQuery(name = "CustomerEmail.findAll", query = "SELECT c FROM CustomerEmail c"),
    @NamedQuery(name = "CustomerEmail.findByCustomerEmailID", query = "SELECT c FROM CustomerEmail c WHERE c.customerEmailID = :customerEmailID"),
    @NamedQuery(name = "CustomerEmail.findByEmail", query = "SELECT c FROM CustomerEmail c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerEmail.findByDateRegistered", query = "SELECT c FROM CustomerEmail c WHERE c.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "CustomerEmail.findByActiveFlag", query = "SELECT c FROM CustomerEmail c WHERE c.activeFlag = :activeFlag")})
public class CustomerEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerEmailID")
    private Integer customerEmailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @JoinColumn(name = "profileInfoID", referencedColumnName = "profileInfoID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfileInfo profileInfo;

    public CustomerEmail() {
    }

    public CustomerEmail(Integer customerEmailID) {
        this.customerEmailID = customerEmailID;
    }

    public CustomerEmail(Integer customerEmailID, String email) {
        this.customerEmailID = customerEmailID;
        this.email = email;
    }

    public Integer getCustomerEmailID() {
        return customerEmailID;
    }

    public void setCustomerEmailID(Integer customerEmailID) {
        this.customerEmailID = customerEmailID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
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
        hash += (customerEmailID != null ? customerEmailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEmail)) {
            return false;
        }
        CustomerEmail other = (CustomerEmail) object;
        if ((this.customerEmailID == null && other.customerEmailID != null) || (this.customerEmailID != null && !this.customerEmailID.equals(other.customerEmailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.CustomerEmail[ customerEmailID=" + customerEmailID + " ]";
    }
    
}
