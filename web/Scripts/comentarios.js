/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function vercomentarios(idproducto) {
    $.ajax({
        method: "POST",
        url: "comentar",
        data: {idpublicacion: idproducto}
    })
            .done(function (resultado) {
                $("#comentarios").html(resultado);
            });
}
function agregarcomentarios(idproducto) {
    $.ajax({
        method: "POST",
        url: "agregarcomentar",
        data: {comentario: $("#txtcaja").val(),idpublicacion: idproducto}
    })
            .done(function (resultado) {
                $("#comentarios").html(resultado);
            });
}