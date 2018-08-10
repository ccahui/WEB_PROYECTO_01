<%-- 
    Document   : sessionMovimientos
    Created on : 24/02/2018, 02:40:54 PM
    Author     : Christian
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>MOVIMIENTOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link  rel="stylesheet" href="CSS/bootstrap.min.css">
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul class="nav nav-tabs">
                        <li ><a href="inicioCuenta">Inicio</a></li>
                        <li ><a href="saldo">Saldo</a></li>
                        <li class="active"><a href="">Historial</a></li>
                        <li><a href="transaccionCuenta">Realizar Transaccion</a></li>
                        <li><a href="salir">salir</a></li>
                    </ul>
                </div>
            </div>
            <br>
        </div>
        <div class="container">
            <div class="table-responsive">
                <table class="table table-hover">
                    <tr class="success">
                        <th>Tipo de Operacion</th>
                        <th>Monto Realizado</th>
                        <th>Fecha de la Operacion</th>                        
                 <% 
                   ResultSet rs=(ResultSet)request.getAttribute("resultSet");
                    String operacion,monto,fecha;
                   while(rs.next()){
                     operacion=rs.getString("operacion");
                     monto=rs.getString("monto");
                     fecha=rs.getString("fecha");
                     String style="RETIRO".equals(operacion)?"text-danger":"text-info";
                 
                 %>
                    <tr class="<%=style%>" >
                        <td><%= operacion %></td>
                        <td><%= monto %></td>
                        <td><%= fecha %></td>
                    </tr>
                 <% }
                 
                 %>
                </table>
            </div>
        </div>


    </body>
</html>
