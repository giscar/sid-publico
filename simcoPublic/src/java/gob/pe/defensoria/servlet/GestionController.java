/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.servlet;

import gob.pe.defensoria.dto.ExpedienteDTO;
import gob.pe.defensoria.dto.GestionDTO;
import gob.pe.defensoria.service.SidService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
public class GestionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private SidService service;
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String datatable = null;
        String numeroExpediente = request.getParameter("numeroExpediente");
        datatable = listaGestiones(numeroExpediente);
        request.setAttribute("datatable", datatable);
        request.getRequestDispatcher("/listaGestiones.jsp").forward(request, response);
        
    }
    
    public String listaGestiones(String numeroExpediente) {
        List<GestionDTO> listaGestiones = service.listaGestiones(numeroExpediente);
        return generarDatatable(listaGestiones);
    }

    private String generarDatatable(List<GestionDTO> lista){
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        //if(lista.size() > 0){
            sb.append("<th>Nro</th>");
            sb.append("<th>Fecha de la gestión</th>");
            sb.append("<th>Descripción</th>");
            sb.append("<th>Entidad quejada</th>");
            sb.append("<th>Tipo de gestión</th>");
            sb.append("<th>tuvo respuesta?</th>");
            sb.append("<th>Archivo</th>");
        //}
        sb.append("</tr>");
        
        if(lista.isEmpty()){
            sb.append("<tr>");
            sb.append("<td colspan='7'><b>No existen registros que mostrar</b></td>");
            sb.append("</tr>");
        }
        
        int i = 0;
        for(GestionDTO dto : lista){
            i++;
            sb.append("<tr>");
                sb.append("<td>").append(i).append("</td>");
                sb.append("<td>").append(dto.getFecha()).append("</td>");
                sb.append("<td>").append(dto.getDescripcion()).append("</td>");
                sb.append("<td>").append(dto.getEntidad()).append("</td>");
                sb.append("<td>").append(dto.getTipoGestion()).append("</td>");
                sb.append("<td>").append(dto.getRespuesta()).append("</td>");
                if(!dto.getRuta().trim().isEmpty()){
                    sb.append("<td><a target='_blank' href='/sidPublic/DownloadFileServlet?fileName=").append(dto.getRuta()).append("'>Descargar</a></td>");    
                }else{
                    sb.append("<td>---</td>");
                }
                
            sb.append("</tr>");
        }
        return sb.toString();
    }
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
