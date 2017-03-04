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
@Table(name = "cfg_unidad_funcional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgUnidadFuncional.findAll", query = "SELECT c FROM CfgUnidadFuncional c"),
    @NamedQuery(name = "CfgUnidadFuncional.findByCodUndFuncional", query = "SELECT c FROM CfgUnidadFuncional c WHERE c.codUndFuncional = :codUndFuncional"),
    @NamedQuery(name = "CfgUnidadFuncional.findByNomUndFuncional", query = "SELECT c FROM CfgUnidadFuncional c WHERE c.nomUndFuncional = :nomUndFuncional"),
    @NamedQuery(name = "CfgUnidadFuncional.findByCodCtoCosto", query = "SELECT c FROM CfgUnidadFuncional c WHERE c.codCtoCosto = :codCtoCosto")})
public class CfgUnidadFuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_und_funcional")
    private String codUndFuncional;
    @Size(max = 100)
    @Column(name = "nom_und_funcional")
    private String nomUndFuncional;
    @Size(max = 3)
    @Column(name = "cod_cto_costo")
    private String codCtoCosto;

    public CfgUnidadFuncional() {
    }

    public CfgUnidadFuncional(String codUndFuncional) {
        this.codUndFuncional = codUndFuncional;
    }

    public String getCodUndFuncional() {
        return codUndFuncional;
    }

    public void setCodUndFuncional(String codUndFuncional) {
        this.codUndFuncional = codUndFuncional;
    }

    public String getNomUndFuncional() {
        return nomUndFuncional;
    }

    public void setNomUndFuncional(String nomUndFuncional) {
        this.nomUndFuncional = nomUndFuncional;
    }

    public String getCodCtoCosto() {
        return codCtoCosto;
    }

    public void setCodCtoCosto(String codCtoCosto) {
        this.codCtoCosto = codCtoCosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUndFuncional != null ? codUndFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgUnidadFuncional)) {
            return false;
        }
        CfgUnidadFuncional other = (CfgUnidadFuncional) object;
        if ((this.codUndFuncional == null && other.codUndFuncional != null) || (this.codUndFuncional != null && !this.codUndFuncional.equals(other.codUndFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgUnidadFuncional[ codUndFuncional=" + codUndFuncional + " ]";
    }
    
}
