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
@Table(name = "cfg_proposito_consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgPropositoConsulta.findAll", query = "SELECT c FROM CfgPropositoConsulta c"),
    @NamedQuery(name = "CfgPropositoConsulta.findByIdProposito", query = "SELECT c FROM CfgPropositoConsulta c WHERE c.idProposito = :idProposito"),
    @NamedQuery(name = "CfgPropositoConsulta.findByDescripcion", query = "SELECT c FROM CfgPropositoConsulta c WHERE c.descripcion = :descripcion")})
public class CfgPropositoConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proposito")
    private Integer idProposito;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    public CfgPropositoConsulta() {
    }

    public CfgPropositoConsulta(Integer idProposito) {
        this.idProposito = idProposito;
    }

    public Integer getIdProposito() {
        return idProposito;
    }

    public void setIdProposito(Integer idProposito) {
        this.idProposito = idProposito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProposito != null ? idProposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgPropositoConsulta)) {
            return false;
        }
        CfgPropositoConsulta other = (CfgPropositoConsulta) object;
        if ((this.idProposito == null && other.idProposito != null) || (this.idProposito != null && !this.idProposito.equals(other.idProposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgPropositoConsulta[ idProposito=" + idProposito + " ]";
    }
    
}
