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
@Table(name = "achievement")
@NamedQueries({
    @NamedQuery(name = "Achievement.findAll", query = "SELECT a FROM Achievement a")})
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String achievementID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String description;
    @Basic(optional = false)
    @NotNull
    private Integer level;
    @Basic(optional = false)
    @NotNull
    private Integer multiplier;

    public Achievement() {
    }

    public Achievement(String achievementID) {
        this.achievementID = achievementID;
    }

    public Achievement(String achievementID, String description, Integer level, Integer multiplier) {
        this.achievementID = achievementID;
        this.description = description;
        this.level = level;
        this.multiplier = multiplier;
    }

    public String getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(String achievementID) {
        this.achievementID = achievementID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (achievementID != null ? achievementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achievement)) {
            return false;
        }
        Achievement other = (Achievement) object;
        if ((this.achievementID == null && other.achievementID != null) || (this.achievementID != null && !this.achievementID.equals(other.achievementID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Achievement[ achievementID=" + achievementID + " ]";
    }

}
