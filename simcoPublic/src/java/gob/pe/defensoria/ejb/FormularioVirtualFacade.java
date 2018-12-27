/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.ejb;

import gob.pe.defensoria.jpa.FormularioVirtual;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author carlos
 */
@Stateless
public class FormularioVirtualFacade {
    
    @PersistenceContext(unitName = "sidPublicPU")
    private EntityManager em;
    
    public FormularioVirtual guardar(FormularioVirtual fv){
        em.persist(fv);
        return fv;
    }
    
    public List<Object[]> listarDepartamentos(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM SID_UBIGEO_DPTO");
        Query query = em.createNativeQuery(sb.toString());
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
    public List<Object[]> listarProvincias(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM SID_UBIGEO_PROV");
        Query query = em.createNativeQuery(sb.toString());
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
    public List<Object[]> listarDistritos(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM SID_UBIGEO_DSTRO");
        Query query = em.createNativeQuery(sb.toString());
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
    public List<Object[]> listarTipoDocumento(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM SID_PARAMETRO WHERE PADRE_PARAMETRO = 110 ORDER BY NUM_PARAMETRO");
        Query query = em.createNativeQuery(sb.toString());
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
}