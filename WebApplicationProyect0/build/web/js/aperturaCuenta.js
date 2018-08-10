
/*Funcion validarPassword verifica que ambas password sean iguales
 *Fyuncion Principal, envia los datos al servidor y nuestra la Respuesta mediante AJAX 
 */
$(document).ready(function () {
    $('form').submit(function () {

        var datosJSON = $(this).serialize();
        var metodo = $(this).attr("method");
        var action = $(this).attr("action");
        //Valida el Password de Confirmacion
        if (validarPassword()) {
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
                    console.log("ok");
                    console.log(data);
                    //Escribe la respuesta y oculta el simbolo de cargando ...
                    $('#rpta').removeClass('preloader1');
                    //VERIFICO que el usuario se registro correctamente
                    var estado = data.toString().substring(0, 2);
                    if (estado === "ok") {
                        $('form')[0].reset();
                        
                        data = data.substring(2);
                    }
                    $('#resultado').html(data);
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

        }
        return false;
    });
});
function  validarPassword() {

    var array = document.getElementsByName('password');
    var password = array[0].value;
    var password2 = array[1].value;
    //Verifico que ambos son iguales y los envio al servidor
    if (password === password2) {
        $('#confirmar').text("");
        return true;
    } else {
        //No envio los datos al servidor y muestra un mensaje de  Password de Confimacion Incorrecto
        $('#confirmar').html("<strong class='text-danger'>Password de confirmacion Incorrecto</strong>");
        return false;
    }
}


