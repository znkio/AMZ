/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gmotux
 */
@Entity
@Table(name = "achievementcustomer")
@NamedQueries({
    @NamedQuery(name = "Achievementcustomer.findAll", query = "SELECT a FROM Achievementcustomer a")})
public class Achievementcustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String achievementCustomerID;
    @JoinColumn(name = "achievementID", referencedColumnName = "achievementID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Achievement achievementID;
    @JoinColumn(name = "customerID", referencedColumnName = "customerId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customerID;

    public Achievementcustomer() {
    }

    public Achievementcustomer(String achievementCustomerID) {
        this.achievementCustomerID = achievementCustomerID;
    }

    public String getAchievementCustomerID() {
        return achievementCustomerID;
    }

    public void setAchievementCustomerID(String achievementCustomerID) {
        this.achievementCustomerID = achievementCustomerID;
    }

    public Achievement getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(Achievement achievementID) {
        this.achievementID = achievementID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (achievementCustomerID != null ? achievementCustomerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achievementcustomer)) {
            return false;
        }
        Achievementcustomer other = (Achievementcustomer) object;
        if ((this.achievementCustomerID == null && other.achievementCustomerID != null) || (this.achievementCustomerID != null && !this.achievementCustomerID.equals(other.achievementCustomerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Achievementcustomer[ achievementCustomerID=" + achievementCustomerID + " ]";
    }

}
