/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@Table(name = "newsArticle")
@NamedQueries({
    @NamedQuery(name = "NewsArticle.findAll", query = "SELECT n FROM NewsArticle n"),
    @NamedQuery(name = "NewsArticle.findByNewsArticleID", query = "SELECT n FROM NewsArticle n WHERE n.newsArticleID = :newsArticleID"),
    @NamedQuery(name = "NewsArticle.findByLatitude", query = "SELECT n FROM NewsArticle n WHERE n.latitude = :latitude"),
    @NamedQuery(name = "NewsArticle.findByLongitude", query = "SELECT n FROM NewsArticle n WHERE n.longitude = :longitude"),
    @NamedQuery(name = "NewsArticle.findByNewsDate", query = "SELECT n FROM NewsArticle n WHERE n.newsDate = :newsDate"),
    @NamedQuery(name = "NewsArticle.findByActiveFlag", query = "SELECT n FROM NewsArticle n WHERE n.activeFlag = :activeFlag"),
    @NamedQuery(name = "NewsArticle.findByColor", query = "SELECT n FROM NewsArticle n WHERE n.color = :color")})
public class NewsArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsArticleID")
    private Integer newsArticleID;
    @Lob
    @Size(max = 65535)
    @Column(name = "newsText")
    private String newsText;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newsDate;
    @Column(name = "activeFlag")
    private Boolean activeFlag;
    @Column(name = "color")
    private Integer color;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
    @JoinColumn(name = "muncipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality muncipality;
    @JoinColumn(name = "newsArticleTypeID", referencedColumnName = "newsArticleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private NewsArticleType newsArticleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsArticle", fetch = FetchType.LAZY)
    private List<NewsArticleImage> newsArticleImageList;

    public NewsArticle() {
    }

    public NewsArticle(Integer newsArticleID) {
        this.newsArticleID = newsArticleID;
    }

    public NewsArticle(Integer newsArticleID, Date newsDate) {
        this.newsArticleID = newsArticleID;
        this.newsDate = newsDate;
    }

    public Integer getNewsArticleID() {
        return newsArticleID;
    }

    public void setNewsArticleID(Integer newsArticleID) {
        this.newsArticleID = newsArticleID;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
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

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Municipality getMuncipality() {
        return muncipality;
    }

    public void setMuncipality(Municipality muncipality) {
        this.muncipality = muncipality;
    }

    public NewsArticleType getNewsArticleType() {
        return newsArticleType;
    }

    public void setNewsArticleType(NewsArticleType newsArticleType) {
        this.newsArticleType = newsArticleType;
    }

    public List<NewsArticleImage> getNewsArticleImageList() {
        return newsArticleImageList;
    }

    public void setNewsArticleImageList(List<NewsArticleImage> newsArticleImageList) {
        this.newsArticleImageList = newsArticleImageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsArticleID != null ? newsArticleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsArticle)) {
            return false;
        }
        NewsArticle other = (NewsArticle) object;
        if ((this.newsArticleID == null && other.newsArticleID != null) || (this.newsArticleID != null && !this.newsArticleID.equals(other.newsArticleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.NewsArticle[ newsArticleID=" + newsArticleID + " ]";
    }
    
}
