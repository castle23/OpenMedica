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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odo_diente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoDiente.findAll", query = "SELECT o FROM OdoDiente o"),
    @NamedQuery(name = "OdoDiente.findByIdDiente", query = "SELECT o FROM OdoDiente o WHERE o.idDiente = :idDiente"),
    @NamedQuery(name = "OdoDiente.findByNumeracionFdi", query = "SELECT o FROM OdoDiente o WHERE o.numeracionFdi = :numeracionFdi"),
    @NamedQuery(name = "OdoDiente.findByOrden", query = "SELECT o FROM OdoDiente o WHERE o.orden = :orden")})
public class OdoDiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diente")
    private Integer idDiente;
    @Column(name = "numeracion_fdi")
    private Integer numeracionFdi;
    @Column(name = "orden")
    private Integer orden;
    @OneToMany(mappedBy = "dienteId")
    private List<OdoDienteOdontograma> odoDienteOdontogramaList;
    @JoinColumn(name = "tipo_diente_id", referencedColumnName = "id_tipo_diente")
    @ManyToOne
    private OdoTipoDiente tipoDienteId;

    public OdoDiente() {
    }

    public OdoDiente(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public Integer getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public Integer getNumeracionFdi() {
        return numeracionFdi;
    }

    public void setNumeracionFdi(Integer numeracionFdi) {
        this.numeracionFdi = numeracionFdi;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @XmlTransient
    public List<OdoDienteOdontograma> getOdoDienteOdontogramaList() {
        return odoDienteOdontogramaList;
    }

    public void setOdoDienteOdontogramaList(List<OdoDienteOdontograma> odoDienteOdontogramaList) {
        this.odoDienteOdontogramaList = odoDienteOdontogramaList;
    }

    public OdoTipoDiente getTipoDienteId() {
        return tipoDienteId;
    }

    public void setTipoDienteId(OdoTipoDiente tipoDienteId) {
        this.tipoDienteId = tipoDienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiente != null ? idDiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoDiente)) {
            return false;
        }
        OdoDiente other = (OdoDiente) object;
        if ((this.idDiente == null && other.idDiente != null) || (this.idDiente != null && !this.idDiente.equals(other.idDiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoDiente[ idDiente=" + idDiente + " ]";
    }
    
}
