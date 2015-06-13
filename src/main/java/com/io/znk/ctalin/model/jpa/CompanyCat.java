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
    @NamedQuery(name = "CompanyCat.findAll", query = "SELECT c FROM CompanyCat c")})
public class CompanyCat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    private String catID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String description;

    public CompanyCat() {
    }

    public CompanyCat(String catID) {
        this.catID = catID;
    }

    public CompanyCat(String catID, String description) {
        this.catID = catID;
        this.description = description;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catID != null ? catID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyCat)) {
            return false;
        }
        CompanyCat other = (CompanyCat) object;
        if ((this.catID == null && other.catID != null) || (this.catID != null && !this.catID.equals(other.catID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.CompanyCat[ catID=" + catID + " ]";
    }
    
}
