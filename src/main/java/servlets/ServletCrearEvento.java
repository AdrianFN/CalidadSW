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

        response.setContentType("text/html;charset=UTF-8"); //texto html
        String action = request.getParameter("action");

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "second":
                second(request, response);
                break;
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vistaCrearEvento.jsp").forward(request, response);
    }

    private void second(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        IExpositorDAO expositorDAO = DAOFactory.getInstance().getExpositorDAO();
        ArrayList<ExpositorTO> listaExpositor = expositorDAO.listarExpositor();
        
        request.setAttribute("expositores", listaExpositor);
        request.getRequestDispatcher("vistaDetalleEvento.jsp").forward(request, response);
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

        response.setContentType("text/html;charset=UTF-8"); //texto html
        String action = request.getParameter("action");

        switch (action) {
            case "create1":
                create1(request, response);
                break;

        }

    }

    private void create1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getParameter("btnValidar") != null) {
            String dni = request.getParameter("txtDNI");
            IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();

            boolean verificar = usuarioDAO.buscarUsurioPorDNI(dni);
            String mensaje = "Esperando verificación...";
            if (verificar) {
                mensaje = "¡Usuario autentificado!";

                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("vistaCrearEvento.jsp").forward(request, response);
            } else {
                mensaje = "Usuario no autentificado";

                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("vistaCrearEvento.jsp").forward(request, response);
                
            }

        }

        if (request.getParameter("btnSiguienteDetalleEvento") != null) {
            String nombreEvento = request.getParameter("txtNombreEvento");
            String descripcionEvento = request.getParameter("txtDescripcionEvento");

            EventoTO eventoReceptor = new EventoTO(nombreEvento, descripcionEvento);
            IEventoDAO eventoDAO = DAOFactory.getInstance().getEventoDAO();

            boolean evento = eventoDAO.crearEvento(eventoReceptor);
            if (evento) {
                response.sendRedirect("./ServletCrearEvento?action=second");
            } else {
                response.sendRedirect("./ServletCrearEvento?action=index");
            }

        }

        //response.sendRedirect("./events_create?action=second");
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
