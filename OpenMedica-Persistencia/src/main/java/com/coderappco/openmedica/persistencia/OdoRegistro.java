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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odo_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoRegistro.findAll", query = "SELECT o FROM OdoRegistro o"),
    @NamedQuery(name = "OdoRegistro.findById", query = "SELECT o FROM OdoRegistro o WHERE o.id = :id"),
    @NamedQuery(name = "OdoRegistro.findByFechaRegistro", query = "SELECT o FROM OdoRegistro o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OdoRegistro.findByFechaSistema", query = "SELECT o FROM OdoRegistro o WHERE o.fechaSistema = :fechaSistema"),
    @NamedQuery(name = "OdoRegistro.findByFolio", query = "SELECT o FROM OdoRegistro o WHERE o.folio = :folio")})
public class OdoRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fecha_sistema")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSistema;
    @Column(name = "folio")
    private Integer folio;
    @OneToMany(mappedBy = "idRegistro")
    private List<OdoOdontograma> odoOdontogramaList;
    @OneToMany(mappedBy = "idRegistro")
    private List<OdoRegistroDetalle> odoRegistroDetalleList;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private CfgPacientes idPaciente;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios idMedico;
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita")
    @ManyToOne
    private CitCitas idCita;
    @JoinColumn(name = "id_tipo_registro", referencedColumnName = "id_tipo_reg")
    @ManyToOne
    private HcTipoReg idTipoRegistro;

    public OdoRegistro() {
    }

    public OdoRegistro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    @XmlTransient
    public List<OdoOdontograma> getOdoOdontogramaList() {
        return odoOdontogramaList;
    }

    public void setOdoOdontogramaList(List<OdoOdontograma> odoOdontogramaList) {
        this.odoOdontogramaList = odoOdontogramaList;
    }

    @XmlTransient
    public List<OdoRegistroDetalle> getOdoRegistroDetalleList() {
        return odoRegistroDetalleList;
    }

    public void setOdoRegistroDetalleList(List<OdoRegistroDetalle> odoRegistroDetalleList) {
        this.odoRegistroDetalleList = odoRegistroDetalleList;
    }

    public CfgPacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(CfgPacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public CfgUsuarios getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(CfgUsuarios idMedico) {
        this.idMedico = idMedico;
    }

    public CitCitas getIdCita() {
        return idCita;
    }

    public void setIdCita(CitCitas idCita) {
        this.idCita = idCita;
    }

    public HcTipoReg getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(HcTipoReg idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoRegistro)) {
            return false;
        }
        OdoRegistro other = (OdoRegistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoRegistro[ id=" + id + " ]";
    }
    
}
