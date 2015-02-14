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
@Table(name = "alertType")
@NamedQueries({
    @NamedQuery(name = "AlertType.findAll", query = "SELECT a FROM AlertType a order by a.alertTypeNmae")
})
public class AlertType implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "alertTypeName")
    private String alertTypeName;
    @JoinColumn(name = "municipalityID", referencedColumnName = "municipalityID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipality municipality;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alertTypeID")
    private Integer alertTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "alertTypeNmae")
    private String alertTypeNmae;
    @Column(name = "color")
    private Integer color;
    @OneToMany(mappedBy = "alertType")
    private List<Alert> alertList;

    public AlertType() {
    }

    public AlertType(Integer alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public AlertType(Integer alertTypeID, String alertTypeNmae) {
        this.alertTypeID = alertTypeID;
        this.alertTypeNmae = alertTypeNmae;
    }

    public Integer getAlertTypeID() {
        return alertTypeID;
    }

    public void setAlertTypeID(Integer alertTypeID) {
        this.alertTypeID = alertTypeID;
    }

    public String getAlertTypeNmae() {
        return alertTypeNmae;
    }

    public void setAlertTypeNmae(String alertTypeNmae) {
        this.alertTypeNmae = alertTypeNmae;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertTypeID != null ? alertTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertType)) {
            return false;
        }
        AlertType other = (AlertType) object;
        if ((this.alertTypeID == null && other.alertTypeID != null) || (this.alertTypeID != null && !this.alertTypeID.equals(other.alertTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.smartcity.data.AlertType[ alertTypeID=" + alertTypeID + " ]";
    }

    public String getAlertTypeName() {
        return alertTypeName;
    }

    public void setAlertTypeName(String alertTypeName) {
        this.alertTypeName = alertTypeName;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

   
}
