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
public class FacManualTarifarioInsumoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_manual_tarifario")
    private int idManualTarifario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_insumo")
    private int idInsumo;

    public FacManualTarifarioInsumoPK() {
    }

    public FacManualTarifarioInsumoPK(int idManualTarifario, int idInsumo) {
        this.idManualTarifario = idManualTarifario;
        this.idInsumo = idInsumo;
    }

    public int getIdManualTarifario() {
        return idManualTarifario;
    }

    public void setIdManualTarifario(int idManualTarifario) {
        this.idManualTarifario = idManualTarifario;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idManualTarifario;
        hash += (int) idInsumo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacManualTarifarioInsumoPK)) {
            return false;
        }
        FacManualTarifarioInsumoPK other = (FacManualTarifarioInsumoPK) object;
        if (this.idManualTarifario != other.idManualTarifario) {
            return false;
        }
        if (this.idInsumo != other.idInsumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.FacManualTarifarioInsumoPK[ idManualTarifario=" + idManualTarifario + ", idInsumo=" + idInsumo + " ]";
    }
    
}
