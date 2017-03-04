/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hc_campos_reg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcCamposReg.findAll", query = "SELECT h FROM HcCamposReg h"),
    @NamedQuery(name = "HcCamposReg.findByIdCampo", query = "SELECT h FROM HcCamposReg h WHERE h.idCampo = :idCampo"),
    @NamedQuery(name = "HcCamposReg.findByNombre", query = "SELECT h FROM HcCamposReg h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HcCamposReg.findByTabla", query = "SELECT h FROM HcCamposReg h WHERE h.tabla = :tabla"),
    @NamedQuery(name = "HcCamposReg.findByPosicion", query = "SELECT h FROM HcCamposReg h WHERE h.posicion = :posicion"),
    @NamedQuery(name = "HcCamposReg.findByNombrePdf", query = "SELECT h FROM HcCamposReg h WHERE h.nombrePdf = :nombrePdf")})
public class HcCamposReg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campo")
    private Integer idCampo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "posicion")
    private Integer posicion;
    @Size(max = 2147483647)
    @Column(name = "nombre_pdf")
    private String nombrePdf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hcCamposReg")
    private List<HcDetalle> hcDetalleList;
    @JoinColumn(name = "id_tipo_reg", referencedColumnName = "id_tipo_reg")
    @ManyToOne
    private HcTipoReg idTipoReg;
    @OneToMany(mappedBy = "idCampo")
    private List<OdoRegistroDetalle> odoRegistroDetalleList;

    public HcCamposReg() {
    }

    public HcCamposReg(Integer idCampo) {
        this.idCampo = idCampo;
    }

    public Integer getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Integer idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

    @XmlTransient
    public List<HcDetalle> getHcDetalleList() {
        return hcDetalleList;
    }

    public void setHcDetalleList(List<HcDetalle> hcDetalleList) {
        this.hcDetalleList = hcDetalleList;
    }

    public HcTipoReg getIdTipoReg() {
        return idTipoReg;
    }

    public void setIdTipoReg(HcTipoReg idTipoReg) {
        this.idTipoReg = idTipoReg;
    }

    @XmlTransient
    public List<OdoRegistroDetalle> getOdoRegistroDetalleList() {
        return odoRegistroDetalleList;
    }

    public void setOdoRegistroDetalleList(List<OdoRegistroDetalle> odoRegistroDetalleList) {
        this.odoRegistroDetalleList = odoRegistroDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampo != null ? idCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcCamposReg)) {
            return false;
        }
        HcCamposReg other = (HcCamposReg) object;
        if ((this.idCampo == null && other.idCampo != null) || (this.idCampo != null && !this.idCampo.equals(other.idCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.HcCamposReg[ idCampo=" + idCampo + " ]";
    }
    
}
