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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlos
 */
@Embeddable
public class CfgDiasNoLaboralesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sede")
    private int idSede;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_no_laboral")
    @Temporal(TemporalType.DATE)
    private Date fechaNoLaboral;

    public CfgDiasNoLaboralesPK() {
    }

    public CfgDiasNoLaboralesPK(int idSede, Date fechaNoLaboral) {
        this.idSede = idSede;
        this.fechaNoLaboral = fechaNoLaboral;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public Date getFechaNoLaboral() {
        return fechaNoLaboral;
    }

    public void setFechaNoLaboral(Date fechaNoLaboral) {
        this.fechaNoLaboral = fechaNoLaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSede;
        hash += (fechaNoLaboral != null ? fechaNoLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgDiasNoLaboralesPK)) {
            return false;
        }
        CfgDiasNoLaboralesPK other = (CfgDiasNoLaboralesPK) object;
        if (this.idSede != other.idSede) {
            return false;
        }
        if ((this.fechaNoLaboral == null && other.fechaNoLaboral != null) || (this.fechaNoLaboral != null && !this.fechaNoLaboral.equals(other.fechaNoLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgDiasNoLaboralesPK[ idSede=" + idSede + ", fechaNoLaboral=" + fechaNoLaboral + " ]";
    }
    
}
