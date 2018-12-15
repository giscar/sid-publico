/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.servlet;

import gob.pe.defensoria.dto.ExpedienteDTO;
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
public class ExpedienteController extends HttpServlet {

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
        String documento = request.getParameter("codDocumento");
        datatable = listaExpediente(documento);
        request.setAttribute("datatable", datatable);
        request.getRequestDispatcher("/listaExpedientes.jsp").forward(request, response);
        
    }
    
    public String listaExpediente(String documento) {
        List<ExpedienteDTO> listaExpediente = service.listaExpedientes(documento);
        return generarDatatable(listaExpediente);
    }

    private String generarDatatable(List<ExpedienteDTO> lista){
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        if(lista.size() > 0){
            sb.append("<th>Nro</th>");
            sb.append("<th>Código de expediente</th>");
            sb.append("<th>Comisionado</th>");
            sb.append("<th>Fecha de registro</th>");
            sb.append("<th>Tipo de expediente</th>");
            sb.append("<th>Estado</th>");
            sb.append("<th>Sede</th>");
            sb.append("<th>Gestiones</th>");
        }
        sb.append("</tr>");
        int i = 0;
        for(ExpedienteDTO dto : lista){
            i++;
            sb.append("<tr>");
                sb.append("<td>").append(i).append("</td>");
                sb.append("<td>").append(dto.getNumero()).append("</td>");
                sb.append("<td>").append(dto.getComisionado()).append("</td>");
                sb.append("<td>").append(dto.getFecha()).append("</td>");
                sb.append("<td>").append(dto.getTipoExpediente()).append("</td>");
                sb.append("<td>").append(dto.getEstado()).append("</td>");
                sb.append("<td>").append(dto.getSede()).append("</td>");
                sb.append("<td style='text-align:center'><a href='#' onclick=listarGestiones('"+dto.getNumero()+"') >" +
"                                    <span class='glyphicon glyphicon-search' />" +
"                                </a></td>");
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
