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
import javax.persistence.GeneratedValue;
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
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gmotux
 */
@Entity
@Table(catalog = "loukia", schema = "")
@NamedQueries({
    @NamedQuery(name = "RewardReceived.findAll", query = "SELECT r FROM RewardReceived r")})
public class RewardReceived implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String rewardReceivedID;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @JoinColumn(name = "rewardID", referencedColumnName = "rewardID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rewards rewardID;
    @JoinColumn(name = "customerID", referencedColumnName = "customerId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customerID;

    public RewardReceived() {
    }

    public RewardReceived(String rewardReceivedID) {
        this.rewardReceivedID = rewardReceivedID;
    }

    public RewardReceived(String rewardReceivedID, Date dateReceived) {
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

    public Rewards getRewardID() {
        return rewardID;
    }

    public void setRewardID(Rewards rewardID) {
        this.rewardID = rewardID;
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
        hash += (rewardReceivedID != null ? rewardReceivedID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RewardReceived)) {
            return false;
        }
        RewardReceived other = (RewardReceived) object;
        if ((this.rewardReceivedID == null && other.rewardReceivedID != null) || (this.rewardReceivedID != null && !this.rewardReceivedID.equals(other.rewardReceivedID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.RewardReceived[ rewardReceivedID=" + rewardReceivedID + " ]";
    }
    
}
