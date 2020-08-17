/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function abrireditar() {
    $(".modal-body").load("jsp/Usuario/editar.jsp");
    $(".modal-title").html("Editar Usuario");
    $(".modal-footer").hide();
    $("#Modal").modal();

}
function abrircambiodeclave() {
    $(".modal-body").load("jsp/Usuario/Cambiodecontraseña.jsp");
    $(".modal-title").html("Cambio de contraseña");
    $(".modal-footer").hide();
    $("#Modal").modal();

}
function abrircorreo() {
    $(".modal-body").load("recuperar.jsp");
    $(".modal-title").html("Correo Electronico");
    $(".modal-footer").hide();
    $("#Modal").modal();

}

function desplejarmodal(asunto) {

    $(".modal-title").html("Mensaje")
    $(".modal-body").html(asunto)
    $(".modal-footer").show()
    $("#Modal").modal()
}



