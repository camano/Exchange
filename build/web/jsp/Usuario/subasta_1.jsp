<%-- 
    Document   : carrito
    Created on : 18/08/2019, 04:38:30 PM
    Author     : johan
--%>

<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page import="Exchange.proyecto.persistencia.vo.PublicarVO"%>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>


<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <jsp:include page="/complementos/linkcss.jsp"></jsp:include>

   
    </head>
    <body >
        <jsp:include page="/complementos/Encabezado.jsp"></jsp:include>

            <div class="container mt-4">

                <br>
                <div class="row">
                    <div class="col-sm-9">
                        <table class="table table-hover">
                            <thead>
                                <tr>

                                    <th></th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Ciudad</th>
                                    <th>Categoria</th>
                                    <th>Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.usuarioaintercambiar}" var="pdo">
                                <tr>
                                    <td><img src="${pdo.getImagen1()}" width="200" height="200"></td>
                                    <td>${pdo.getNombre()}</td>             
                                    <td>${pdo.getDescripcion()}</td>  
                                    <td>$.${pdo.getPrecioestimado()}</td>  
                                    <td>${pdo.getUsuario().getCiudadVO().getDescripcion()}</td> 
                                    <td>${pdo.getCategoriasVo().getDescripcion()}</td> 
                                    <td><button class="btn-light" onclick="guardarsolicitud(${pdo.getId_publicar()},${interesado})">Aceptar</button></td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                     
                </div>   
                <div class="col-lg-3">
                    <div class="card"></div>
                    <div class="card-header">
                        <h3></h3>
                    </div>
                    <div class="card-body">
                        <div class="text-center">
                            <img src="${producto.getImagen1()}" class="rounded-circle" width="200" height="200"></div><br>
                       
                        <label>Tu precio:</label>
                        <input type="text" readonly="" value="${producto.getPrecioestimado()}" class="form-control">
           
                    </div>
                    
                </div>
            </div>
            <jsp:include page="/complementos/linkJS.jsp"></jsp:include> 
    </body>
</html>
