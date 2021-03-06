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
public class RipsAfPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rip_almacenado")
    private int idRipAlmacenado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_registro")
    private int numRegistro;

    public RipsAfPK() {
    }

    public RipsAfPK(int idRipAlmacenado, int numRegistro) {
        this.idRipAlmacenado = idRipAlmacenado;
        this.numRegistro = numRegistro;
    }

    public int getIdRipAlmacenado() {
        return idRipAlmacenado;
    }

    public void setIdRipAlmacenado(int idRipAlmacenado) {
        this.idRipAlmacenado = idRipAlmacenado;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRipAlmacenado;
        hash += (int) numRegistro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RipsAfPK)) {
            return false;
        }
        RipsAfPK other = (RipsAfPK) object;
        if (this.idRipAlmacenado != other.idRipAlmacenado) {
            return false;
        }
        if (this.numRegistro != other.numRegistro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.RipsAfPK[ idRipAlmacenado=" + idRipAlmacenado + ", numRegistro=" + numRegistro + " ]";
    }
    
}
