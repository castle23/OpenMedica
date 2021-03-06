/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "fac_factura_insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacFacturaInsumo.findAll", query = "SELECT f FROM FacFacturaInsumo f"),
    @NamedQuery(name = "FacFacturaInsumo.findByIdDetalle", query = "SELECT f FROM FacFacturaInsumo f WHERE f.facFacturaInsumoPK.idDetalle = :idDetalle"),
    @NamedQuery(name = "FacFacturaInsumo.findByIdFactura", query = "SELECT f FROM FacFacturaInsumo f WHERE f.facFacturaInsumoPK.idFactura = :idFactura"),
    @NamedQuery(name = "FacFacturaInsumo.findByFechaInsumo", query = "SELECT f FROM FacFacturaInsumo f WHERE f.fechaInsumo = :fechaInsumo"),
    @NamedQuery(name = "FacFacturaInsumo.findByCantidadInsumo", query = "SELECT f FROM FacFacturaInsumo f WHERE f.cantidadInsumo = :cantidadInsumo"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorInsumo", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorInsumo = :valorInsumo"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorParcial", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorParcial = :valorParcial"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorUsuario", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorUsuario = :valorUsuario"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorEmpresa", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorEmpresa = :valorEmpresa"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorIva", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorIva = :valorIva"),
    @NamedQuery(name = "FacFacturaInsumo.findByValorCree", query = "SELECT f FROM FacFacturaInsumo f WHERE f.valorCree = :valorCree"),
    @NamedQuery(name = "FacFacturaInsumo.findByNumAutorizacion", query = "SELECT f FROM FacFacturaInsumo f WHERE f.numAutorizacion = :numAutorizacion"),
    @NamedQuery(name = "FacFacturaInsumo.findByFechaAutorizacion", query = "SELECT f FROM FacFacturaInsumo f WHERE f.fechaAutorizacion = :fechaAutorizacion")})
public class FacFacturaInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacFacturaInsumoPK facFacturaInsumoPK;
    @Column(name = "fecha_insumo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInsumo;
    @Column(name = "cantidad_insumo")
    private Short cantidadInsumo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_insumo")
    private Double valorInsumo;
    @Column(name = "valor_parcial")
    private Double valorParcial;
    @Column(name = "valor_usuario")
    private Double valorUsuario;
    @Column(name = "valor_empresa")
    private Double valorEmpresa;
    @Column(name = "valor_iva")
    private Double valorIva;
    @Column(name = "valor_cree")
    private Double valorCree;
    @Size(max = 20)
    @Column(name = "num_autorizacion")
    private String numAutorizacion;
    @Column(name = "fecha_autorizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizacion;
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id_consultorio")
    @ManyToOne
    private CfgConsultorios idConsultorio;
    @JoinColumn(name = "id_insumo", referencedColumnName = "id_insumo")
    @ManyToOne
    private CfgInsumo idInsumo;
    @JoinColumn(name = "id_medico", referencedColumnName = "id_usuario")
    @ManyToOne
    private CfgUsuarios idMedico;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura_paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacFacturaPaciente facFacturaPaciente;

    public FacFacturaInsumo() {
    }

    public FacFacturaInsumo(FacFacturaInsumoPK facFacturaInsumoPK) {
        this.facFacturaInsumoPK = facFacturaInsumoPK;
    }

    public FacFacturaInsumo(int idDetalle, int idFactura) {
        this.facFacturaInsumoPK = new FacFacturaInsumoPK(idDetalle, idFactura);
    }

    public FacFacturaInsumoPK getFacFacturaInsumoPK() {
        return facFacturaInsumoPK;
    }

    public void setFacFacturaInsumoPK(FacFacturaInsumoPK facFacturaInsumoPK) {
        this.facFacturaInsumoPK = facFacturaInsumoPK;
    }

    public Date getFechaInsumo() {
        return fechaInsumo;
    }

    public void setFechaInsumo(Date fechaInsumo) {
        this.fechaInsumo = fechaInsumo;
    }

    public Short getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(Short cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public Double getValorInsumo() {
        return valorInsumo;
    }

    public void setValorInsumo(Double valorInsumo) {
        this.valorInsumo = valorInsumo;
    }

    public Double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(Double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Double getValorUsuario() {
        return valorUsuario;
    }

    public void setValorUsuario(Double valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    public Double getValorEmpresa() {
        return valorEmpresa;
    }

    public void setValorEmpresa(Double valorEmpresa) {
        this.valorEmpresa = valorEmpresa;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public Double getValorCree() {
        return valorCree;
    }

    public void setValorCree(Double valorCree) {
        this.valorCree = valorCree;
    }

    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public CfgConsultorios getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(CfgConsultorios idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public CfgInsumo getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(CfgInsumo idInsumo) {
        this.idInsumo = idInsumo;
    }

    public CfgUsuarios getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(CfgUsuarios idMedico) {
        this.idMedico = idMedico;
    }

    public FacFacturaPaciente getFacFacturaPaciente() {
        return facFacturaPaciente;
    }

    public void setFacFacturaPaciente(FacFacturaPaciente facFacturaPaciente) {
        this.facFacturaPaciente = facFacturaPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facFacturaInsumoPK != null ? facFacturaInsumoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacFacturaInsumo)) {
            return false;
        }
        FacFacturaInsumo other = (FacFacturaInsumo) object;
        if ((this.facFacturaInsumoPK == null && other.facFacturaInsumoPK != null) || (this.facFacturaInsumoPK != null && !this.facFacturaInsumoPK.equals(other.facFacturaInsumoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.FacFacturaInsumo[ facFacturaInsumoPK=" + facFacturaInsumoPK + " ]";
    }
    
}
