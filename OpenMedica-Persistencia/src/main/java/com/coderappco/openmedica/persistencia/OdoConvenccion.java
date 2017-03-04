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
@Table(name = "odo_convenccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoConvenccion.findAll", query = "SELECT o FROM OdoConvenccion o"),
    @NamedQuery(name = "OdoConvenccion.findByIdConvenccion", query = "SELECT o FROM OdoConvenccion o WHERE o.idConvenccion = :idConvenccion"),
    @NamedQuery(name = "OdoConvenccion.findByDescripcion", query = "SELECT o FROM OdoConvenccion o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "OdoConvenccion.findByActivo", query = "SELECT o FROM OdoConvenccion o WHERE o.activo = :activo"),
    @NamedQuery(name = "OdoConvenccion.findByTodo", query = "SELECT o FROM OdoConvenccion o WHERE o.todo = :todo")})
public class OdoConvenccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_convenccion")
    private Integer idConvenccion;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "todo")
    private Boolean todo;
    @OneToMany(mappedBy = "convenccionId")
    private List<OdoDienteOdontograma> odoDienteOdontogramaList;
    @OneToMany(mappedBy = "idConvenccion")
    private List<OdoImagenOdontograma> odoImagenOdontogramaList;

    public OdoConvenccion() {
    }

    public OdoConvenccion(Integer idConvenccion) {
        this.idConvenccion = idConvenccion;
    }

    public Integer getIdConvenccion() {
        return idConvenccion;
    }

    public void setIdConvenccion(Integer idConvenccion) {
        this.idConvenccion = idConvenccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getTodo() {
        return todo;
    }

    public void setTodo(Boolean todo) {
        this.todo = todo;
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
        hash += (idConvenccion != null ? idConvenccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoConvenccion)) {
            return false;
        }
        OdoConvenccion other = (OdoConvenccion) object;
        if ((this.idConvenccion == null && other.idConvenccion != null) || (this.idConvenccion != null && !this.idConvenccion.equals(other.idConvenccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoConvenccion[ idConvenccion=" + idConvenccion + " ]";
    }
    
}
