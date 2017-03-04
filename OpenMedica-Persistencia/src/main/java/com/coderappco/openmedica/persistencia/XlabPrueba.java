/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "xlab_prueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XlabPrueba.findAll", query = "SELECT x FROM XlabPrueba x"),
    @NamedQuery(name = "XlabPrueba.findById", query = "SELECT x FROM XlabPrueba x WHERE x.id = :id"),
    @NamedQuery(name = "XlabPrueba.findByCodigo", query = "SELECT x FROM XlabPrueba x WHERE x.codigo = :codigo"),
    @NamedQuery(name = "XlabPrueba.findByNombre", query = "SELECT x FROM XlabPrueba x WHERE x.nombre = :nombre"),
    @NamedQuery(name = "XlabPrueba.findByFormatoResultado", query = "SELECT x FROM XlabPrueba x WHERE x.formatoResultado = :formatoResultado"),
    @NamedQuery(name = "XlabPrueba.findByDecimalesPrueba", query = "SELECT x FROM XlabPrueba x WHERE x.decimalesPrueba = :decimalesPrueba"),
    @NamedQuery(name = "XlabPrueba.findByCodigoAlterno", query = "SELECT x FROM XlabPrueba x WHERE x.codigoAlterno = :codigoAlterno"),
    @NamedQuery(name = "XlabPrueba.findByFormula", query = "SELECT x FROM XlabPrueba x WHERE x.formula = :formula"),
    @NamedQuery(name = "XlabPrueba.findByCompFormato", query = "SELECT x FROM XlabPrueba x WHERE x.compFormato = :compFormato"),
    @NamedQuery(name = "XlabPrueba.findByRangosExternos", query = "SELECT x FROM XlabPrueba x WHERE x.rangosExternos = :rangosExternos")})
public class XlabPrueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 1)
    @Column(name = "formato_resultado")
    private String formatoResultado;
    @Column(name = "decimales_prueba")
    private Integer decimalesPrueba;
    @Size(max = 10)
    @Column(name = "codigo_alterno")
    private String codigoAlterno;
    @Size(max = 100)
    @Column(name = "formula")
    private String formula;
    @Size(max = 2147483647)
    @Column(name = "comp_formato")
    private String compFormato;
    @Size(max = 2147483647)
    @Column(name = "rangos_externos")
    private String rangosExternos;
    @ManyToMany(mappedBy = "xlabPruebaList")
    private List<XlabEstudio> xlabEstudioList;
    @OneToMany(mappedBy = "pruebaId")
    private List<XlabPruebaReferencia> xlabPruebaReferenciaList;
    @JoinColumn(name = "grupo_area", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones grupoArea;
    @JoinColumn(name = "unidad_prueba", referencedColumnName = "id")
    @ManyToOne
    private CfgUnidad unidadPrueba;
    @JoinColumn(name = "tipo_tecnica", referencedColumnName = "id")
    @ManyToOne
    private XlabTipoTecnica tipoTecnica;
    @OneToMany(mappedBy = "pruebaId")
    private List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList;

    public XlabPrueba() {
    }

    public XlabPrueba(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormatoResultado() {
        return formatoResultado;
    }

    public void setFormatoResultado(String formatoResultado) {
        this.formatoResultado = formatoResultado;
    }

    public Integer getDecimalesPrueba() {
        return decimalesPrueba;
    }

    public void setDecimalesPrueba(Integer decimalesPrueba) {
        this.decimalesPrueba = decimalesPrueba;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getCompFormato() {
        return compFormato;
    }

    public void setCompFormato(String compFormato) {
        this.compFormato = compFormato;
    }

    public String getRangosExternos() {
        return rangosExternos;
    }

    public void setRangosExternos(String rangosExternos) {
        this.rangosExternos = rangosExternos;
    }

    @XmlTransient
    public List<XlabEstudio> getXlabEstudioList() {
        return xlabEstudioList;
    }

    public void setXlabEstudioList(List<XlabEstudio> xlabEstudioList) {
        this.xlabEstudioList = xlabEstudioList;
    }

    @XmlTransient
    public List<XlabPruebaReferencia> getXlabPruebaReferenciaList() {
        return xlabPruebaReferenciaList;
    }

    public void setXlabPruebaReferenciaList(List<XlabPruebaReferencia> xlabPruebaReferenciaList) {
        this.xlabPruebaReferenciaList = xlabPruebaReferenciaList;
    }

    public CfgClasificaciones getGrupoArea() {
        return grupoArea;
    }

    public void setGrupoArea(CfgClasificaciones grupoArea) {
        this.grupoArea = grupoArea;
    }

    public CfgUnidad getUnidadPrueba() {
        return unidadPrueba;
    }

    public void setUnidadPrueba(CfgUnidad unidadPrueba) {
        this.unidadPrueba = unidadPrueba;
    }

    public XlabTipoTecnica getTipoTecnica() {
        return tipoTecnica;
    }

    public void setTipoTecnica(XlabTipoTecnica tipoTecnica) {
        this.tipoTecnica = tipoTecnica;
    }

    @XmlTransient
    public List<XlabOrdenEstudiosPruebas> getXlabOrdenEstudiosPruebasList() {
        return xlabOrdenEstudiosPruebasList;
    }

    public void setXlabOrdenEstudiosPruebasList(List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList) {
        this.xlabOrdenEstudiosPruebasList = xlabOrdenEstudiosPruebasList;
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
        if (!(object instanceof XlabPrueba)) {
            return false;
        }
        XlabPrueba other = (XlabPrueba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.XlabPrueba[ id=" + id + " ]";
    }
    
}
