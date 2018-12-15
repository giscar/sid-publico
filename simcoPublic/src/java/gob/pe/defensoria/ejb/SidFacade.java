/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.ejb;


import gob.pe.defensoria.jpa.FormularioVirtualBk;
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
public class SidFacade {
    
    @PersistenceContext(unitName = "sidPublicPU")
    private EntityManager em;
    
    public void guardar(FormularioVirtualBk fv){
        em.persist(fv);
    }
    
    public List<Object[]> buscarExpedienteByDocumento(String documento) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT a.n_idexpediente, a.c_numeroexpediente, to_char(a.d_fecharegistro, 'dd/mm/yyyy'), B.NOMBRE_PARAMETRO AS TIPOCLASIFICACION, C.C_INDICADORETAPA, " +
"        C.N_ID_ETAPA, D.C_NOMBRE, J.C_NOMBRE NOMBRE_OD, L.NOM_USUARIO||' '||L.APE_PATERNO COMISIONADO " +
"        FROM SID_REG_EXPEDIENTE A " +
"        INNER JOIN SID_PARAMETRO B ON A.C_TIPOCLASIFICACION = B.VALOR_PARAMETRO AND B.PADRE_PARAMETRO = 10 " +
"        INNER JOIN SID_SEG_USUARIO L ON L.CODIGO_USUARIO = A.C_USUREGISTRO " +
"        INNER JOIN SID_SEG_OFICINA_DEFENSORIAL J ON J.N_ID_OD = A.N_CODIGOOD " +
"        LEFT JOIN SID_REG_ETAPA_ESTADO C ON A.N_IDEXPEDIENTE = C.N_ID_EXPEDIENTE " +
"        LEFT JOIN SID_REG_ESTADO D ON C.N_ID_ESTADO = D.N_ID_ESTADO " +
"        LEFT JOIN SID_REG_EXPEDE_ENTIDAD E ON A.N_IDEXPEDIENTE = E.N_IDEXPEDIENTE" +
"        LEFT JOIN SID_REG_ENTIDAD F ON E.N_ID_ENTIDAD = F.N_ID_ENTIDAD " +
"        LEFT JOIN SID_REG_EXPEDE_PERSONA G ON G.N_IDEXPEDIENTE = A.N_IDEXPEDIENTE " +
"        LEFT JOIN SID_REG_PERSONA H ON G.N_IDPERSONA = H.N_IDPERSONA " +
"        WHERE A.C_ESTADO = 'A' and h.c_numerodocumento = ? AND A.C_ESTADO = 'A'" +
"        ORDER BY A.N_IDEXPEDIENTE DESC");
        
        Query query = em.createNativeQuery(sb.toString());
        query.setParameter(1, documento);
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
    
    public List<Object[]> buscarGestionByExpediente(String codigoExpediente) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT to_char(a.d_fecha), a.c_descripcion, a.c_respuesta ,a.c_ruta1, C.NOMBRE_PARAMETRO AS GESTION_TIPO, D.C_NOMENTIDAD FROM SID_REG_GESTION A " +
"        INNER JOIN SID_REG_GESTION_ETAPA B ON A.N_ID_GESTION = B.N_ID_GESTION " +
"        LEFT JOIN SID_PARAMETRO C ON TRIM(A.C_TIPO) = TRIM(C.VALOR_PARAMETRO) " +
"        AND C.PADRE_PARAMETRO = 70 " +
"        LEFT JOIN SID_REG_ENTIDAD D ON A.N_IDENTIDAD = D.N_ID_ENTIDAD " +
"        WHERE B.C_NUMEROEXPEDIENTE = ? " +
"        ORDER BY A.N_ID_GESTION");
        
        Query query = em.createNativeQuery(sb.toString());
        query.setParameter(1, codigoExpediente);
        List<Object[]> lst = query.getResultList();
        return lst;
    }
    
}
