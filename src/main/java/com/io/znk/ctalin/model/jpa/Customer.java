/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author gmotux
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String customerId;
    @Basic(optional = false)
    @NotNull
    private Long customerAFM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String customerFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String customerLname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String lastKnownLoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isMale", columnDefinition = "bit", length = 1)
    private Boolean isMale;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dob;
    @JoinColumn(name = "cityID", referencedColumnName = "cityID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private City cityID;
    @Basic(optional = true)
    @Size(min = 1, max = 300)
    private String fsid;
    @Basic(optional = true)
    @Size(min = 1, max = 300)
    private String fbid;

    public String getFsid() {
        return fsid;
    }

    public void setFsid(String fsid) {
        this.fsid = fsid;
    }

    public String getFbid() {
        return fbid;
    }

    public void setFbid(String fbid) {
        this.fbid = fbid;
    }


    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, Long customerAFM, String customerFname, String customerLname, String email, String lastKnownLoc, Boolean isMale, Date dob) {
        this.customerId = customerId;
        this.customerAFM = customerAFM;
        this.customerFname = customerFname;
        this.customerLname = customerLname;
        this.email = email;
        this.lastKnownLoc = lastKnownLoc;
        this.isMale = isMale;
        this.dob = dob;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerAFM() {
        return customerAFM;
    }

    public void setCustomerAFM(Long customerAFM) {
        this.customerAFM = customerAFM;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastKnownLoc() {
        return lastKnownLoc;
    }

    public void setLastKnownLoc(String lastKnownLoc) {
        this.lastKnownLoc = lastKnownLoc;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Customer[ customerId=" + customerId + " ]";
    }

}
