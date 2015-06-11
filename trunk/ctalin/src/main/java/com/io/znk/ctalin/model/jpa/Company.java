package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import javax.persistence.Lob;

@Table(name = "company")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company implements Serializable {
    private static final long serialVersionUID = 1085548653431275261L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long companyId;

    @NotNull
    @Column(unique = true)
    private String title;

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column
    private String address;

    @Column
    private Long companyAFM;

    public Company() {
    }
    public Company(Long companyId, String title, String longitude, String latitude, String address, Long companyAFM) {
        this.companyId = companyId;
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.companyAFM = companyAFM;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    

    public Long getCompanyId() {
            return companyId;
    }

    public void setCompanyId(Long companyId) {
            this.companyId = companyId;
    }

    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", title=" + title + ", longitude=" + longitude + ", latitude=" + latitude + ", address=" + address + ", companyAFM=" + companyAFM + '}';
    }

	

}
