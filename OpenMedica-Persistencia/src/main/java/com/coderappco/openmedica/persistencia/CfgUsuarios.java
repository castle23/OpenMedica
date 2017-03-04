/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.openmedica.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "cfg_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgUsuarios.findAll", query = "SELECT c FROM CfgUsuarios c"),
    @NamedQuery(name = "CfgUsuarios.findByIdUsuario", query = "SELECT c FROM CfgUsuarios c WHERE c.idUsuario = :idUsuario"),
    @NamedQuery(name = "CfgUsuarios.findByIdentificacion", query = "SELECT c FROM CfgUsuarios c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "CfgUsuarios.findByClave", query = "SELECT c FROM CfgUsuarios c WHERE c.clave = :clave"),
    @NamedQuery(name = "CfgUsuarios.findByLoginUsuario", query = "SELECT c FROM CfgUsuarios c WHERE c.loginUsuario = :loginUsuario"),
    @NamedQuery(name = "CfgUsuarios.findByEstadoCuenta", query = "SELECT c FROM CfgUsuarios c WHERE c.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "CfgUsuarios.findByObservacion", query = "SELECT c FROM CfgUsuarios c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "CfgUsuarios.findByPrimerNombre", query = "SELECT c FROM CfgUsuarios c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "CfgUsuarios.findBySegundoNombre", query = "SELECT c FROM CfgUsuarios c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "CfgUsuarios.findByPrimerApellido", query = "SELECT c FROM CfgUsuarios c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "CfgUsuarios.findBySegundoApellido", query = "SELECT c FROM CfgUsuarios c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "CfgUsuarios.findByDireccion", query = "SELECT c FROM CfgUsuarios c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "CfgUsuarios.findByTelefonoResidencia", query = "SELECT c FROM CfgUsuarios c WHERE c.telefonoResidencia = :telefonoResidencia"),
    @NamedQuery(name = "CfgUsuarios.findByTelefonoOficina", query = "SELECT c FROM CfgUsuarios c WHERE c.telefonoOficina = :telefonoOficina"),
    @NamedQuery(name = "CfgUsuarios.findByCelular", query = "SELECT c FROM CfgUsuarios c WHERE c.celular = :celular"),
    @NamedQuery(name = "CfgUsuarios.findByEmail", query = "SELECT c FROM CfgUsuarios c WHERE c.email = :email"),
    @NamedQuery(name = "CfgUsuarios.findByCargoActual", query = "SELECT c FROM CfgUsuarios c WHERE c.cargoActual = :cargoActual"),
    @NamedQuery(name = "CfgUsuarios.findByRegistroProfesional", query = "SELECT c FROM CfgUsuarios c WHERE c.registroProfesional = :registroProfesional"),
    @NamedQuery(name = "CfgUsuarios.findByUnidadFuncional", query = "SELECT c FROM CfgUsuarios c WHERE c.unidadFuncional = :unidadFuncional"),
    @NamedQuery(name = "CfgUsuarios.findByPorcentajeHonorario", query = "SELECT c FROM CfgUsuarios c WHERE c.porcentajeHonorario = :porcentajeHonorario"),
    @NamedQuery(name = "CfgUsuarios.findByFechaCreacion", query = "SELECT c FROM CfgUsuarios c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "CfgUsuarios.findByVisible", query = "SELECT c FROM CfgUsuarios c WHERE c.visible = :visible"),
    @NamedQuery(name = "CfgUsuarios.findByMostrarEnHistorias", query = "SELECT c FROM CfgUsuarios c WHERE c.mostrarEnHistorias = :mostrarEnHistorias")})
public class CfgUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 20)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 50)
    @Column(name = "clave")
    private String clave;
    @Size(max = 50)
    @Column(name = "login_usuario")
    private String loginUsuario;
    @Column(name = "estado_cuenta")
    private Boolean estadoCuenta;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 60)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 60)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 60)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 60)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 80)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "telefono_residencia")
    private String telefonoResidencia;
    @Size(max = 10)
    @Column(name = "telefono_oficina")
    private String telefonoOficina;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "cargo_actual")
    private String cargoActual;
    @Size(max = 30)
    @Column(name = "registro_profesional")
    private String registroProfesional;
    @Size(max = 100)
    @Column(name = "unidad_funcional")
    private String unidadFuncional;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_honorario")
    private Double porcentajeHonorario;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "mostrar_en_historias")
    private Boolean mostrarEnHistorias;
    @OneToMany(mappedBy = "idMedico")
    private List<FacFacturaInsumo> facFacturaInsumoList;
    @OneToMany(mappedBy = "medicoId")
    private List<XlabOrden> xlabOrdenList;
    @OneToMany(mappedBy = "usuarioCrea")
    private List<XlabOrden> xlabOrdenList1;
    @OneToMany(mappedBy = "usuarioElimina")
    private List<XlabOrden> xlabOrdenList2;
    @OneToMany(mappedBy = "idMedico")
    private List<FacFacturaMedicamento> facFacturaMedicamentoList;
    @OneToMany(mappedBy = "idUsuario")
    private List<FacCaja> facCajaList;
    @OneToMany(mappedBy = "idMedico")
    private List<FacFacturaPaquete> facFacturaPaqueteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestador")
    private List<CitCitas> citCitasList;
    @OneToMany(mappedBy = "idPrestador")
    private List<FacConsumoInsumo> facConsumoInsumoList;
    @OneToMany(mappedBy = "idPrestador")
    private List<CitTurnos> citTurnosList;
    @OneToMany(mappedBy = "idUsuarioCreador")
    private List<CitAutorizaciones> citAutorizacionesList;
    @JoinColumn(name = "especialidad", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones especialidad;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones genero;
    @JoinColumn(name = "personal_atiende", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones personalAtiende;
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones tipoUsuario;
    @JoinColumn(name = "departamento", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones departamento;
    @JoinColumn(name = "municipio", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones municipio;
    @JoinColumn(name = "tipo_identificacion", referencedColumnName = "id")
    @ManyToOne
    private CfgClasificaciones tipoIdentificacion;
    @JoinColumn(name = "firma", referencedColumnName = "id")
    @ManyToOne
    private CfgImagenes firma;
    @JoinColumn(name = "foto", referencedColumnName = "id")
    @ManyToOne
    private CfgImagenes foto;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne(optional = false)
    private CfgPerfilesUsuario idPerfil;
    @OneToMany(mappedBy = "idMedico")
    private List<FacFacturaServicio> facFacturaServicioList;
    @OneToMany(mappedBy = "idPrestador")
    private List<FacConsumoPaquete> facConsumoPaqueteList;
    @OneToMany(mappedBy = "idMedico")
    private List<HcRegistro> hcRegistroList;
    @OneToMany(mappedBy = "idPrestador")
    private List<FacConsumoMedicamento> facConsumoMedicamentoList;
    @OneToMany(mappedBy = "idMedico")
    private List<OdoRegistro> odoRegistroList;
    @OneToMany(mappedBy = "usuarioElimina")
    private List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList;
    @OneToMany(mappedBy = "usuarioActualiza")
    private List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList1;
    @OneToMany(mappedBy = "idPrestador")
    private List<FacConsumoServicio> facConsumoServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestador")
    private List<CitPaqDetalle> citPaqDetalleList;

    public CfgUsuarios() {
    }

    public CfgUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public Boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargoActual() {
        return cargoActual;
    }

    public void setCargoActual(String cargoActual) {
        this.cargoActual = cargoActual;
    }

    public String getRegistroProfesional() {
        return registroProfesional;
    }

    public void setRegistroProfesional(String registroProfesional) {
        this.registroProfesional = registroProfesional;
    }

    public String getUnidadFuncional() {
        return unidadFuncional;
    }

    public void setUnidadFuncional(String unidadFuncional) {
        this.unidadFuncional = unidadFuncional;
    }

    public Double getPorcentajeHonorario() {
        return porcentajeHonorario;
    }

    public void setPorcentajeHonorario(Double porcentajeHonorario) {
        this.porcentajeHonorario = porcentajeHonorario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getMostrarEnHistorias() {
        return mostrarEnHistorias;
    }

    public void setMostrarEnHistorias(Boolean mostrarEnHistorias) {
        this.mostrarEnHistorias = mostrarEnHistorias;
    }

    @XmlTransient
    public List<FacFacturaInsumo> getFacFacturaInsumoList() {
        return facFacturaInsumoList;
    }

    public void setFacFacturaInsumoList(List<FacFacturaInsumo> facFacturaInsumoList) {
        this.facFacturaInsumoList = facFacturaInsumoList;
    }

    @XmlTransient
    public List<XlabOrden> getXlabOrdenList() {
        return xlabOrdenList;
    }

    public void setXlabOrdenList(List<XlabOrden> xlabOrdenList) {
        this.xlabOrdenList = xlabOrdenList;
    }

    @XmlTransient
    public List<XlabOrden> getXlabOrdenList1() {
        return xlabOrdenList1;
    }

    public void setXlabOrdenList1(List<XlabOrden> xlabOrdenList1) {
        this.xlabOrdenList1 = xlabOrdenList1;
    }

    @XmlTransient
    public List<XlabOrden> getXlabOrdenList2() {
        return xlabOrdenList2;
    }

    public void setXlabOrdenList2(List<XlabOrden> xlabOrdenList2) {
        this.xlabOrdenList2 = xlabOrdenList2;
    }

    @XmlTransient
    public List<FacFacturaMedicamento> getFacFacturaMedicamentoList() {
        return facFacturaMedicamentoList;
    }

    public void setFacFacturaMedicamentoList(List<FacFacturaMedicamento> facFacturaMedicamentoList) {
        this.facFacturaMedicamentoList = facFacturaMedicamentoList;
    }

    @XmlTransient
    public List<FacCaja> getFacCajaList() {
        return facCajaList;
    }

    public void setFacCajaList(List<FacCaja> facCajaList) {
        this.facCajaList = facCajaList;
    }

    @XmlTransient
    public List<FacFacturaPaquete> getFacFacturaPaqueteList() {
        return facFacturaPaqueteList;
    }

    public void setFacFacturaPaqueteList(List<FacFacturaPaquete> facFacturaPaqueteList) {
        this.facFacturaPaqueteList = facFacturaPaqueteList;
    }

    @XmlTransient
    public List<CitCitas> getCitCitasList() {
        return citCitasList;
    }

    public void setCitCitasList(List<CitCitas> citCitasList) {
        this.citCitasList = citCitasList;
    }

    @XmlTransient
    public List<FacConsumoInsumo> getFacConsumoInsumoList() {
        return facConsumoInsumoList;
    }

    public void setFacConsumoInsumoList(List<FacConsumoInsumo> facConsumoInsumoList) {
        this.facConsumoInsumoList = facConsumoInsumoList;
    }

    @XmlTransient
    public List<CitTurnos> getCitTurnosList() {
        return citTurnosList;
    }

    public void setCitTurnosList(List<CitTurnos> citTurnosList) {
        this.citTurnosList = citTurnosList;
    }

    @XmlTransient
    public List<CitAutorizaciones> getCitAutorizacionesList() {
        return citAutorizacionesList;
    }

    public void setCitAutorizacionesList(List<CitAutorizaciones> citAutorizacionesList) {
        this.citAutorizacionesList = citAutorizacionesList;
    }

    public CfgClasificaciones getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(CfgClasificaciones especialidad) {
        this.especialidad = especialidad;
    }

    public CfgClasificaciones getGenero() {
        return genero;
    }

    public void setGenero(CfgClasificaciones genero) {
        this.genero = genero;
    }

    public CfgClasificaciones getPersonalAtiende() {
        return personalAtiende;
    }

    public void setPersonalAtiende(CfgClasificaciones personalAtiende) {
        this.personalAtiende = personalAtiende;
    }

    public CfgClasificaciones getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(CfgClasificaciones tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public CfgClasificaciones getDepartamento() {
        return departamento;
    }

    public void setDepartamento(CfgClasificaciones departamento) {
        this.departamento = departamento;
    }

    public CfgClasificaciones getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CfgClasificaciones municipio) {
        this.municipio = municipio;
    }

    public CfgClasificaciones getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(CfgClasificaciones tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public CfgImagenes getFirma() {
        return firma;
    }

    public void setFirma(CfgImagenes firma) {
        this.firma = firma;
    }

    public CfgImagenes getFoto() {
        return foto;
    }

    public void setFoto(CfgImagenes foto) {
        this.foto = foto;
    }

    public CfgPerfilesUsuario getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(CfgPerfilesUsuario idPerfil) {
        this.idPerfil = idPerfil;
    }

    @XmlTransient
    public List<FacFacturaServicio> getFacFacturaServicioList() {
        return facFacturaServicioList;
    }

    public void setFacFacturaServicioList(List<FacFacturaServicio> facFacturaServicioList) {
        this.facFacturaServicioList = facFacturaServicioList;
    }

    @XmlTransient
    public List<FacConsumoPaquete> getFacConsumoPaqueteList() {
        return facConsumoPaqueteList;
    }

    public void setFacConsumoPaqueteList(List<FacConsumoPaquete> facConsumoPaqueteList) {
        this.facConsumoPaqueteList = facConsumoPaqueteList;
    }

    @XmlTransient
    public List<HcRegistro> getHcRegistroList() {
        return hcRegistroList;
    }

    public void setHcRegistroList(List<HcRegistro> hcRegistroList) {
        this.hcRegistroList = hcRegistroList;
    }

    @XmlTransient
    public List<FacConsumoMedicamento> getFacConsumoMedicamentoList() {
        return facConsumoMedicamentoList;
    }

    public void setFacConsumoMedicamentoList(List<FacConsumoMedicamento> facConsumoMedicamentoList) {
        this.facConsumoMedicamentoList = facConsumoMedicamentoList;
    }

    @XmlTransient
    public List<OdoRegistro> getOdoRegistroList() {
        return odoRegistroList;
    }

    public void setOdoRegistroList(List<OdoRegistro> odoRegistroList) {
        this.odoRegistroList = odoRegistroList;
    }

    @XmlTransient
    public List<XlabOrdenEstudiosPruebas> getXlabOrdenEstudiosPruebasList() {
        return xlabOrdenEstudiosPruebasList;
    }

    public void setXlabOrdenEstudiosPruebasList(List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList) {
        this.xlabOrdenEstudiosPruebasList = xlabOrdenEstudiosPruebasList;
    }

    @XmlTransient
    public List<XlabOrdenEstudiosPruebas> getXlabOrdenEstudiosPruebasList1() {
        return xlabOrdenEstudiosPruebasList1;
    }

    public void setXlabOrdenEstudiosPruebasList1(List<XlabOrdenEstudiosPruebas> xlabOrdenEstudiosPruebasList1) {
        this.xlabOrdenEstudiosPruebasList1 = xlabOrdenEstudiosPruebasList1;
    }

    @XmlTransient
    public List<FacConsumoServicio> getFacConsumoServicioList() {
        return facConsumoServicioList;
    }

    public void setFacConsumoServicioList(List<FacConsumoServicio> facConsumoServicioList) {
        this.facConsumoServicioList = facConsumoServicioList;
    }

    @XmlTransient
    public List<CitPaqDetalle> getCitPaqDetalleList() {
        return citPaqDetalleList;
    }

    public void setCitPaqDetalleList(List<CitPaqDetalle> citPaqDetalleList) {
        this.citPaqDetalleList = citPaqDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgUsuarios)) {
            return false;
        }
        CfgUsuarios other = (CfgUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coderappco.persistence.CfgUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
