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
public class HcDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_registro")
    private int idRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_campo")
    private int idCampo;

    public HcDetallePK() {
    }

    public HcDetallePK(int idRegistro, int idCampo) {
        this.idRegistro = idRegistro;
        this.idCampo = idCampo;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRegistro;
        hash += (int) idCampo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcDetallePK)) {
            return false;
        }
        HcDetallePK other = (HcDetallePK) object;
        if (this.idRegistro != other.idRegistro) {
            return false;
        }
        if (this.idCampo != other.idCampo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.HcDetallePK[ idRegistro=" + idRegistro + ", idCampo=" + idCampo + " ]";
    }
    
}
