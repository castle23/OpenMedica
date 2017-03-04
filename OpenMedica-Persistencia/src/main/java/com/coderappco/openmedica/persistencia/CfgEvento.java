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
@Table(name = "cfg_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgEvento.findAll", query = "SELECT c FROM CfgEvento c"),
    @NamedQuery(name = "CfgEvento.findByCodEvento", query = "SELECT c FROM CfgEvento c WHERE c.codEvento = :codEvento"),
    @NamedQuery(name = "CfgEvento.findByNomEvento", query = "SELECT c FROM CfgEvento c WHERE c.nomEvento = :nomEvento"),
    @NamedQuery(name = "CfgEvento.findByCentinela", query = "SELECT c FROM CfgEvento c WHERE c.centinela = :centinela"),
    @NamedQuery(name = "CfgEvento.findByEnfermedadSaludPublica", query = "SELECT c FROM CfgEvento c WHERE c.enfermedadSaludPublica = :enfermedadSaludPublica")})
public class CfgEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_evento")
    private String codEvento;
    @Size(max = 150)
    @Column(name = "nom_evento")
    private String nomEvento;
    @Column(name = "centinela")
    private Boolean centinela;
    @Column(name = "enfermedad_salud_publica")
    private Boolean enfermedadSaludPublica;

    public CfgEvento() {
    }

    public CfgEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    public Boolean getCentinela() {
        return centinela;
    }

    public void setCentinela(Boolean centinela) {
        this.centinela = centinela;
    }

    public Boolean getEnfermedadSaludPublica() {
        return enfermedadSaludPublica;
    }

    public void setEnfermedadSaludPublica(Boolean enfermedadSaludPublica) {
        this.enfermedadSaludPublica = enfermedadSaludPublica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvento != null ? codEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgEvento)) {
            return false;
        }
        CfgEvento other = (CfgEvento) object;
        if ((this.codEvento == null && other.codEvento != null) || (this.codEvento != null && !this.codEvento.equals(other.codEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgEvento[ codEvento=" + codEvento + " ]";
    }
    
}
