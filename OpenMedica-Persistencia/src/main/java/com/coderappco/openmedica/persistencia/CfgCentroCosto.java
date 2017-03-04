/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "cfg_centro_costo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCentroCosto.findAll", query = "SELECT c FROM CfgCentroCosto c"),
    @NamedQuery(name = "CfgCentroCosto.findByIdCentroCosto", query = "SELECT c FROM CfgCentroCosto c WHERE c.idCentroCosto = :idCentroCosto"),
    @NamedQuery(name = "CfgCentroCosto.findByCodCentroCosto", query = "SELECT c FROM CfgCentroCosto c WHERE c.codCentroCosto = :codCentroCosto"),
    @NamedQuery(name = "CfgCentroCosto.findByNomCentroCosto", query = "SELECT c FROM CfgCentroCosto c WHERE c.nomCentroCosto = :nomCentroCosto"),
    @NamedQuery(name = "CfgCentroCosto.findByCtaContableIng", query = "SELECT c FROM CfgCentroCosto c WHERE c.ctaContableIng = :ctaContableIng"),
    @NamedQuery(name = "CfgCentroCosto.findByCtaContableIngPs", query = "SELECT c FROM CfgCentroCosto c WHERE c.ctaContableIngPs = :ctaContableIngPs"),
    @NamedQuery(name = "CfgCentroCosto.findByCtaDevolucion", query = "SELECT c FROM CfgCentroCosto c WHERE c.ctaDevolucion = :ctaDevolucion"),
    @NamedQuery(name = "CfgCentroCosto.findByConcCartera", query = "SELECT c FROM CfgCentroCosto c WHERE c.concCartera = :concCartera"),
    @NamedQuery(name = "CfgCentroCosto.findByConcDevolucion", query = "SELECT c FROM CfgCentroCosto c WHERE c.concDevolucion = :concDevolucion")})
public class CfgCentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro_costo")
    private Integer idCentroCosto;
    @Size(max = 50)
    @Column(name = "cod_centro_costo")
    private String codCentroCosto;
    @Size(max = 100)
    @Column(name = "nom_centro_costo")
    private String nomCentroCosto;
    @Size(max = 20)
    @Column(name = "cta_contable_ing")
    private String ctaContableIng;
    @Size(max = 20)
    @Column(name = "cta_contable_ing_ps")
    private String ctaContableIngPs;
    @Size(max = 20)
    @Column(name = "cta_devolucion")
    private String ctaDevolucion;
    @Size(max = 2)
    @Column(name = "conc_cartera")
    private String concCartera;
    @Size(max = 2)
    @Column(name = "conc_devolucion")
    private String concDevolucion;
    @OneToMany(mappedBy = "centroCosto")
    private List<FacServicio> facServicioList;

    public CfgCentroCosto() {
    }

    public CfgCentroCosto(Integer idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public Integer getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(Integer idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public String getCodCentroCosto() {
        return codCentroCosto;
    }

    public void setCodCentroCosto(String codCentroCosto) {
        this.codCentroCosto = codCentroCosto;
    }

    public String getNomCentroCosto() {
        return nomCentroCosto;
    }

    public void setNomCentroCosto(String nomCentroCosto) {
        this.nomCentroCosto = nomCentroCosto;
    }

    public String getCtaContableIng() {
        return ctaContableIng;
    }

    public void setCtaContableIng(String ctaContableIng) {
        this.ctaContableIng = ctaContableIng;
    }

    public String getCtaContableIngPs() {
        return ctaContableIngPs;
    }

    public void setCtaContableIngPs(String ctaContableIngPs) {
        this.ctaContableIngPs = ctaContableIngPs;
    }

    public String getCtaDevolucion() {
        return ctaDevolucion;
    }

    public void setCtaDevolucion(String ctaDevolucion) {
        this.ctaDevolucion = ctaDevolucion;
    }

    public String getConcCartera() {
        return concCartera;
    }

    public void setConcCartera(String concCartera) {
        this.concCartera = concCartera;
    }

    public String getConcDevolucion() {
        return concDevolucion;
    }

    public void setConcDevolucion(String concDevolucion) {
        this.concDevolucion = concDevolucion;
    }

    @XmlTransient
    public List<FacServicio> getFacServicioList() {
        return facServicioList;
    }

    public void setFacServicioList(List<FacServicio> facServicioList) {
        this.facServicioList = facServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroCosto != null ? idCentroCosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCentroCosto)) {
            return false;
        }
        CfgCentroCosto other = (CfgCentroCosto) object;
        if ((this.idCentroCosto == null && other.idCentroCosto != null) || (this.idCentroCosto != null && !this.idCentroCosto.equals(other.idCentroCosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgCentroCosto[ idCentroCosto=" + idCentroCosto + " ]";
    }
    
}
