/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.service;

import gob.pe.defensoria.dto.ExpedienteDTO;
import gob.pe.defensoria.dto.GestionDTO;
import gob.pe.defensoria.ejb.SidFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
                
                lista1.add(dto);
            }
    return lista1;
    }
    
    
    
}
