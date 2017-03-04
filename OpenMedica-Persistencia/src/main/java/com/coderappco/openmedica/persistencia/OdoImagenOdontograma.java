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
@Table(name = "odo_imagen_odontograma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoImagenOdontograma.findAll", query = "SELECT o FROM OdoImagenOdontograma o"),
    @NamedQuery(name = "OdoImagenOdontograma.findByIdImagenOdontograma", query = "SELECT o FROM OdoImagenOdontograma o WHERE o.idImagenOdontograma = :idImagenOdontograma"),
    @NamedQuery(name = "OdoImagenOdontograma.findByUrlImagen", query = "SELECT o FROM OdoImagenOdontograma o WHERE o.urlImagen = :urlImagen"),
    @NamedQuery(name = "OdoImagenOdontograma.findByActivo", query = "SELECT o FROM OdoImagenOdontograma o WHERE o.activo = :activo")})
public class OdoImagenOdontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagen_odontograma")
    private Integer idImagenOdontograma;
    @Size(max = 2147483647)
    @Column(name = "url_imagen")
    private String urlImagen;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "odontogramaImagenId")
    private List<OdoDienteOdontograma> odoDienteOdontogramaList;
    @JoinColumn(name = "id_convenccion", referencedColumnName = "id_convenccion")
    @ManyToOne
    private OdoConvenccion idConvenccion;
    @JoinColumn(name = "id_superficie_dental", referencedColumnName = "id_superficie_dental")
    @ManyToOne
    private OdoSuperficieDental idSuperficieDental;

    public OdoImagenOdontograma() {
    }

    public OdoImagenOdontograma(Integer idImagenOdontograma) {
        this.idImagenOdontograma = idImagenOdontograma;
    }

    public Integer getIdImagenOdontograma() {
        return idImagenOdontograma;
    }

    public void setIdImagenOdontograma(Integer idImagenOdontograma) {
        this.idImagenOdontograma = idImagenOdontograma;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<OdoDienteOdontograma> getOdoDienteOdontogramaList() {
        return odoDienteOdontogramaList;
    }

    public void setOdoDienteOdontogramaList(List<OdoDienteOdontograma> odoDienteOdontogramaList) {
        this.odoDienteOdontogramaList = odoDienteOdontogramaList;
    }

    public OdoConvenccion getIdConvenccion() {
        return idConvenccion;
    }

    public void setIdConvenccion(OdoConvenccion idConvenccion) {
        this.idConvenccion = idConvenccion;
    }

    public OdoSuperficieDental getIdSuperficieDental() {
        return idSuperficieDental;
    }

    public void setIdSuperficieDental(OdoSuperficieDental idSuperficieDental) {
        this.idSuperficieDental = idSuperficieDental;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagenOdontograma != null ? idImagenOdontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoImagenOdontograma)) {
            return false;
        }
        OdoImagenOdontograma other = (OdoImagenOdontograma) object;
        if ((this.idImagenOdontograma == null && other.idImagenOdontograma != null) || (this.idImagenOdontograma != null && !this.idImagenOdontograma.equals(other.idImagenOdontograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoImagenOdontograma[ idImagenOdontograma=" + idImagenOdontograma + " ]";
    }
    
}
