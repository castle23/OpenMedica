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
@Table(name = "odo_superficie_dental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoSuperficieDental.findAll", query = "SELECT o FROM OdoSuperficieDental o"),
    @NamedQuery(name = "OdoSuperficieDental.findByIdSuperficieDental", query = "SELECT o FROM OdoSuperficieDental o WHERE o.idSuperficieDental = :idSuperficieDental"),
    @NamedQuery(name = "OdoSuperficieDental.findByCodigo", query = "SELECT o FROM OdoSuperficieDental o WHERE o.codigo = :codigo"),
    @NamedQuery(name = "OdoSuperficieDental.findByNombre", query = "SELECT o FROM OdoSuperficieDental o WHERE o.nombre = :nombre")})
public class OdoSuperficieDental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_superficie_dental")
    private Integer idSuperficieDental;
    @Column(name = "codigo")
    private Character codigo;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "superficieDentalId")
    private List<OdoDienteOdontograma> odoDienteOdontogramaList;
    @OneToMany(mappedBy = "idSuperficieDental")
    private List<OdoImagenOdontograma> odoImagenOdontogramaList;

    public OdoSuperficieDental() {
    }

    public OdoSuperficieDental(Integer idSuperficieDental) {
        this.idSuperficieDental = idSuperficieDental;
    }

    public Integer getIdSuperficieDental() {
        return idSuperficieDental;
    }

    public void setIdSuperficieDental(Integer idSuperficieDental) {
        this.idSuperficieDental = idSuperficieDental;
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<OdoDienteOdontograma> getOdoDienteOdontogramaList() {
        return odoDienteOdontogramaList;
    }

    public void setOdoDienteOdontogramaList(List<OdoDienteOdontograma> odoDienteOdontogramaList) {
        this.odoDienteOdontogramaList = odoDienteOdontogramaList;
    }

    @XmlTransient
    public List<OdoImagenOdontograma> getOdoImagenOdontogramaList() {
        return odoImagenOdontogramaList;
    }

    public void setOdoImagenOdontogramaList(List<OdoImagenOdontograma> odoImagenOdontogramaList) {
        this.odoImagenOdontogramaList = odoImagenOdontogramaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuperficieDental != null ? idSuperficieDental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoSuperficieDental)) {
            return false;
        }
        OdoSuperficieDental other = (OdoSuperficieDental) object;
        if ((this.idSuperficieDental == null && other.idSuperficieDental != null) || (this.idSuperficieDental != null && !this.idSuperficieDental.equals(other.idSuperficieDental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoSuperficieDental[ idSuperficieDental=" + idSuperficieDental + " ]";
    }
    
}
