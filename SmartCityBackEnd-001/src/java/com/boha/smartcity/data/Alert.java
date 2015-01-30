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
@Table(name = "alert")
@NamedQueries({
    @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
    @NamedQuery(name = "Alert.findByAlertID", query = "SELECT a FROM Alert a WHERE a.alertID = :alertID"),
    @NamedQuery(name = "Alert.findByUpdated", query = "SELECT a FROM Alert a WHERE a.updated = :updated"),
    @NamedQuery(name = "Alert.findById", query = "SELECT a FROM Alert a WHERE a.id = :id"),
    @NamedQuery(name = "Alert.findByTitle", query = "SELECT a FROM Alert a WHERE a.title = :title"),
    @NamedQuery(name = "Alert.findByLatitude", query = "SELECT a FROM Alert a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "Alert.findByLongitude", query = "SELECT a FROM Alert a WHERE a.longitude = :longitude"),
    @NamedQuery(name = "Alert.findByThumbnailURL", query = "SELECT a FROM Alert a WHERE a.thumbnailURL = :thumbnailURL"),
    @NamedQuery(name = "Alert.findByHref", query = "SELECT a FROM Alert a WHERE a.href = :href"),
    @NamedQuery(name = "Alert.findByActiveFlag", query = "SELECT a FROM Alert a WHERE a.activeFlag = :activeFlag")})
public class Alert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alertID")
    private Integer alertID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Size(max = 255)
    @Column(name = "thumbnailURL")
    private String thumbnailURL;
    @Size(max = 255)
    @Column(name = "href")
    private String href;
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false)
    private City city;

    public Alert() {
    }

    public Alert(Integer alertID) {
        this.alertID = alertID;
    }

    public Alert(Integer alertID, Date updated) {
        this.alertID = alertID;
        this.updated = updated;
    }

    public Integer getAlertID() {
        return alertID;
    }

    public void setAlertID(Integer alertID) {
        this.alertID = alertID;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        hash += (alertID != null ? alertID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alert)) {
            return false;
        }
        Alert other = (Alert) object;
        if ((this.alertID == null && other.alertID != null) || (this.alertID != null && !this.alertID.equals(other.alertID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Alert[ alertID=" + alertID + " ]";
    }
    
}
