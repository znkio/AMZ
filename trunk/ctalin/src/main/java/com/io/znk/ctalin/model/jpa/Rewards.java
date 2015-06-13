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
@Table(name = "rewards")
@NamedQueries({
    @NamedQuery(name = "Rewards.findAll", query = "SELECT r FROM Rewards r")})
public class Rewards implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @NotNull
    @Size(min = 1, max = 36)
    private String rewardID;

    @NotNull
    @Size(min = 1, max = 50)
    private String description;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateUpTo;
    @JoinColumn(name = "companyID", referencedColumnName = "companyId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Company companyID;
    @JoinColumn(name = "rewardCritID", referencedColumnName = "rewardCritID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rewardcrit rewardCritID;

    public Rewards() {
    }

    public Rewards(String rewardID) {
        this.rewardID = rewardID;
    }

    public Rewards(String rewardID, String description, Date dateUpTo) {
        this.rewardID = rewardID;
        this.description = description;
        this.dateUpTo = dateUpTo;
    }

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateUpTo() {
        return dateUpTo;
    }

    public void setDateUpTo(Date dateUpTo) {
        this.dateUpTo = dateUpTo;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public Rewardcrit getRewardCritID() {
        return rewardCritID;
    }

    public void setRewardCritID(Rewardcrit rewardCritID) {
        this.rewardCritID = rewardCritID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rewardID != null ? rewardID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rewards)) {
            return false;
        }
        Rewards other = (Rewards) object;
        if ((this.rewardID == null && other.rewardID != null) || (this.rewardID != null && !this.rewardID.equals(other.rewardID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Rewards[ rewardID=" + rewardID + " ]";
    }

}
