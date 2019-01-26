/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.service;

import gob.pe.defensoria.comun.MEncript;
import gob.pe.defensoria.dto.ExpedienteDTO;
import gob.pe.defensoria.dto.GestionDTO;
import gob.pe.defensoria.dto.MovilPersonaDTO;
import gob.pe.defensoria.ejb.SidFacade;
import gob.pe.defensoria.jpa.MovilPersona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author carlos
 */
@Stateless
public class SidServiceImpl implements SidService{
    
    @EJB
    private SidFacade facade;

    @Override
    public List<ExpedienteDTO> listaExpedientes(String documento) {
        List<Object[]> lista = facade.buscarExpedienteByDocumento(documento);
        List<ExpedienteDTO> lista1 = new ArrayList<>();
            for(Object[] os : lista){
                ExpedienteDTO dto = new ExpedienteDTO();
                dto.setId(Long.parseLong(os[0].toString()));
                dto.setNumero(os[1] == null? " " : os[1].toString());
                dto.setFecha(os[2] == null? " " : os[2].toString());
                dto.setTipoExpediente(os[3] == null? " " : os[3].toString());
                dto.setSede(os[7] == null? " " : os[7].toString());
                dto.setEstado(os[6] == null? " " : os[6].toString());
                dto.setComisionado(os[8] == null? " " : os[8].toString());
                dto.setArchivo(os[9] == null? " " : os[9].toString());
                lista1.add(dto);
            }
    return lista1;
    }

    @Override
    public List<GestionDTO> listaGestiones(String numeroExpediente) {
        List<Object[]> lista = facade.buscarGestionByExpediente(numeroExpediente);
        List<GestionDTO> lista1 = new ArrayList<>();
            for(Object[] os : lista){
                GestionDTO dto = new GestionDTO();
                dto.setFecha(os[0] == null? " " : os[0].toString());
                dto.setDescripcion(os[1] == null? " " : os[1].toString());
                dto.setRespuesta(os[2] == null? "NO" : os[2].toString());
                dto.setRuta(os[3] == null? " " : os[3].toString());
                dto.setTipoGestion(os[4] == null? "" : os[4].toString());
                dto.setEntidad(os[5] == null? " " : os[5].toString());
                dto.setRutaRespuesta(os[6] == null? " " : os[6].toString());
                lista1.add(dto);
            }
    return lista1;
    }

    @Override
    public MovilPersonaDTO login(String codDocumento, String password) throws  Exception {
        MovilPersonaDTO result = null;
        String encript = password;
        MovilPersona movilPersona = facade.buscarMovilPersonaLogin(codDocumento, encript);
        if(movilPersona != null){
            result = new MovilPersonaDTO();
            result.setIdPersona(movilPersona.getIdPersona());
            result.setNombre(movilPersona.getNombre());
            result.setApellidoPaterno(movilPersona.getApellidoPaterno());
            result.setApellidoMaterno(movilPersona.getApellidoMaterno());
            result.setNumeroDocumento(movilPersona.getNumeroDocumento());
            result.setEmail(movilPersona.getEmail());
        }
        return result;
    }
    
    
    
}
