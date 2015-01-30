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
@Table(name = "complaintType")
@NamedQueries({
    @NamedQuery(name = "ComplaintType.findAll", query = "SELECT c FROM ComplaintType c"),
    @NamedQuery(name = "ComplaintType.findByComplaintTypeID", query = "SELECT c FROM ComplaintType c WHERE c.complaintTypeID = :complaintTypeID"),
    @NamedQuery(name = "ComplaintType.findByComplaintTypeName", query = "SELECT c FROM ComplaintType c WHERE c.complaintTypeName = :complaintTypeName")})
public class ComplaintType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complaintTypeID")
    private Integer complaintTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "complaintTypeName")
    private String complaintTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complaintType")
    private List<Complaint> complaintList;

    public ComplaintType() {
    }

    public ComplaintType(Integer complaintTypeID) {
        this.complaintTypeID = complaintTypeID;
    }

    public ComplaintType(Integer complaintTypeID, String complaintTypeName) {
        this.complaintTypeID = complaintTypeID;
        this.complaintTypeName = complaintTypeName;
    }

    public Integer getComplaintTypeID() {
        return complaintTypeID;
    }

    public void setComplaintTypeID(Integer complaintTypeID) {
        this.complaintTypeID = complaintTypeID;
    }

    public String getComplaintTypeName() {
        return complaintTypeName;
    }

    public void setComplaintTypeName(String complaintTypeName) {
        this.complaintTypeName = complaintTypeName;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintTypeID != null ? complaintTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintType)) {
            return false;
        }
        ComplaintType other = (ComplaintType) object;
        if ((this.complaintTypeID == null && other.complaintTypeID != null) || (this.complaintTypeID != null && !this.complaintTypeID.equals(other.complaintTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ComplaintType[ complaintTypeID=" + complaintTypeID + " ]";
    }
    
}
