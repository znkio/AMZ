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
    @NamedQuery(name = "RewardCrit.findAll", query = "SELECT r FROM RewardCrit r")})
public class RewardCrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String rewardCritID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String description;
    @Basic(optional = false)
    @NotNull
    private Long numReceipts;
    @Basic(optional = false)
    @NotNull
    private Integer amountMin;
    
    @Basic(optional = false)
    @NotNull
    private Short trigrFlag;

    public RewardCrit() {
    }

    public RewardCrit(String rewardCritID) {
        this.rewardCritID = rewardCritID;
    }

    public RewardCrit(String rewardCritID, String description, Long numReceipts, Integer amountMin, Short trigrFlag) {
        this.rewardCritID = rewardCritID;
        this.description = description;
        this.numReceipts = numReceipts;
        this.amountMin = amountMin;
        this.trigrFlag = trigrFlag;
    }

    public String getRewardCritID() {
        return rewardCritID;
    }

    public void setRewardCritID(String rewardCritID) {
        this.rewardCritID = rewardCritID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumReceipts() {
        return numReceipts;
    }

    public void setNumReceipts(Long numReceipts) {
        this.numReceipts = numReceipts;
    }

    public Integer getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(Integer amountMin) {
        this.amountMin = amountMin;
    }

    public Short getTrigrFlag() {
        return trigrFlag;
    }

    public void setTrigrFlag(Short trigrFlag) {
        this.trigrFlag = trigrFlag;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rewardCritID != null ? rewardCritID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RewardCrit)) {
            return false;
        }
        RewardCrit other = (RewardCrit) object;
        if ((this.rewardCritID == null && other.rewardCritID != null) || (this.rewardCritID != null && !this.rewardCritID.equals(other.rewardCritID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.RewardCrit[ rewardCritID=" + rewardCritID + " ]";
    }
    
}
