/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
@WebServlet(name = "aperturarCuenta", urlPatterns = {"/aperturarCuenta"})
public class aperturarCuenta extends HttpServlet {

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
            
            String dni = request.getParameter("dni");
            String password = request.getParameter("password");
         
            try {
                String mensaje;
                Thread.sleep(2000);
                ClienteBD consulta = new ClienteBD();

                if (!consulta.buscarCliente(dni)) {
                    mensaje = "Cliente no Registrado, por favor complete el formulario de Registro de Datos";
                    out.print("<div class='alert alert-danger'> "
                            + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                            + "</button><strong>" + mensaje + "</strong></div>");
                } else {
                    //Donde la funcion devulve el numero de Cuenta que se le asigna al CLIENTE
                    //Devulve -1 si no se pudo realizar la apertura de Cuenta
                    
                   
                    int numCuenta=consulta.crearCuenta(dni, password);
                    
                    if (numCuenta!=-1) {
                        mensaje = "Se Acepto la apertura de su cuenta, Su numero de Cuenta es: "+numCuenta;
                        out.print("ok <div class='alert alert-success'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");
                    } else {
                        mensaje = "No se logro la apertura de su cuenta, intentelo mas Tarde";
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
