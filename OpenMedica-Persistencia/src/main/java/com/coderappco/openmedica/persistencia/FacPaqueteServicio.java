/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "fac_paquete_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacPaqueteServicio.findAll", query = "SELECT f FROM FacPaqueteServicio f"),
    @NamedQuery(name = "FacPaqueteServicio.findByIdPaquete", query = "SELECT f FROM FacPaqueteServicio f WHERE f.facPaqueteServicioPK.idPaquete = :idPaquete"),
    @NamedQuery(name = "FacPaqueteServicio.findByIdServicio", query = "SELECT f FROM FacPaqueteServicio f WHERE f.facPaqueteServicioPK.idServicio = :idServicio"),
    @NamedQuery(name = "FacPaqueteServicio.findByValorFinal", query = "SELECT f FROM FacPaqueteServicio f WHERE f.valorFinal = :valorFinal"),
    @NamedQuery(name = "FacPaqueteServicio.findByMetaCumplimiento", query = "SELECT f FROM FacPaqueteServicio f WHERE f.metaCumplimiento = :metaCumplimiento"),
    @NamedQuery(name = "FacPaqueteServicio.findByPeriodicidad", query = "SELECT f FROM FacPaqueteServicio f WHERE f.periodicidad = :periodicidad"),
    @NamedQuery(name = "FacPaqueteServicio.findByDescuento", query = "SELECT f FROM FacPaqueteServicio f WHERE f.descuento = :descuento"),
    @NamedQuery(name = "FacPaqueteServicio.findByHonorarioMedico", query = "SELECT f FROM FacPaqueteServicio f WHERE f.honorarioMedico = :honorarioMedico"),
    @NamedQuery(name = "FacPaqueteServicio.findByObservacion", query = "SELECT f FROM FacPaqueteServicio f WHERE f.observacion = :observacion"),
    @NamedQuery(name = "FacPaqueteServicio.findByActivo", query = "SELECT f FROM FacPaqueteServicio f WHERE f.activo = :activo"),
    @NamedQuery(name = "FacPaqueteServicio.findByTipoTarifa", query = "SELECT f FROM FacPaqueteServicio f WHERE f.tipoTarifa = :tipoTarifa"),
    @NamedQuery(name = "FacPaqueteServicio.findByCantidad", query = "SELECT f FROM FacPaqueteServicio f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FacPaqueteServicio.findByValorUnitario", query = "SELECT f FROM FacPaqueteServicio f WHERE f.valorUnitario = :valorUnitario")})
public class FacPaqueteServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacPaqueteServicioPK facPaqueteServicioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_final")
    private Double valorFinal;
    @Column(name = "meta_cumplimiento")
    private Integer metaCumplimiento;
    @Column(name = "periodicidad")
    private Integer periodicidad;
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "honorario_medico")
    private Double honorarioMedico;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 11)
    @Column(name = "tipo_tarifa")
    private String tipoTarifa;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @JoinColumn(name = "id_paquete", referencedColumnName = "id_paquete", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacPaquete facPaquete;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacServicio facServicio;

    public FacPaqueteServicio() {
    }

    public FacPaqueteServicio(FacPaqueteServicioPK facPaqueteServicioPK) {
        this.facPaqueteServicioPK = facPaqueteServicioPK;
    }

    public FacPaqueteServicio(int idPaquete, int idServicio) {
        this.facPaqueteServicioPK = new FacPaqueteServicioPK(idPaquete, idServicio);
    }

    public FacPaqueteServicioPK getFacPaqueteServicioPK() {
        return facPaqueteServicioPK;
    }

    public void setFacPaqueteServicioPK(FacPaqueteServicioPK facPaqueteServicioPK) {
        this.facPaqueteServicioPK = facPaqueteServicioPK;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Integer getMetaCumplimiento() {
        return metaCumplimiento;
    }

    public void setMetaCumplimiento(Integer metaCumplimiento) {
        this.metaCumplimiento = metaCumplimiento;
    }

    public Integer getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Integer periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getHonorarioMedico() {
        return honorarioMedico;
    }

    public void setHonorarioMedico(Double honorarioMedico) {
        this.honorarioMedico = honorarioMedico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public FacPaquete getFacPaquete() {
        return facPaquete;
    }

    public void setFacPaquete(FacPaquete facPaquete) {
        this.facPaquete = facPaquete;
    }

    public FacServicio getFacServicio() {
        return facServicio;
    }

    public void setFacServicio(FacServicio facServicio) {
        this.facServicio = facServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facPaqueteServicioPK != null ? facPaqueteServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacPaqueteServicio)) {
            return false;
        }
        FacPaqueteServicio other = (FacPaqueteServicio) object;
        if ((this.facPaqueteServicioPK == null && other.facPaqueteServicioPK != null) || (this.facPaqueteServicioPK != null && !this.facPaqueteServicioPK.equals(other.facPaqueteServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.FacPaqueteServicio[ facPaqueteServicioPK=" + facPaqueteServicioPK + " ]";
    }
    
}