/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.component.IUsuarioDAO;
import dao.factory.DAOFactory;
import dao.to.UsuarioTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
public class ServletRegistroUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegistroUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(request.getParameter("btnRegistrarse") != null){
                String dni = request.getParameter("txtDNI");
                String password = request.getParameter("txtPassword");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String celular = request.getParameter("txtTelefono");

                UsuarioTO usuarioReceptor = new UsuarioTO(dni, password, nombre, apellido, celular);

                IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
                boolean respuesta = usuarioDAO.crearUsuario(usuarioReceptor);
                
                if(respuesta == true){
                    //out.println("<h1>Usuario Registrado exitosamente</h1>");
                    request.setAttribute("r", "Te registrado correctamente.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    response.sendRedirect("/");
                }
                else{
                    out.println("Error al registrar el usuario");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
