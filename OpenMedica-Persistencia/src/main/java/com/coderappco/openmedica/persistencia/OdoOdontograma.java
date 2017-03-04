/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odo_odontograma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoOdontograma.findAll", query = "SELECT o FROM OdoOdontograma o"),
    @NamedQuery(name = "OdoOdontograma.findByIdOdontograma", query = "SELECT o FROM OdoOdontograma o WHERE o.idOdontograma = :idOdontograma"),
    @NamedQuery(name = "OdoOdontograma.findByObservacion", query = "SELECT o FROM OdoOdontograma o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "OdoOdontograma.findByFechaCreacion", query = "SELECT o FROM OdoOdontograma o WHERE o.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "OdoOdontograma.findByFechaActualizacion", query = "SELECT o FROM OdoOdontograma o WHERE o.fechaActualizacion = :fechaActualizacion")})
public class OdoOdontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_odontograma")
    private Integer idOdontograma;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(mappedBy = "odontogramaId")
    private List<OdoDienteOdontograma> odoDienteOdontogramaList;
    @JoinColumn(name = "id_registro", referencedColumnName = "id")
    @ManyToOne
    private OdoRegistro idRegistro;

    public OdoOdontograma() {
    }

    public OdoOdontograma(Integer idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public Integer getIdOdontograma() {
        return idOdontograma;
    }

    public void setIdOdontograma(Integer idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @XmlTransient
    public List<OdoDienteOdontograma> getOdoDienteOdontogramaList() {
        return odoDienteOdontogramaList;
    }

    public void setOdoDienteOdontogramaList(List<OdoDienteOdontograma> odoDienteOdontogramaList) {
        this.odoDienteOdontogramaList = odoDienteOdontogramaList;
    }

    public OdoRegistro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(OdoRegistro idRegistro) {
        this.idRegistro = idRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOdontograma != null ? idOdontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoOdontograma)) {
            return false;
        }
        OdoOdontograma other = (OdoOdontograma) object;
        if ((this.idOdontograma == null && other.idOdontograma != null) || (this.idOdontograma != null && !this.idOdontograma.equals(other.idOdontograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoOdontograma[ idOdontograma=" + idOdontograma + " ]";
    }
    
}
