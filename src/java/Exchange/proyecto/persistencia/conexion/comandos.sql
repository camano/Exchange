/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  57313
 * Created: 18/08/2019
 */

select * from libro
update libro set descripcion="pegelo" where isbn=123
insert into libro (descripcion) values("pegelo") where isbn=2

select * from usuario
select * from producto
select * from ciudad where id_ciudad=5001

select * from comentarios

select * from comentarios inner join usuario on comentarios.idusuario_id=usuario.idusuario
inner join producto on comentarios.idproducto_id=producto.idproducto where idproducto_id=15

insert into comentarios (comentario,idusuario_id,idproducto_id) values ("que celular tan pobre",19,25) 

insert into usuario()

select * from solicitud_intercambio

insert into solicitud_intercambio(producto_idproducto,idinteresados_id) values()