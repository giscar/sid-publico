/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.pe.defensoria.servlet;

import gob.pe.defensoria.ejb.SidFacade;
import gob.pe.defensoria.ejb.FormularioVirtualFacade;
import gob.pe.defensoria.jpa.FormularioVirtual;
import gob.pe.defensoria.jpa.FormularioVirtualBk;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author carlos
 */
@WebServlet(name = "FormularioVirtualController", urlPatterns = {"/FormularioVirtualController"})
@MultipartConfig
public class FormularioVirtualController extends HttpServlet {

    @EJB
    private FormularioVirtualFacade facade;
    
    @EJB
    private SidFacade bKFacade;
    
    
    //public static String FILE_SYSTEM = "C:/filesystem/";
    
    public static String FILE_SYSTEM = "/srv/sid/filesystem/";

    //public static final String FILE_SYSTEM = "C:/server/glassfish-4.0/glassfish4/glassfish/domains/domain1/docroot/filesystem/";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String persona = request.getParameter("persona");

        if (persona == null) {
            request.setAttribute("listaDepartamentos", cargarDepartamentos());
            request.setAttribute("listaProvincias", cargarProvincias());
            request.setAttribute("listaDistritos", cargarDistritos());
            request.setAttribute("listaTipoDocumento", cargarTipoDocumento());
            request.getRequestDispatcher("/formularioVirtual.jsp").forward(request, response);
        } else {
            String nombre = request.getParameter("nombre");
            String apaterno = request.getParameter("apaterno");
            String amaterno = request.getParameter("amaterno");
            String tipodocumento = request.getParameter("tipo_doc");
            String documento = request.getParameter("documento");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String mail = request.getParameter("mail");
            String fechaNacimiento = request.getParameter("fecha_nac");
            String departamento = request.getParameter("departamento");
            String provincia = request.getParameter("provincia");
            String distrito = request.getParameter("distrito");
            String queja = request.getParameter("desc_queja");
            String sexo = request.getParameter("sexo");

            FormularioVirtual fv = new FormularioVirtual();
            fv.setCNombres(nombre);
            fv.setCApellidopaterno(apaterno);
            fv.setCApellidomaterno(amaterno);
            fv.setCTipodocumento(tipodocumento);
            fv.setCNumerodocumento(documento);
            fv.setCTelefono(telefono);
            fv.setCEmail(mail);
            fv.setCDireccion(direccion);
            fv.setDFechanacimiento(fechaNacimiento.equals("") ? null : parseFecha(fechaNacimiento));
            fv.setCDepartamento(departamento);
            fv.setCProvincia(provincia);
            fv.setCDistrito(distrito);
            fv.setCDescripcion(queja);
            fv.setCSexo(sexo);
            String ruta = null;
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (StringUtils.isNotBlank(fileName)) {
                    ruta = uploadArchive(part);
                }
            }
            fv.setCRuta(ruta);
            fv.setdFechaRegistro(new Date());
            fv.setdFecha(new Date());
            fv.setcEstado("A");
            fv.setcForma("07");
            fv = facade.guardar(fv);
            guardar(fv);
            response.sendRedirect("https://www.defensoria.gob.pe/quejas/respuesta1.php");
        }
    }
    
    private FormularioVirtualBk guardar(FormularioVirtual fv){
        FormularioVirtualBk bk = new FormularioVirtualBk();
        bk.setCApellidomaterno(fv.getCApellidomaterno());
        bk.setCApellidopaterno(fv.getCApellidopaterno());
        bk.setCDepartamento(fv.getCDepartamento());
        bk.setCDescripcion(fv.getCDescripcion());
        bk.setCDireccion(fv.getCDireccion());
        bk.setCDistrito(fv.getCDistrito());
        bk.setCEmail(fv.getCEmail());
        bk.setCNombres(fv.getCNombres());
        bk.setCNumerodocumento(fv.getCNumerodocumento());
        bk.setCProvincia(fv.getCProvincia());
        bk.setCRuta(fv.getCRuta());
        bk.setCSexo(fv.getCSexo());
        bk.setCTelefono(fv.getCTelefono());
        bk.setCTipodocumento(fv.getCTipodocumento());
        bk.setDFechanacimiento(fv.getDFechanacimiento());
        bk.setNIdRegistro(fv.getNIdRegistro());
        bk.setdFechaRegistro(fv.getdFechaRegistro());
        bKFacade.guardar(bk);
        return bk;
    }

    private String uploadArchive(Part fil) {
        String nameArchive = getFilename(fil);
        String extencion = getFileExtension(getFilename(fil));
        if (StringUtils.isNoneBlank(nameArchive)) {
            String formato = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
            String ruta = formato + extencion;
            File file = new File(FILE_SYSTEM + ruta);
            try (InputStream input = fil.getInputStream()) {
                Files.copy(input, file.toPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ruta;
        }
        return null;
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    private String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private static Date parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    private String cargarTipoDocumento() {
        List<Object[]> listaTipoDocumento = facade.listarTipoDocumento();
        StringBuilder sb = new StringBuilder();
        sb.append("<option value=''>---</option>");
        for (Object[] obj : listaTipoDocumento) {
            sb.append("<option value='" + obj[3].toString() + "'>" + obj[2].toString() + "</option>");
        }
        return sb.toString();
    }

    private String cargarDepartamentos() {
        List<Object[]> listaDepartamentos = facade.listarDepartamentos();
        StringBuilder sb = new StringBuilder();
        sb.append("<option value=''>---</option>");
        for (Object[] obj : listaDepartamentos) {
            sb.append("<option value='" + obj[0].toString() + "'>" + obj[1].toString() + "</option>");
        }
        return sb.toString();
    }

    private String cargarProvincias() {
        List<Object[]> listaProvincias = facade.listarProvincias();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(" var mi_arreglo_prov = new Array(); ");
        for (Object[] obj : listaProvincias) {
            sb.append("mi_arreglo_prov[" + i + "] = new Array(3);mi_arreglo_prov[" + i + "][0] ='" + obj[0].toString() + "'; mi_arreglo_prov[" + i + "][1] ='" + obj[2].toString() + "';mi_arreglo_prov[" + i + "][2] ='" + obj[1].toString() + "';");
            i++;
        }
        return sb.toString();
    }

    private String cargarDistritos() {
        List<Object[]> listaDistritos = facade.listarDistritos();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(" var mi_arreglo_dist = new Array(); ");
        for (Object[] obj : listaDistritos) {
            sb.append("mi_arreglo_dist[" + i + "] = new Array(4);mi_arreglo_dist[" + i + "][0] ='" + obj[0].toString() + "'; mi_arreglo_dist[" + i + "][1] ='" + obj[3].toString() + "';mi_arreglo_dist[" + i + "][2] ='" + obj[1].toString() + "';mi_arreglo_dist[" + i + "][3] ='" + obj[2].toString() + "';");
            i++;
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
