/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "SID_PARAMETRO")
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PARAMETRO")
    private BigDecimal numParametro;
    @Column(name = "PADRE_PARAMETRO")
    private BigInteger padreParametro;
    @Size(max = 200)
    @Column(name = "NOMBRE_PARAMETRO")
    private String nombreParametro;
    @Size(max = 5)
    @Column(name = "VALOR_PARAMETRO")
    private String valorParametro;
    @Column(name = "COD_ESTADO")
    private Character codEstado;
    @Column(name = "IND_PADRE")
    private Character indPadre;

    public Parametro() {
    }

    public Parametro(BigDecimal numParametro) {
        this.numParametro = numParametro;
    }

    public BigDecimal getNumParametro() {
        return numParametro;
    }

    public void setNumParametro(BigDecimal numParametro) {
        this.numParametro = numParametro;
    }

    public BigInteger getPadreParametro() {
        return padreParametro;
    }

    public void setPadreParametro(BigInteger padreParametro) {
        this.padreParametro = padreParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public Character getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Character codEstado) {
        this.codEstado = codEstado;
    }

    public Character getIndPadre() {
        return indPadre;
    }

    public void setIndPadre(Character indPadre) {
        this.indPadre = indPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numParametro != null ? numParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.numParametro == null && other.numParametro != null) || (this.numParametro != null && !this.numParametro.equals(other.numParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.pe.defensoria.jpa.Parametro[ numParametro=" + numParametro + " ]";
    }
    
}
