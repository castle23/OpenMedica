/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "cfg_cups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCups.findAll", query = "SELECT c FROM CfgCups c"),
    @NamedQuery(name = "CfgCups.findByCodCups", query = "SELECT c FROM CfgCups c WHERE c.codCups = :codCups"),
    @NamedQuery(name = "CfgCups.findBySubcategoria", query = "SELECT c FROM CfgCups c WHERE c.subcategoria = :subcategoria"),
    @NamedQuery(name = "CfgCups.findByObservacion", query = "SELECT c FROM CfgCups c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "CfgCups.findByVisible", query = "SELECT c FROM CfgCups c WHERE c.visible = :visible")})
public class CfgCups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_cups")
    private String codCups;
    @Size(max = 2147483647)
    @Column(name = "subcategoria")
    private String subcategoria;
    @Size(max = 300)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "visible")
    private Boolean visible;

    public CfgCups() {
    }

    public CfgCups(String codCups) {
        this.codCups = codCups;
    }

    public String getCodCups() {
        return codCups;
    }

    public void setCodCups(String codCups) {
        this.codCups = codCups;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCups != null ? codCups.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCups)) {
            return false;
        }
        CfgCups other = (CfgCups) object;
        if ((this.codCups == null && other.codCups != null) || (this.codCups != null && !this.codCups.equals(other.codCups))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgCups[ codCups=" + codCups + " ]";
    }
    
}
