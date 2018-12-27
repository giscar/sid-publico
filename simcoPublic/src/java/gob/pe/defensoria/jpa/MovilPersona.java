/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JMATOS
 */
@Entity
@Table( name = "SID_MOV_PERSONA" )
public class MovilPersona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_ID_PERSONA")
    private Long idPersona;
    
    @Column(name = "C_NUMDOCUMENTO")
    private String numeroDocumento;
    
    @Column(name = "C_CONTRA")
    private String contrasenia;
    
    @Column(name = "C_NOMBRE")
    private String nombre;
    
    @Column(name = "C_APELLIDOPAT")
    private String apellidoPaterno;
    
    @Column(name = "C_APELLIDOMAT")
    private String apellidoMaterno;
    
    @Column(name = "C_TIPODOCUMENTO")
    private String tipoDocumento;
    
    @Column(name = "D_FECHAREGISTRO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;
    
    @Column(name = "C_SEXO")
    private String sexo;
    
    @Column(name = "C_TELEFONO")
    private String telefono;
    
    @Column(name = "C_EMAIL")
    private String email;
    
    @Column(name = "C_DIRECCION")
    private String direccion;
    
    @Column(name = "C_IDDEPARTAMENTO")
    private String idDepartamento;
    
    @Column(name = "C_IDPROVINCIA")
    private String idProvincia;
    
    @Column(name = "C_IDDISTRITO")
    private String idDistrito;
    
    @Column(name = "D_FECHANACIMIENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "C_TIPOLENGUA")
    private String tipoLengua;
    
    @Column(name = "C_INDDISCAPACITADO")
    private String idDiscapacitado;
    
    @Column(name = "C_NACIONALIDAD")
    private String nacionalidad;
    
    @Column(name = "C_ROL")
    private String rol;
    
    @Column(name = "N_ESTADO")
    private Integer estado;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoLengua() {
        return tipoLengua;
    }

    public void setTipoLengua(String tipoLengua) {
        this.tipoLengua = tipoLengua;
    }

    public String getIdDiscapacitado() {
        return idDiscapacitado;
    }

    public void setIdDiscapacitado(String idDiscapacitado) {
        this.idDiscapacitado = idDiscapacitado;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
}
