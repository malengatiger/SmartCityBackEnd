
package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class NewsArticleDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer newsArticleID;
    private String newsText;

    private Double latitude;
    private Double longitude;
    private Date newsDate;
    private Boolean activeFlag;
    private Integer color;
    private CityDTO city;
    private Integer muncipalityID;
    private NewsArticleTypeDTO newsArticleType;
    private List<NewsArticleImageDTO> newsArticleImageList;

    public NewsArticleDTO() {
    }

    public NewsArticleDTO(NewsArticle a) {
        this.newsArticleID = a.getNewsArticleID();
        newsText = a.getNewsText();
        color = a.getColor();
        activeFlag = a.getActiveFlag();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        newsDate = a.getNewsDate();
        muncipalityID = a.getMuncipality().getMunicipalityID();
        newsArticleType = new NewsArticleTypeDTO(a.getNewsArticleType());
        if (a.getCity() != null) {
            city = new CityDTO(a.getCity());
        }
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public Integer getMuncipalityID() {
        return muncipalityID;
    }

    public void setMuncipalityID(Integer muncipalityID) {
        this.muncipalityID = muncipalityID;
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


    public NewsArticleTypeDTO getNewsArticleType() {
        return newsArticleType;
    }

    public void setNewsArticleType(NewsArticleTypeDTO newsArticleType) {
        this.newsArticleType = newsArticleType;
    }

    public List<NewsArticleImageDTO> getNewsArticleImageList() {
        return newsArticleImageList;
    }

    public void setNewsArticleImageList(List<NewsArticleImageDTO> newsArticleImageList) {
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
        if (!(object instanceof NewsArticleDTO)) {
            return false;
        }
        NewsArticleDTO other = (NewsArticleDTO) object;
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
