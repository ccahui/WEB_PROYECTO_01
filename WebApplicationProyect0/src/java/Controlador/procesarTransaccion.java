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
@WebServlet(name = "procesarTransaccion", urlPatterns = {"/procesarTransaccion"})
public class procesarTransaccion extends HttpServlet {

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
            //No inicioSession
            if (cuenta == null) {
                response.sendRedirect("inicioCuenta");

            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(procesarTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String operacion=request.getParameter("operacion");
                String monto=request.getParameter("monto");
                String numCuenta=cuenta.getNumCuenta();
                
                //Se podira realizar la ocnuslta de Saldo y verificar si el monto
                //A retirar si es mayor al que dispone manderle un mensaje "Saldo Insuficiente para esta operacion"
                
                CuentaBD consultas = (CuentaBD) session.getAttribute("cuentaBD");
                boolean estadoTransaccion =consultas.transaccion(numCuenta, monto, operacion);
                if(estadoTransaccion){
                      String mensaje="Transaccion Realizada Exito";
                        out.print("<div class='alert alert-info'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");
                }
                 else 
                { 
                     String mensaje="No se completo la Transaccion";
                        out.print("<div class='alert alert-danger'> "
                                + "<button class='close' data-dismiss='alert'><span>&times;</span>"
                                + "</button><strong>" + mensaje + "</strong></div>");
                }

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
