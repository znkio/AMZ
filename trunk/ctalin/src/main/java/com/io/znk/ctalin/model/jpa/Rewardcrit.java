/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.model.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gmotux
 */
@Entity
@Table(name = "rewardcrit")
@NamedQueries({
    @NamedQuery(name = "Rewardcrit.findAll", query = "SELECT r FROM Rewardcrit r")})
public class Rewardcrit implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
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
    @Column(name = "trigrFlag", columnDefinition = "bit", length = 1)
    private Boolean trigrFlag;

    public Rewardcrit() {
    }

    public Rewardcrit(String rewardCritID) {
        this.rewardCritID = rewardCritID;
    }

    public Rewardcrit(String rewardCritID, String description, Long numReceipts, Integer amountMin, Boolean trigrFlag) {
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

    public Boolean getTrigrFlag() {
        return trigrFlag;
    }

    public void setTrigrFlag(Boolean trigrFlag) {
        this.trigrFlag = trigrFlag;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (rewardCritID != null ? rewardCritID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rewardcrit)) {
            return false;
        }
        Rewardcrit other = (Rewardcrit) object;
        if ((this.rewardCritID == null && other.rewardCritID != null) || (this.rewardCritID != null && !this.rewardCritID.equals(other.rewardCritID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Rewardcrit[ rewardCritID=" + rewardCritID + " ]";
    }

}
