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
public class FacManualTarifarioMedicamentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_manual_tarifario")
    private int idManualTarifario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medicamento")
    private int idMedicamento;

    public FacManualTarifarioMedicamentoPK() {
    }

    public FacManualTarifarioMedicamentoPK(int idManualTarifario, int idMedicamento) {
        this.idManualTarifario = idManualTarifario;
        this.idMedicamento = idMedicamento;
    }

    public int getIdManualTarifario() {
        return idManualTarifario;
    }

    public void setIdManualTarifario(int idManualTarifario) {
        this.idManualTarifario = idManualTarifario;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idManualTarifario;
        hash += (int) idMedicamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacManualTarifarioMedicamentoPK)) {
            return false;
        }
        FacManualTarifarioMedicamentoPK other = (FacManualTarifarioMedicamentoPK) object;
        if (this.idManualTarifario != other.idManualTarifario) {
            return false;
        }
        if (this.idMedicamento != other.idMedicamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.FacManualTarifarioMedicamentoPK[ idManualTarifario=" + idManualTarifario + ", idMedicamento=" + idMedicamento + " ]";
    }
    
}
