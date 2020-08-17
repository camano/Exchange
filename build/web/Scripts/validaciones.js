/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validarFields() {

    //validar campo de tipo file
    var archivos = document.getElementById('archivos').files;
    if (archivos.length == 3) {
        for (var i = 0; i < archivos.length; i++) {
            var name = archivos[i].name;
            var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
            if (ext != 'jpg' && ext != "png") {
                alert('Archivo ' + name + ' incorrecto, solo imagenes jpg o png...');
                return false;
            }
        }
        return true;
    } else {
        alert("Por favor seleccione 3 archivos de tipo imagen");
    }



    return false;
}

$('#btncrearproducto').click(function (e) {
    e.preventDefault();
    var nombre = $('#nombre').val();
    var descripcion = $('#descripcion').val();
    var precio = $('#precio').val();
    var categoria = $('#categoria').val();
    var detalles = $('#detalles').val();
    var reviews = $('#reviews').val();
    var size = $('#size').val();
    var color = $('#color').val();

    if (validarFields(nombre, descripcion, precio, categoria, detalles, reviews, size, color)) {
        var data = new FormData($('#frm_nuevo')[0]);
        $.ajax({
            url: "crearproducto",
            type: "post",
            data: data,
            contentType: false,
            processData: false,
            success: function (data) {
                alert(data);
            }
        });
    }

});



function mensajecorreo() {
    Swal.fire({
        type: 'error',
        title: 'Error',
        text: '¡Error Correo Ya regristado!',
    })
}


function abrireditar() {
    $(".modal-body").load("jsp/Usuario/editar.jsp");
    $(".modal-title").html("Editar Perfil");
    $(".modal-footer").hide();
    $("#Modal").modal();

}
function letrasmin(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {
        return false;
    }
}

function format(input)
{
    var num = input.value.replace(/\./g, '');
    if (!isNaN(num)) {
        num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g, '$1.');
        num = num.split('').reverse().join('').replace(/^[\.]/, '');
        input.value = num;
    } else {
        
        input.value = input.value.replace(/[^\d\.]*/g, '');
    }
}

function SoloNumeros(evt) {
    if (window.event) {//asignamos el valor de la tecla a keynum
        keynum = evt.keyCode; //IE
    } else {
        keynum = evt.which; //FF
    }
    //comprobamos si se encuentra en el rango numérico y que teclas no recibirá.
    if ((keynum > 47 && keynum < 58) || keynum == 8 || keynum == 13 || keynum == 6) {
        return true;
    } else {
        return false;
    }
}

function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toString();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
    especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1 && !tecla_especial) {

        return false;
    }
}