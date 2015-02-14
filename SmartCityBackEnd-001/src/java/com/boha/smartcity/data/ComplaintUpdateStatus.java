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
import javax.persistence.Lob;
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
@Table(name = "complaintUpdateStatus")
@NamedQueries({
    @NamedQuery(name = "ComplaintUpdateStatus.findAll", query = "SELECT c FROM ComplaintUpdateStatus c"),
    @NamedQuery(name = "ComplaintUpdateStatus.findByComplaintUpdateStatusID", query = "SELECT c FROM ComplaintUpdateStatus c WHERE c.complaintUpdateStatusID = :complaintUpdateStatusID"),
    @NamedQuery(name = "ComplaintUpdateStatus.findByDateUpdated", query = "SELECT c FROM ComplaintUpdateStatus c WHERE c.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "ComplaintUpdateStatus.findByResolvedFlag", query = "SELECT c FROM ComplaintUpdateStatus c WHERE c.resolvedFlag = :resolvedFlag")})
public class ComplaintUpdateStatus implements Serializable {
    @Column(name = "customerOKFlag")
    private Boolean customerOKFlag;
    @Lob
    @Size(max = 65535)
    @Column(name = "customerComment")
    private String customerComment;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complaintUpdateStatusID")
    private Integer complaintUpdateStatusID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resolvedFlag")
    private boolean resolvedFlag;
    @Lob
    @Size(max = 65535)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "complaintID", referencedColumnName = "complaintID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Complaint complaint;
    @JoinColumn(name = "municipalityStaffID", referencedColumnName = "municipalityStaffID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MunicipalityStaff municipalityStaff;

    public ComplaintUpdateStatus() {
    }

    public ComplaintUpdateStatus(Integer complaintUpdateStatusID) {
        this.complaintUpdateStatusID = complaintUpdateStatusID;
    }

    public ComplaintUpdateStatus(Integer complaintUpdateStatusID, Date dateUpdated, boolean resolvedFlag) {
        this.complaintUpdateStatusID = complaintUpdateStatusID;
        this.dateUpdated = dateUpdated;
        this.resolvedFlag = resolvedFlag;
    }

    public Integer getComplaintUpdateStatusID() {
        return complaintUpdateStatusID;
    }

    public void setComplaintUpdateStatusID(Integer complaintUpdateStatusID) {
        this.complaintUpdateStatusID = complaintUpdateStatusID;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public MunicipalityStaff getMunicipalityStaff() {
        return municipalityStaff;
    }

    public void setMunicipalityStaff(MunicipalityStaff municipalityStaff) {
        this.municipalityStaff = municipalityStaff;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public boolean getResolvedFlag() {
        return resolvedFlag;
    }

    public void setResolvedFlag(boolean resolvedFlag) {
        this.resolvedFlag = resolvedFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintUpdateStatusID != null ? complaintUpdateStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintUpdateStatus)) {
            return false;
        }
        ComplaintUpdateStatus other = (ComplaintUpdateStatus) object;
        if ((this.complaintUpdateStatusID == null && other.complaintUpdateStatusID != null) || (this.complaintUpdateStatusID != null && !this.complaintUpdateStatusID.equals(other.complaintUpdateStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.ComplaintUpdateStatus[ complaintUpdateStatusID=" + complaintUpdateStatusID + " ]";
    }

    public Boolean getCustomerOKFlag() {
        return customerOKFlag;
    }

    public void setCustomerOKFlag(Boolean customerOKFlag) {
        this.customerOKFlag = customerOKFlag;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }
    
}
