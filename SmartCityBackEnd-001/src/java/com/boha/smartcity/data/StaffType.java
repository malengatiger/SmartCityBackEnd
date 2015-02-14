/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "staffType")
@NamedQueries({
    @NamedQuery(name = "StaffType.findAll", query = "SELECT s FROM StaffType s"),
    @NamedQuery(name = "StaffType.findByStaffTypeID", query = "SELECT s FROM StaffType s WHERE s.staffTypeID = :staffTypeID"),
    @NamedQuery(name = "StaffType.findByStaffTypeName", query = "SELECT s FROM StaffType s WHERE s.staffTypeName = :staffTypeName")})
public class StaffType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staffTypeID")
    private Integer staffTypeID;
    @Size(max = 45)
    @Column(name = "staffTypeName")
    private String staffTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffType", fetch = FetchType.LAZY)
    private List<MunicipalityStaff> municipalityStaffList;

    public StaffType() {
    }

    public StaffType(Integer staffTypeID) {
        this.staffTypeID = staffTypeID;
    }

    public Integer getStaffTypeID() {
        return staffTypeID;
    }

    public void setStaffTypeID(Integer staffTypeID) {
        this.staffTypeID = staffTypeID;
    }

    public String getStaffTypeName() {
        return staffTypeName;
    }

    public void setStaffTypeName(String staffTypeName) {
        this.staffTypeName = staffTypeName;
    }

    public List<MunicipalityStaff> getMunicipalityStaffList() {
        return municipalityStaffList;
    }

    public void setMunicipalityStaffList(List<MunicipalityStaff> municipalityStaffList) {
        this.municipalityStaffList = municipalityStaffList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffTypeID != null ? staffTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffType)) {
            return false;
        }
        StaffType other = (StaffType) object;
        if ((this.staffTypeID == null && other.staffTypeID != null) || (this.staffTypeID != null && !this.staffTypeID.equals(other.staffTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.StaffType[ staffTypeID=" + staffTypeID + " ]";
    }
    
}
