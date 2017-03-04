/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "odo_registro_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdoRegistroDetalle.findAll", query = "SELECT o FROM OdoRegistroDetalle o"),
    @NamedQuery(name = "OdoRegistroDetalle.findByIdRegistroDetalle", query = "SELECT o FROM OdoRegistroDetalle o WHERE o.idRegistroDetalle = :idRegistroDetalle"),
    @NamedQuery(name = "OdoRegistroDetalle.findByValor", query = "SELECT o FROM OdoRegistroDetalle o WHERE o.valor = :valor")})
public class OdoRegistroDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro_detalle")
    private Integer idRegistroDetalle;
    @Size(max = 2147483647)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "id_campo", referencedColumnName = "id_campo")
    @ManyToOne
    private HcCamposReg idCampo;
    @JoinColumn(name = "id_registro", referencedColumnName = "id")
    @ManyToOne
    private OdoRegistro idRegistro;

    public OdoRegistroDetalle() {
    }

    public OdoRegistroDetalle(Integer idRegistroDetalle) {
        this.idRegistroDetalle = idRegistroDetalle;
    }

    public Integer getIdRegistroDetalle() {
        return idRegistroDetalle;
    }

    public void setIdRegistroDetalle(Integer idRegistroDetalle) {
        this.idRegistroDetalle = idRegistroDetalle;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public HcCamposReg getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(HcCamposReg idCampo) {
        this.idCampo = idCampo;
    }

    public OdoRegistro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(OdoRegistro idRegistro) {
        this.idRegistro = idRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroDetalle != null ? idRegistroDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdoRegistroDetalle)) {
            return false;
        }
        OdoRegistroDetalle other = (OdoRegistroDetalle) object;
        if ((this.idRegistroDetalle == null && other.idRegistroDetalle != null) || (this.idRegistroDetalle != null && !this.idRegistroDetalle.equals(other.idRegistroDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.OdoRegistroDetalle[ idRegistroDetalle=" + idRegistroDetalle + " ]";
    }
    
}
