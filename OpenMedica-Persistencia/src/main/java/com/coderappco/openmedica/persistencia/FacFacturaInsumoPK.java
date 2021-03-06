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
public class FacFacturaInsumoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle")
    private int idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_factura")
    private int idFactura;

    public FacFacturaInsumoPK() {
    }

    public FacFacturaInsumoPK(int idDetalle, int idFactura) {
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalle;
        hash += (int) idFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacFacturaInsumoPK)) {
            return false;
        }
        FacFacturaInsumoPK other = (FacFacturaInsumoPK) object;
        if (this.idDetalle != other.idDetalle) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.FacFacturaInsumoPK[ idDetalle=" + idDetalle + ", idFactura=" + idFactura + " ]";
    }
    
}
