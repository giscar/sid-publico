/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.service;

import gob.pe.defensoria.dto.ExpedienteDTO;
import gob.pe.defensoria.dto.GestionDTO;
import gob.pe.defensoria.dto.MovilPersonaDTO;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface SidService {
    
    public List<ExpedienteDTO> listaExpedientes(String documento);
    
    public List<GestionDTO> listaGestiones(String numeroExpediente);
    
    public MovilPersonaDTO login(String codDocumento, String password) throws  Exception;
    
    
}
