/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.component.IEventoDAO;
import dao.component.IExpositorDAO;
import dao.component.IUsuarioDAO;
import dao.factory.DAOFactory;
import dao.to.EventoTO;
import dao.to.ExpositorTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
public class ServletCrearEvento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCrearEvento</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(request.getParameter("btnValidar") != null){
                String dni = request.getParameter("txtDNI");
                IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
                
                boolean verificar = usuarioDAO.buscarUsurioPorDNI(dni);
                String mensaje = "Esperando verificación...";
                if(verificar){
                    mensaje = "¡Usuario autentificado!";
                    
                    request.setAttribute("mensaje", mensaje);
                    RequestDispatcher rd = request.getRequestDispatcher("vistaCrearEvento.jsp");
                    rd.forward(request, response);
                }
                else{
                    mensaje = "Usuario no autentificado";
                    
                    request.setAttribute("mensaje", mensaje);
                    RequestDispatcher rd = request.getRequestDispatcher("vistaCrearEvento.jsp");
                    rd.forward(request, response);
                }
                
            }
            
            if(request.getParameter("btnSiguienteDetalleEvento") != null){
                String nombreEvento = request.getParameter("txtNombreEvento");
                String descripcionEvento = request.getParameter("txtDescripcionEvento");
                
                EventoTO eventoReceptor = new EventoTO(nombreEvento,descripcionEvento);
                IEventoDAO eventoDAO = DAOFactory.getInstance().getEventoDAO();
                
                boolean evento = eventoDAO.crearEvento(eventoReceptor);
                if(evento){
                    /*IExpositorDAO expositorDAO = DAOFactory.getInstance().getExpositorDAO();
                    ArrayList<ExpositorTO> listaExpositores = new ArrayList<ExpositorTO>();

                    listaExpositores = expositorDAO.listarExpositor();
                    request.setAttribute("listaExpositores", listaExpositores);
                    RequestDispatcher rd = request.getRequestDispatcher("vistaDetalleEvento.jsp");
                    rd.forward(request,response);*/
                    response.sendRedirect("vistaDetalleEvento.jsp");
                }
                else{
                    out.print("Error al crear el evento");
                } 
                
            }
            
            //out.println("<h1>Probando servlet crearEvento</h1>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
