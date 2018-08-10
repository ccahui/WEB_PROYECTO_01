<%-- 
    Document   : sessionSaldo
    Created on : 26/02/2018, 03:19:34 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>INICIO</title>
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
                        <li><a href="inicioCuenta">Inicio</a></li>   
                        <li class="active"><a href="">Saldo</a></li>   
                        <li><a href="historialTransaccion">Historial</a></li>
                        <li><a href="transaccionCuenta">Realizar Transaccion</a></li>
                        <li><a href="salir">salir</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            
            <br>
            <h4>Dispone de un Saldo: <%=request.getAttribute("saldo") %></h4>
            
            
        </div>
    </body>
</html>
