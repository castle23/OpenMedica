/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlos
 */
@Embeddable
public class CitAutorizacionesServiciosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_autorizacion")
    private int idAutorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio")
    private int idServicio;

    public CitAutorizacionesServiciosPK() {
    }

    public CitAutorizacionesServiciosPK(int idAutorizacion, int idServicio) {
        this.idAutorizacion = idAutorizacion;
        this.idServicio = idServicio;
    }

    public int getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(int idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAutorizacion;
        hash += (int) idServicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitAutorizacionesServiciosPK)) {
            return false;
        }
        CitAutorizacionesServiciosPK other = (CitAutorizacionesServiciosPK) object;
        if (this.idAutorizacion != other.idAutorizacion) {
            return false;
        }
        if (this.idServicio != other.idServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CitAutorizacionesServiciosPK[ idAutorizacion=" + idAutorizacion + ", idServicio=" + idServicio + " ]";
    }
    
}
