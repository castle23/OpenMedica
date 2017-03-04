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
@Table(name = "odo_tipo_diente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoTipoDiente.findAll", query = "SELECT o FROM OdoTipoDiente o"),
    @NamedQuery(name = "OdoTipoDiente.findByIdTipoDiente", query = "SELECT o FROM OdoTipoDiente o WHERE o.idTipoDiente = :idTipoDiente"),
    @NamedQuery(name = "OdoTipoDiente.findByNombre", query = "SELECT o FROM OdoTipoDiente o WHERE o.nombre = :nombre")})
public class OdoTipoDiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_diente")
    private Integer idTipoDiente;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "tipoDienteId")
    private List<OdoDiente> odoDienteList;

    public OdoTipoDiente() {
    }

    public OdoTipoDiente(Integer idTipoDiente) {
        this.idTipoDiente = idTipoDiente;
    }

    public Integer getIdTipoDiente() {
        return idTipoDiente;
    }

    public void setIdTipoDiente(Integer idTipoDiente) {
        this.idTipoDiente = idTipoDiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<OdoDiente> getOdoDienteList() {
        return odoDienteList;
    }

    public void setOdoDienteList(List<OdoDiente> odoDienteList) {
        this.odoDienteList = odoDienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDiente != null ? idTipoDiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoTipoDiente)) {
            return false;
        }
        OdoTipoDiente other = (OdoTipoDiente) object;
        if ((this.idTipoDiente == null && other.idTipoDiente != null) || (this.idTipoDiente != null && !this.idTipoDiente.equals(other.idTipoDiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoTipoDiente[ idTipoDiente=" + idTipoDiente + " ]";
    }
    
}
