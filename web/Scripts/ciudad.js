/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "../../Controlador_Departamentos",
        data: {action: "departamentos"}
    })
            .done(function (dpl) {
                $("#departamento").html(dpl);
            })
    $("#departamento").on('change', function () {
        var id = $('#departamento').val()

        $.ajax({
            type: "POST",
            url: "../../Controlador_Departamentos",
            data: {action: "ciudad", idDep: id}
        })
                .done(function (cil) {
                    $("#ciudad").html(cil);
                })
    })
});