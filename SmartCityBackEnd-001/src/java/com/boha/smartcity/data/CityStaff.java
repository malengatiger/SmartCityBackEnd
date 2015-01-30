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
@Table(name = "cityStaff")
@NamedQueries({
    @NamedQuery(name = "CityStaff.findAll", query = "SELECT c FROM CityStaff c"),
    @NamedQuery(name = "CityStaff.findByCityStaffID", query = "SELECT c FROM CityStaff c WHERE c.cityStaffID = :cityStaffID"),
    @NamedQuery(name = "CityStaff.findByFirstName", query = "SELECT c FROM CityStaff c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CityStaff.findByLastName", query = "SELECT c FROM CityStaff c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CityStaff.findByEmail", query = "SELECT c FROM CityStaff c WHERE c.email = :email"),
    @NamedQuery(name = "CityStaff.findByCellphone", query = "SELECT c FROM CityStaff c WHERE c.cellphone = :cellphone"),
    @NamedQuery(name = "CityStaff.findByDateRegistered", query = "SELECT c FROM CityStaff c WHERE c.dateRegistered = :dateRegistered"),
    @NamedQuery(name = "CityStaff.findByPassword", query = "SELECT c FROM CityStaff c WHERE c.password = :password"),
    @NamedQuery(name = "CityStaff.findByActiveFlag", query = "SELECT c FROM CityStaff c WHERE c.activeFlag = :activeFlag")})
public class CityStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityStaffID")
    private Integer cityStaffID;
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
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false)
    private City city;

    public CityStaff() {
    }

    public CityStaff(Integer cityStaffID) {
        this.cityStaffID = cityStaffID;
    }

    public CityStaff(Integer cityStaffID, String firstName, String lastName, String email, Date dateRegistered, String password) {
        this.cityStaffID = cityStaffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateRegistered = dateRegistered;
        this.password = password;
    }

    public Integer getCityStaffID() {
        return cityStaffID;
    }

    public void setCityStaffID(Integer cityStaffID) {
        this.cityStaffID = cityStaffID;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityStaffID != null ? cityStaffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityStaff)) {
            return false;
        }
        CityStaff other = (CityStaff) object;
        if ((this.cityStaffID == null && other.cityStaffID != null) || (this.cityStaffID != null && !this.cityStaffID.equals(other.cityStaffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.CityStaff[ cityStaffID=" + cityStaffID + " ]";
    }
    
}
