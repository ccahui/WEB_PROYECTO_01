<%-- 
    Document   : sessionSaldo
    Created on : 24/02/2018, 02:34:24 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SALDO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link  rel="stylesheet" href="CSS/bootstrap.min.css">
        <link  rel="stylesheet" href="CSS/cargando.css">
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/procesarTransaccion.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
       
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul class="nav nav-tabs">
                        <li><a href="inicioCuenta">Inicio</a></li>
                        <li><a href="saldo">Saldo</a></li>
                        <li><a href="historialTransaccion">Historial</a></li>
                        <li class="active"><a href="">Realizar Transaccion</a></li>
                        <li><a href="salir">salir</a></li>
                    </ul>   
                </div>
            </div>

        </div>  
        <br>
        <div class="container">
            <div class="col-md-6">
            <form class="form-horizontal" action="procesarTransaccion" method="POST">
                <div class="form-group">
                    <label class="control-label col-md-3">Operacion</label>
                    <div class="col-md-6">
                        <select class="form-control" name="operacion">
                            <option>DEPOSITO</option>
                            <option>RETIRO</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Monto</label>
                    <div class="col-md-6"> 
                        <input class="form-control" placeholder="Monto" type="number" name="monto" required>
                    </div>                          
                </div> 
                <div class="form-group">
                    <div class="col-xs-offset-1">
                        <input class="btn btn-warning" type="reset" value="Limpiar">
                        <input class="btn btn-success" type="submit" value="Realizar">
                    </div>

                </div>

                <div id="rpta"></div>
            </form>
            <!-- Respuesta del Servidor-->
            <div id="resultado">
            </div> 

        </div>
        </div>
    </body>
</html>

