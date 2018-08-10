/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
@WebServlet(name = "registrarDatos", urlPatterns = {"/registrarDatos"})
public class registrarDatos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombre");
            String dni = request.getParameter("dni");
            String email = request.getParameter("email");

//Email es un atributo opcional no es obligatorio por el cual este puede ser ""
            Cliente nuevo = new Cliente(nombre, dni, email);

            try {
                String mensaje;
                Thread.sleep(2000);
                ClienteBD consulta = new ClienteBD();

                if (consulta.buscarCliente(dni)) {
                    mensaje = "Cliente ya registrado";
                    out.print("<div class='alert alert-info'> "
                            + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                            + "</button><strong>" + mensaje + "</strong></div>");
                } else {
                    if (consulta.insertarCliente(nuevo)) {
                        mensaje = "Bienvenido "+nombre+", ya puede realizar la apertura de Cuentas";
                        out.print("<div class='alert alert-success'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");
                    } else {

                        mensaje = "No se pudo completar su registro, intentelo mas Tarde";
                        out.print("<div class='alert alert-danger'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");

                    }
                }
            } catch (Exception ex) {
                out.print("ERRROR");
                //Fallo de conexion
                Logger.getLogger(registrarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

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
