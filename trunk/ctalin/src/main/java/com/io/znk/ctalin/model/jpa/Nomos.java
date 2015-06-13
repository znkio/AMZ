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
@Table(name = "nomos")
@NamedQueries({
    @NamedQuery(name = "Nomos.findAll", query = "SELECT n FROM Nomos n")})
public class Nomos implements Serializable {

    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @NotNull
    @Size(min = 1, max = 36)
    private String nomosID;

    @NotNull
    @Size(min = 1, max = 50)
    private String description;

    public Nomos() {
    }

    public Nomos(String nomosID) {
        this.nomosID = nomosID;
    }

    public Nomos(String nomosID, String description) {
        this.nomosID = nomosID;
        this.description = description;
    }

    public String getNomosID() {
        return nomosID;
    }

    public void setNomosID(String nomosID) {
        this.nomosID = nomosID;
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
        hash += (nomosID != null ? nomosID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomos)) {
            return false;
        }
        Nomos other = (Nomos) object;
        if ((this.nomosID == null && other.nomosID != null) || (this.nomosID != null && !this.nomosID.equals(other.nomosID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.io.znk.ctalin.model.jpa.Nomos[ nomosID=" + nomosID + " ]";
    }

}
