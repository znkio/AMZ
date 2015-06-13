/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gmotux
 */
@Entity
@Table(catalog = "loukia", schema = "")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")})
public class Company implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @NotNull
    @Size(min = 1, max = 36)
    private String companyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String address;
    @Basic(optional = false)
    @NotNull
    private Long companyAFM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String title;
    @JoinColumn(name = "catID", referencedColumnName = "catID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CompanyCat catID;

    public Company() {
    }

    public Company(String companyId) {
        this.companyId = companyId;
    }

    public Company(String companyId, String address, Long companyAFM, String latitude, String longitude, String title) {
        this.companyId = companyId;
        this.address = address;
        this.companyAFM = companyAFM;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCompanyAFM() {
        return companyAFM;
    }

    public void setCompanyAFM(Long companyAFM) {
        this.companyAFM = companyAFM;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyCat getCatID() {
        return catID;
    }

    public void setCatID(CompanyCat catID) {
        this.catID = catID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Company[ companyId=" + companyId + " ]";
    }
    
}
