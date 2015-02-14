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
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = "Account.findByProfileInfo", 
            query = "SELECT a FROM Account a where a.profileInfo.profileInfoID = :profileInfoID")
})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountID")
    private Integer accountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "dateLastUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;
    @Column(name = "currentBalance")
    private Double currentBalance;
    @Column(name = "totalAccountAmount")
    private Double totalAccountAmount;
    @Column(name = "cashAfterAccount")
    private Double cashAfterAccount;
    @Size(max = 45)
    @Column(name = "customerNumber")
    private String customerNumber;
    @Size(max = 45)
    @Column(name = "customerAccountNumber")
    private String customerAccountNumber;
    @Size(max = 45)
    @Column(name = "customerAccountName")
    private String customerAccountName;
    @Lob
    @Size(max = 65535)
    @Column(name = "propertyAddress")
    private String propertyAddress;
    @Column(name = "lastBillAmount")
    private Double lastBillAmount;
    @Column(name = "nextBillDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextBillDate;
    @Column(name = "currentArrears")
    private Double currentArrears;
    @Column(name = "billDay")
    private Integer billDay;
    @Column(name = "previousBillDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date previousBillDate;
    @Size(max = 45)
    @Column(name = "customerIdentityNumber")
    private String customerIdentityNumber;
    @JoinColumn(name = "profileInfoID", referencedColumnName = "profileInfoID")
    @ManyToOne(optional = false)
    private ProfileInfo profileInfo;

    public Account() {
    }

    public Account(Integer accountID) {
        this.accountID = accountID;
    }

    public Account(Integer accountID, String accountNumber) {
        this.accountID = accountID;
        this.accountNumber = accountNumber;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getTotalAccountAmount() {
        return totalAccountAmount;
    }

    public void setTotalAccountAmount(Double totalAccountAmount) {
        this.totalAccountAmount = totalAccountAmount;
    }

    public Double getCashAfterAccount() {
        return cashAfterAccount;
    }

    public void setCashAfterAccount(Double cashAfterAccount) {
        this.cashAfterAccount = cashAfterAccount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public String getCustomerAccountName() {
        return customerAccountName;
    }

    public void setCustomerAccountName(String customerAccountName) {
        this.customerAccountName = customerAccountName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public Double getLastBillAmount() {
        return lastBillAmount;
    }

    public void setLastBillAmount(Double lastBillAmount) {
        this.lastBillAmount = lastBillAmount;
    }

    public Date getNextBillDate() {
        return nextBillDate;
    }

    public void setNextBillDate(Date nextBillDate) {
        this.nextBillDate = nextBillDate;
    }

    public Double getCurrentArrears() {
        return currentArrears;
    }

    public void setCurrentArrears(Double currentArrears) {
        this.currentArrears = currentArrears;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Date getPreviousBillDate() {
        return previousBillDate;
    }

    public void setPreviousBillDate(Date previousBillDate) {
        this.previousBillDate = previousBillDate;
    }

    public String getCustomerIdentityNumber() {
        return customerIdentityNumber;
    }

    public void setCustomerIdentityNumber(String customerIdentityNumber) {
        this.customerIdentityNumber = customerIdentityNumber;
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
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Account[ accountID=" + accountID + " ]";
    }
    
}
