/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author gmotux
 */
@Entity
@Table(name = "rewardreceived")
@NamedQueries({
    @NamedQuery(name = "Rewardreceived.findAll", query = "SELECT r FROM Rewardreceived r")})
public class Rewardreceived implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String rewardReceivedID;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @JoinColumn(name = "customerID", referencedColumnName = "customerId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customerID;
    @JoinColumn(name = "rewardID", referencedColumnName = "rewardID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rewards rewardID;

    public Rewardreceived() {
    }

    public Rewardreceived(String rewardReceivedID) {
        this.rewardReceivedID = rewardReceivedID;
    }

    public Rewardreceived(String rewardReceivedID, Date dateReceived) {
        this.rewardReceivedID = rewardReceivedID;
        this.dateReceived = dateReceived;
    }

    public String getRewardReceivedID() {
        return rewardReceivedID;
    }

    public void setRewardReceivedID(String rewardReceivedID) {
        this.rewardReceivedID = rewardReceivedID;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Rewards getRewardID() {
        return rewardID;
    }

    public void setRewardID(Rewards rewardID) {
        this.rewardID = rewardID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rewardReceivedID != null ? rewardReceivedID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rewardreceived)) {
            return false;
        }
        Rewardreceived other = (Rewardreceived) object;
        if ((this.rewardReceivedID == null && other.rewardReceivedID != null) || (this.rewardReceivedID != null && !this.rewardReceivedID.equals(other.rewardReceivedID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Rewardreceived[ rewardReceivedID=" + rewardReceivedID + " ]";
    }

}
