<%-- 
    Document   : Interesados
    Created on : 29/08/2019, 08:40:30 AM
    Author     : 57313
--%>

<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.InteresadosDAO"%>
<%@page import="Exchange.proyecto.persistencia.vo.InteresadosVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interesados</title>
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include>
        </head>
        <body >

            <header>
            <jsp:include page="/complementos/Encabezado.jsp"></jsp:include>    
            </header>

            <div class="container">

                <div class="table-responsive">       
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">Interesados</h3>                 
                        </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>                             
                                <th>Nombre</th>
                                <th>Productos</th>                               
                                <th>Ciudad</th>
                                <th>Cancelar</th>                               
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.interesados}" var="in">
                            <tr>
                            <tr>
                                <td>${in.getUsuario().getNombres()}</td>
                                <td><form method="GET" action="${pageContext.request.contextPath}/productoaintercambiar">
                                        <input type="hidden" name="idusuario" value="${in.getUsuario().getId()}">
                                        <input type="hidden" name="idinteresado" value="${in.getIdinteresados()}">
                                        <input type="hidden" name="idproducto" value="${in.getPublicar().getId_publicar()}">
                                        <button class="btn btn-block form-control">Ver Producto</button>
                                    </form></td>
                                <td>${in.getUsuario().getCiudadVO().getDescripcion()}</td>
                                <td><form method="GET" action="${pageContext.request.contextPath}/eliminarinteresados">
                                        <input type="hidden" name="idusuario" value="${in.getUsuario().getId()}">
                                        <input type="hidden" name="idinteresado" value="${in.getIdinteresados()}">
                                        <button class="btn btn-block form-control">Eliminar</button>
                                    </form></td>                        
                            </tr>            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include> 
</html>
