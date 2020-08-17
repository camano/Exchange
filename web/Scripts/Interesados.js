/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ins() {

}

function listadeinteresados() {
    location.href = "Interesados";


}
function agregarinteresados(usuario, producto) {
    $.ajax({
        method: "POST",
        url: "agregarinteresados",
        data: {idusuario: usuario, idproducto: producto},
        success: function (resultado) {

            Swal.fire({
                type: 'success',
                title: 'Éxito',
                text: '¡Se Envio Su Solicitud!',

            });
            location.href="inicio";

        },
        error: function (error) {
            Swal.fire({

                type: 'error',
                title: 'Error',
                text: '¡NO Se pudo Enviar!',
            });

        },

    })
}

function eliminarinteresados(idinteresado) {
    $.ajax({
        method: "POST",
        url: "eliminarinteresados",
        data: {eliminar: idinteresado},
        success: function (resultado) {

            Swal.fire({
                type: 'success',
                title: 'Éxito',
                text: '¡Se elimino Correctamente!',

            })
           
        },
        error: function (error) {
            Swal.fire({

                type: 'error',
                title: 'Error',
                text: '¡NO Se pudo eliminar!',
            })

        },
    })

}
function mensajeseliminacion(idinteresado) {
    Swal.fire({
        title: 'Desea eliminar?',
        text: "El interesado!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, !'
    }).then((result) => {
        if (result.value) {
            eliminarinteresados(idinteresado);

        }
    })
}


function guardarsolicitud(producto, interesado) {
    $.ajax({
        method: "POST",
        url: "agregarsolicitud",
        data: {idproducto: producto, idinteresado: interesado},
        success: function (resultado) {

            Swal.fire({
                type: 'success',
                title: 'Éxito',
                text: '¡Se elimino Correctamente!',

            })

        },
        error: function (error) {
            Swal.fire({

                type: 'error',
                title: 'Error',
                text: '¡NO Se pudo eliminar!',
            })

        },
    })

}