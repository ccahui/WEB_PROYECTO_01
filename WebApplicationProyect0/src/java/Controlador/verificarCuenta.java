/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.CuentaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
@WebServlet(name = "verificarCuenta", urlPatterns = {"/verificarCuenta"})
public class verificarCuenta extends HttpServlet {

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
        //Para almacenar variables de Session numCuenta y el Propietario
        HttpSession session = request.getSession(true);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String numCuenta = request.getParameter("id");
            String password = request.getParameter("password");

            try {
                
                Thread.sleep(2000);
                CuentaBD consultas = new CuentaBD();
                if (consultas.inicioCuenta(numCuenta, password)) {
                    //La verificarCuenta es Valida, creamos una variable de session que almacene que
                    //El numerodeCuenta y nombre del cliente
                    //La conexion con la BD 
                    Cuenta datosCliente = consultas.datosCuenta(numCuenta);
                    session.setAttribute("cuenta", datosCliente);
                    session.setAttribute("cuentaBD",consultas);
                    session.setAttribute("id","ok");
                    out.print("ok");
                } else {
                    consultas.cerrarConexion();
                    String mensaje="Cuenta o password incorrecto";
                        out.print("<div class='alert alert-info'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");

                }

            } catch (Exception ex) {
                Logger.getLogger(verificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
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
