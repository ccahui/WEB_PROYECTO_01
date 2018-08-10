/*
 *Peticion AJAX PARA verificar Cuenta si la Cuenta y el Password son correcots 
 */

           $(document).ready(function () {
    /*Para enviar los datos como lo realizaremos mediante
     * AJAX */
    $('form').submit(function () {
        /*EL objeto this, es el formulario con el metodo serialize convierte cada uno de los 
         * en Un objeto JSON para enviar al servidor*/

        var datosJSON = $(this).serialize();
        var metodo = $(this).attr("method");
        var action = $(this).attr("action");

        $.ajax({
            beforeSend: function () {
                //Muestra simbolo de cargando ...
                $('#rpta').attr('class', 'preloader1');
                $('#resultado').text("");
            },
            method: metodo,
            url: action,
            data: datosJSON,
            success: function (data) {
                console.log(data);
                //Escribe la respuesta y oculta el simbolo de cargando ...
                $('#rpta').removeClass('preloader1');
                
               if(data==="ok")
                    window.location.assign("inicioCuenta");
               else{
                   $('#resultado').html(data);
               }
            },
            error: function (data) {
                //Si ocurre un error, por ejemplo la pagina dejo de exisitir
                //Oculta el simobolo de Cargando y muestra el mensaje
                $('#rpta').removeClass('preloader1');
                $('#resultado').text("Error " + data);
                console.log("Error " + data);
            },
            /*Sirve el tiempo de espera maximo para la respuesta*/
            timeout: 10000

        });
        return false;
    });

});
