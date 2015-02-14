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
@Table(name = "newsArticleImage")
@NamedQueries({
    @NamedQuery(name = "NewsArticleImage.findAll", query = "SELECT n FROM NewsArticleImage n"),
    @NamedQuery(name = "NewsArticleImage.findByNewsArticleImageID", query = "SELECT n FROM NewsArticleImage n WHERE n.newsArticleImageID = :newsArticleImageID"),
    @NamedQuery(name = "NewsArticleImage.findByFileName", query = "SELECT n FROM NewsArticleImage n WHERE n.fileName = :fileName"),
    @NamedQuery(name = "NewsArticleImage.findByDateTaken", query = "SELECT n FROM NewsArticleImage n WHERE n.dateTaken = :dateTaken"),
    @NamedQuery(name = "NewsArticleImage.findByDateUploaded", query = "SELECT n FROM NewsArticleImage n WHERE n.dateUploaded = :dateUploaded"),
    @NamedQuery(name = "NewsArticleImage.findByLatitude", query = "SELECT n FROM NewsArticleImage n WHERE n.latitude = :latitude"),
    @NamedQuery(name = "NewsArticleImage.findByLongitude", query = "SELECT n FROM NewsArticleImage n WHERE n.longitude = :longitude")})
public class NewsArticleImage implements Serializable {
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsArticleImageID")
    private Integer newsArticleImageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 105)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTaken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "newsArticleID", referencedColumnName = "newsArticleID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NewsArticle newsArticle;

    public NewsArticleImage() {
    }

    public NewsArticleImage(Integer newsArticleImageID) {
        this.newsArticleImageID = newsArticleImageID;
    }

    public NewsArticleImage(Integer newsArticleImageID, String fileName, Date dateTaken, Date dateUploaded) {
        this.newsArticleImageID = newsArticleImageID;
        this.fileName = fileName;
        this.dateTaken = dateTaken;
        this.dateUploaded = dateUploaded;
    }

    public Integer getNewsArticleImageID() {
        return newsArticleImageID;
    }

    public void setNewsArticleImageID(Integer newsArticleImageID) {
        this.newsArticleImageID = newsArticleImageID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
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

    public NewsArticle getNewsArticle() {
        return newsArticle;
    }

    public void setNewsArticle(NewsArticle newsArticle) {
        this.newsArticle = newsArticle;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsArticleImageID != null ? newsArticleImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsArticleImage)) {
            return false;
        }
        NewsArticleImage other = (NewsArticleImage) object;
        if ((this.newsArticleImageID == null && other.newsArticleImageID != null) || (this.newsArticleImageID != null && !this.newsArticleImageID.equals(other.newsArticleImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.NewsArticleImage[ newsArticleImageID=" + newsArticleImageID + " ]";
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
    
}
