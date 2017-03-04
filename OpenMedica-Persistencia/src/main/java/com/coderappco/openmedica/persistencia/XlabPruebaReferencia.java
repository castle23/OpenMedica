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
@Table(name = "xlab_prueba_referencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XlabPruebaReferencia.findAll", query = "SELECT x FROM XlabPruebaReferencia x"),
    @NamedQuery(name = "XlabPruebaReferencia.findById", query = "SELECT x FROM XlabPruebaReferencia x WHERE x.id = :id"),
    @NamedQuery(name = "XlabPruebaReferencia.findByTipo", query = "SELECT x FROM XlabPruebaReferencia x WHERE x.tipo = :tipo"),
    @NamedQuery(name = "XlabPruebaReferencia.findByMinimoReferencia", query = "SELECT x FROM XlabPruebaReferencia x WHERE x.minimoReferencia = :minimoReferencia"),
    @NamedQuery(name = "XlabPruebaReferencia.findByMaximoReferencia", query = "SELECT x FROM XlabPruebaReferencia x WHERE x.maximoReferencia = :maximoReferencia")})
public class XlabPruebaReferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minimo_referencia")
    private Double minimoReferencia;
    @Column(name = "maximo_referencia")
    private Double maximoReferencia;
    @JoinColumn(name = "prueba_id", referencedColumnName = "id")
    @ManyToOne
    private XlabPrueba pruebaId;

    public XlabPruebaReferencia() {
    }

    public XlabPruebaReferencia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMinimoReferencia() {
        return minimoReferencia;
    }

    public void setMinimoReferencia(Double minimoReferencia) {
        this.minimoReferencia = minimoReferencia;
    }

    public Double getMaximoReferencia() {
        return maximoReferencia;
    }

    public void setMaximoReferencia(Double maximoReferencia) {
        this.maximoReferencia = maximoReferencia;
    }

    public XlabPrueba getPruebaId() {
        return pruebaId;
    }

    public void setPruebaId(XlabPrueba pruebaId) {
        this.pruebaId = pruebaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XlabPruebaReferencia)) {
            return false;
        }
        XlabPruebaReferencia other = (XlabPruebaReferencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.XlabPruebaReferencia[ id=" + id + " ]";
    }
    
}
