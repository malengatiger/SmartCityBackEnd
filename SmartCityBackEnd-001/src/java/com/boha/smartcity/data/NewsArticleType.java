/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.data;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "newsArticleType")
@NamedQueries({
    @NamedQuery(name = "NewsArticleType.findAll", query = "SELECT n FROM NewsArticleType n"),
    @NamedQuery(name = "NewsArticleType.findByNewsArticleTypeID", query = "SELECT n FROM NewsArticleType n WHERE n.newsArticleTypeID = :newsArticleTypeID"),
    @NamedQuery(name = "NewsArticleType.findByNewsArticleTypeName", query = "SELECT n FROM NewsArticleType n WHERE n.newsArticleTypeName = :newsArticleTypeName"),
    @NamedQuery(name = "NewsArticleType.findByColor", query = "SELECT n FROM NewsArticleType n WHERE n.color = :color")})
public class NewsArticleType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsArticleTypeID")
    private Integer newsArticleTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "newsArticleTypeName")
    private String newsArticleTypeName;
    @Column(name = "color")
    private Integer color;
    @OneToMany(mappedBy = "newsArticleType", fetch = FetchType.LAZY)
    private List<NewsArticle> newsArticleList;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;

    public NewsArticleType() {
    }

    public NewsArticleType(Integer newsArticleTypeID) {
        this.newsArticleTypeID = newsArticleTypeID;
    }

    public NewsArticleType(Integer newsArticleTypeID, String newsArticleTypeName) {
        this.newsArticleTypeID = newsArticleTypeID;
        this.newsArticleTypeName = newsArticleTypeName;
    }

    public Integer getNewsArticleTypeID() {
        return newsArticleTypeID;
    }

    public void setNewsArticleTypeID(Integer newsArticleTypeID) {
        this.newsArticleTypeID = newsArticleTypeID;
    }

    public String getNewsArticleTypeName() {
        return newsArticleTypeName;
    }

    public void setNewsArticleTypeName(String newsArticleTypeName) {
        this.newsArticleTypeName = newsArticleTypeName;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public List<NewsArticle> getNewsArticleList() {
        return newsArticleList;
    }

    public void setNewsArticleList(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
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
        hash += (newsArticleTypeID != null ? newsArticleTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsArticleType)) {
            return false;
        }
        NewsArticleType other = (NewsArticleType) object;
        if ((this.newsArticleTypeID == null && other.newsArticleTypeID != null) || (this.newsArticleTypeID != null && !this.newsArticleTypeID.equals(other.newsArticleTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.NewsArticleType[ newsArticleTypeID=" + newsArticleTypeID + " ]";
    }
    
}
