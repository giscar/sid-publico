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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "SID_REG_FORMULARIO_VIRTUAL")
public class FormularioVirtual implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="SEQ_SID_REG_FORMULARIO_VIRTUAL", sequenceName="SEQ_SID_REG_FORMULARIO_VIRTUAL", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SID_REG_FORMULARIO_VIRTUAL")
    @Column(name = "N_ID_REGISTRO")
    private Long nIdRegistro;
    @Size(max = 300)
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Size(max = 100)
    @Column(name = "C_APELLIDOPATERNO")
    private String cApellidopaterno;
    @Size(max = 100)
    @Column(name = "C_APELLIDOMATERNO")
    private String cApellidomaterno;
    @Size(max = 2)
    @Column(name = "C_TIPODOCUMENTO")
    private String cTipodocumento;
    @Size(max = 30)
    @Column(name = "C_NUMERODOCUMENTO")
    private String cNumerodocumento;
    @Size(max = 50)
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @Size(max = 1)
    @Column(name = "C_SEXO")
    private String cSexo;
    @Size(max = 200)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @Column(name = "D_FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechanacimiento;
    @Size(max = 400)
    @Column(name = "C_DIRECCION")
    private String cDireccion;
    @Size(max = 3)
    @Column(name = "C_DEPARTAMENTO")
    private String cDepartamento;
    @Size(max = 3)
    @Column(name = "C_PROVINCIA")
    private String cProvincia;
    @Size(max = 3)
    @Column(name = "C_DISTRITO")
    private String cDistrito;
    @Size(max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Size(max = 300)
    @Column(name = "C_RUTA")
    private String cRuta;
    @Column(name = "D_FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaRegistro;
    @Column(name = "D_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFecha;
    @Column(name = "C_FORMA")
    private String cForma;
    @Column(name = "C_ESTADO")
    private String cEstado;

    public FormularioVirtual() {
    }

    public FormularioVirtual(Long nIdRegistro) {
        this.nIdRegistro = nIdRegistro;
    }

    public Long getNIdRegistro() {
        return nIdRegistro;
    }

    public void setNIdRegistro(Long nIdRegistro) {
        this.nIdRegistro = nIdRegistro;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCApellidopaterno() {
        return cApellidopaterno;
    }

    public void setCApellidopaterno(String cApellidopaterno) {
        this.cApellidopaterno = cApellidopaterno;
    }

    public String getCApellidomaterno() {
        return cApellidomaterno;
    }

    public void setCApellidomaterno(String cApellidomaterno) {
        this.cApellidomaterno = cApellidomaterno;
    }

    public String getCTipodocumento() {
        return cTipodocumento;
    }

    public void setCTipodocumento(String cTipodocumento) {
        this.cTipodocumento = cTipodocumento;
    }

    public String getCNumerodocumento() {
        return cNumerodocumento;
    }

    public void setCNumerodocumento(String cNumerodocumento) {
        this.cNumerodocumento = cNumerodocumento;
    }

    public String getCTelefono() {
        return cTelefono;
    }

    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public String getCSexo() {
        return cSexo;
    }

    public void setCSexo(String cSexo) {
        this.cSexo = cSexo;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public Date getDFechanacimiento() {
        return dFechanacimiento;
    }

    public void setDFechanacimiento(Date dFechanacimiento) {
        this.dFechanacimiento = dFechanacimiento;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public String getCDepartamento() {
        return cDepartamento;
    }

    public void setCDepartamento(String cDepartamento) {
        this.cDepartamento = cDepartamento;
    }

    public String getCProvincia() {
        return cProvincia;
    }

    public void setCProvincia(String cProvincia) {
        this.cProvincia = cProvincia;
    }

    public String getCDistrito() {
        return cDistrito;
    }

    public void setCDistrito(String cDistrito) {
        this.cDistrito = cDistrito;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCRuta() {
        return cRuta;
    }

    public void setCRuta(String cRuta) {
        this.cRuta = cRuta;
    }

    public Date getdFechaRegistro() {
        return dFechaRegistro;
    }

    public void setdFechaRegistro(Date dFechaRegistro) {
        this.dFechaRegistro = dFechaRegistro;
    }
    
    public Date getdFecha() {
        return dFecha;
    }

    public void setdFecha(Date dFecha) {
        this.dFecha = dFecha;
    }

    public String getcForma() {
        return cForma;
    }

    public void setcForma(String cForma) {
        this.cForma = cForma;
    }
    
    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nIdRegistro != null ? nIdRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormularioVirtual)) {
            return false;
        }
        FormularioVirtual other = (FormularioVirtual) object;
        if ((this.nIdRegistro == null && other.nIdRegistro != null) || (this.nIdRegistro != null && !this.nIdRegistro.equals(other.nIdRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.pe.defensoria.jpa.FormularioVirtual[ nIdRegistro=" + nIdRegistro + " ]";
    }
    
}
