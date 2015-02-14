/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
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

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "municipalityCity")
@NamedQueries({
    @NamedQuery(name = "MunicipalityCity.findAll", query = "SELECT m FROM MunicipalityCity m"),
    @NamedQuery(name = "MunicipalityCity.findByMunicipalityCityID", query = "SELECT m FROM MunicipalityCity m WHERE m.municipalityCityID = :municipalityCityID")})
public class MunicipalityCity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipalityCityID")
    private Integer municipalityCityID;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City city;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;

    public MunicipalityCity() {
    }

    public MunicipalityCity(Integer municipalityCityID) {
        this.municipalityCityID = municipalityCityID;
    }

    public Integer getMunicipalityCityID() {
        return municipalityCityID;
    }

    public void setMunicipalityCityID(Integer municipalityCityID) {
        this.municipalityCityID = municipalityCityID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipalityCityID != null ? municipalityCityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipalityCity)) {
            return false;
        }
        MunicipalityCity other = (MunicipalityCity) object;
        if ((this.municipalityCityID == null && other.municipalityCityID != null) || (this.municipalityCityID != null && !this.municipalityCityID.equals(other.municipalityCityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.MunicipalityCity[ municipalityCityID=" + municipalityCityID + " ]";
    }
    
}
