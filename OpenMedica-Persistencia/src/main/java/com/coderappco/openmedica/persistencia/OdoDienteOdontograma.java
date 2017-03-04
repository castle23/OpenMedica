/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odo_diente_odontograma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoDienteOdontograma.findAll", query = "SELECT o FROM OdoDienteOdontograma o"),
    @NamedQuery(name = "OdoDienteOdontograma.findByIdDienteOdontograma", query = "SELECT o FROM OdoDienteOdontograma o WHERE o.idDienteOdontograma = :idDienteOdontograma"),
    @NamedQuery(name = "OdoDienteOdontograma.findByFechaCreacion", query = "SELECT o FROM OdoDienteOdontograma o WHERE o.fechaCreacion = :fechaCreacion")})
public class OdoDienteOdontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diente_odontograma")
    private Integer idDienteOdontograma;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "convenccion_id", referencedColumnName = "id_convenccion")
    @ManyToOne
    private OdoConvenccion convenccionId;
    @JoinColumn(name = "diente_id", referencedColumnName = "id_diente")
    @ManyToOne
    private OdoDiente dienteId;
    @JoinColumn(name = "odontograma_imagen_id", referencedColumnName = "id_imagen_odontograma")
    @ManyToOne
    private OdoImagenOdontograma odontogramaImagenId;
    @JoinColumn(name = "odontograma_id", referencedColumnName = "id_odontograma")
    @ManyToOne
    private OdoOdontograma odontogramaId;
    @JoinColumn(name = "superficie_dental_id", referencedColumnName = "id_superficie_dental")
    @ManyToOne
    private OdoSuperficieDental superficieDentalId;

    public OdoDienteOdontograma() {
    }

    public OdoDienteOdontograma(Integer idDienteOdontograma) {
        this.idDienteOdontograma = idDienteOdontograma;
    }

    public Integer getIdDienteOdontograma() {
        return idDienteOdontograma;
    }

    public void setIdDienteOdontograma(Integer idDienteOdontograma) {
        this.idDienteOdontograma = idDienteOdontograma;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public OdoConvenccion getConvenccionId() {
        return convenccionId;
    }

    public void setConvenccionId(OdoConvenccion convenccionId) {
        this.convenccionId = convenccionId;
    }

    public OdoDiente getDienteId() {
        return dienteId;
    }

    public void setDienteId(OdoDiente dienteId) {
        this.dienteId = dienteId;
    }

    public OdoImagenOdontograma getOdontogramaImagenId() {
        return odontogramaImagenId;
    }

    public void setOdontogramaImagenId(OdoImagenOdontograma odontogramaImagenId) {
        this.odontogramaImagenId = odontogramaImagenId;
    }

    public OdoOdontograma getOdontogramaId() {
        return odontogramaId;
    }

    public void setOdontogramaId(OdoOdontograma odontogramaId) {
        this.odontogramaId = odontogramaId;
    }

    public OdoSuperficieDental getSuperficieDentalId() {
        return superficieDentalId;
    }

    public void setSuperficieDentalId(OdoSuperficieDental superficieDentalId) {
        this.superficieDentalId = superficieDentalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDienteOdontograma != null ? idDienteOdontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoDienteOdontograma)) {
            return false;
        }
        OdoDienteOdontograma other = (OdoDienteOdontograma) object;
        if ((this.idDienteOdontograma == null && other.idDienteOdontograma != null) || (this.idDienteOdontograma != null && !this.idDienteOdontograma.equals(other.idDienteOdontograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoDienteOdontograma[ idDienteOdontograma=" + idDienteOdontograma + " ]";
    }
    
}
