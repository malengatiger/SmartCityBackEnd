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
@Table(name = "municipalityImage")
@NamedQueries({
    @NamedQuery(name = "MunicipalityImage.findAll", query = "SELECT m FROM MunicipalityImage m"),
    @NamedQuery(name = "MunicipalityImage.findByMunicipalityImageID", query = "SELECT m FROM MunicipalityImage m WHERE m.municipalityImageID = :municipalityImageID"),
    @NamedQuery(name = "MunicipalityImage.findByFileName", query = "SELECT m FROM MunicipalityImage m WHERE m.fileName = :fileName"),
    @NamedQuery(name = "MunicipalityImage.findByDateUploaded", query = "SELECT m FROM MunicipalityImage m WHERE m.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "MunicipalityImage.findByDateTaken", query = "SELECT m FROM MunicipalityImage m WHERE m.dateTaken = :dateTaken"),
    @NamedQuery(name = "MunicipalityImage.findByLatitude", query = "SELECT m FROM MunicipalityImage m WHERE m.latitude = :latitude"),
    @NamedQuery(name = "MunicipalityImage.findByLongitude", query = "SELECT m FROM MunicipalityImage m WHERE m.longitude = :longitude")})
public class MunicipalityImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipalityImageID")
    private Integer municipalityImageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 105)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTaken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;

    public MunicipalityImage() {
    }

    public MunicipalityImage(Integer municipalityImageID) {
        this.municipalityImageID = municipalityImageID;
    }

    public MunicipalityImage(Integer municipalityImageID, String fileName, Date dateUploaded, Date dateTaken) {
        this.municipalityImageID = municipalityImageID;
        this.fileName = fileName;
        this.dateUploaded = dateUploaded;
        this.dateTaken = dateTaken;
    }

    public Integer getMunicipalityImageID() {
        return municipalityImageID;
    }

    public void setMunicipalityImageID(Integer municipalityImageID) {
        this.municipalityImageID = municipalityImageID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
        hash += (municipalityImageID != null ? municipalityImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipalityImage)) {
            return false;
        }
        MunicipalityImage other = (MunicipalityImage) object;
        if ((this.municipalityImageID == null && other.municipalityImageID != null) || (this.municipalityImageID != null && !this.municipalityImageID.equals(other.municipalityImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.MunicipalityImage[ municipalityImageID=" + municipalityImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
