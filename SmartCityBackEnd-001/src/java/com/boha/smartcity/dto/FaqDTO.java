/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.smartcity.dto;

import com.boha.smartcity.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class FaqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer faqID;
    private String question;
    private String answer;
    private Date dateUpdated;
    private Boolean activeFlag;
    private Integer sequenceNumber;
    private Integer municipalityID;

    public FaqDTO() {
    }

    public FaqDTO(Faq a) {
        this.faqID = a.getFaqID();
        question = a.getQuestion();
        answer = a.getAnswer();
        dateUpdated = a.getDateUpdated();
        activeFlag = a.getActiveFlag();
        sequenceNumber = a.getSequenceNumber();
        municipalityID = a.getMunicipality().getMunicipalityID();
    }

    public Integer getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(Integer municipalityID) {
        this.municipalityID = municipalityID;
    }

    public Integer getFaqID() {
        return faqID;
    }

    public void setFaqID(Integer faqID) {
        this.faqID = faqID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faqID != null ? faqID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaqDTO)) {
            return false;
        }
        FaqDTO other = (FaqDTO) object;
        if ((this.faqID == null && other.faqID != null) || (this.faqID != null && !this.faqID.equals(other.faqID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.Faq[ faqID=" + faqID + " ]";
    }
    
}
