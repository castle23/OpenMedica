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
@Table(name = "hc_tipo_reg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcTipoReg.findAll", query = "SELECT h FROM HcTipoReg h"),
    @NamedQuery(name = "HcTipoReg.findByIdTipoReg", query = "SELECT h FROM HcTipoReg h WHERE h.idTipoReg = :idTipoReg"),
    @NamedQuery(name = "HcTipoReg.findByNombre", query = "SELECT h FROM HcTipoReg h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HcTipoReg.findByUrlPagina", query = "SELECT h FROM HcTipoReg h WHERE h.urlPagina = :urlPagina"),
    @NamedQuery(name = "HcTipoReg.findByActivo", query = "SELECT h FROM HcTipoReg h WHERE h.activo = :activo"),
    @NamedQuery(name = "HcTipoReg.findByCantCampos", query = "SELECT h FROM HcTipoReg h WHERE h.cantCampos = :cantCampos"),
    @NamedQuery(name = "HcTipoReg.findByConsecutivo", query = "SELECT h FROM HcTipoReg h WHERE h.consecutivo = :consecutivo")})
public class HcTipoReg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_reg")
    private Integer idTipoReg;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "url_pagina")
    private String urlPagina;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "cant_campos")
    private Integer cantCampos;
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @OneToMany(mappedBy = "idTipoReg")
    private List<HcCamposReg> hcCamposRegList;
    @OneToMany(mappedBy = "idTipoReg")
    private List<HcRegistro> hcRegistroList;
    @OneToMany(mappedBy = "idTipoRegistro")
    private List<OdoRegistro> odoRegistroList;

    public HcTipoReg() {
    }

    public HcTipoReg(Integer idTipoReg) {
        this.idTipoReg = idTipoReg;
    }

    public Integer getIdTipoReg() {
        return idTipoReg;
    }

    public void setIdTipoReg(Integer idTipoReg) {
        this.idTipoReg = idTipoReg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPagina() {
        return urlPagina;
    }

    public void setUrlPagina(String urlPagina) {
        this.urlPagina = urlPagina;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getCantCampos() {
        return cantCampos;
    }

    public void setCantCampos(Integer cantCampos) {
        this.cantCampos = cantCampos;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    @XmlTransient
    public List<HcCamposReg> getHcCamposRegList() {
        return hcCamposRegList;
    }

    public void setHcCamposRegList(List<HcCamposReg> hcCamposRegList) {
        this.hcCamposRegList = hcCamposRegList;
    }

    @XmlTransient
    public List<HcRegistro> getHcRegistroList() {
        return hcRegistroList;
    }

    public void setHcRegistroList(List<HcRegistro> hcRegistroList) {
        this.hcRegistroList = hcRegistroList;
    }

    @XmlTransient
    public List<OdoRegistro> getOdoRegistroList() {
        return odoRegistroList;
    }

    public void setOdoRegistroList(List<OdoRegistro> odoRegistroList) {
        this.odoRegistroList = odoRegistroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoReg != null ? idTipoReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcTipoReg)) {
            return false;
        }
        HcTipoReg other = (HcTipoReg) object;
        if ((this.idTipoReg == null && other.idTipoReg != null) || (this.idTipoReg != null && !this.idTipoReg.equals(other.idTipoReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.HcTipoReg[ idTipoReg=" + idTipoReg + " ]";
    }
    
}
