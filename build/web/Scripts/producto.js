/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function listarproducto(precio) {
    $.ajax({
        method: "POST",
        url: "listar_producto",
        data: {precio:precio}
    })
            .done(function (resultado) {
                $("productorelacionado").html(resultado);
            });
}
function listarcategoria(categoria) {
    $.ajax({
        method: "POST",
        url: "Listar_Categotia",
        data: {idcategoria: categoria}
    })
            .done(function (resultado) {
                $("#catalogo").html(resultado);
            });
}
function publicaciones() {
    $.ajax({
        method: "POST",
        url: "publicaciones",
        data: {}
    })
            .done(function (resultado) {
                $("#publicaciones").html(resultado);
            });
}
function eliminarproducto(idproducto) {
    $.ajax({
        method: "POST",
        url: "eliminar",
        data: {ideli: idproducto},
        success: function (resultado) {
 window.location="inicio";
            Swal.fire({
                type: 'success',
                title: 'Éxito',
                text: '¡Se elimino Correctamente!',
                

            });
        

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

function mensaje(idproducto) {
    Swal.fire({
        title: 'Desea eliminar?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, !'
    }).then((result) => {
        if (result.value) {
            eliminarproducto(idproducto);
            
        }
    })

}

function publicarproducto(usuario) {
    $.ajax({
        url: "publicar",
        type: 'post',
        data: $('#formpublicar').serialize(),
        
        success: function (resultado) {
           alert("se publico correctamente");


        },
        error: function (error) {
            alert("no se pudo publicar")
        }


    })
}