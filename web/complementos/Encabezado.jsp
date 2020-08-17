<%-- 
    Document   : Encabezado
    Created on : 11/07/2019, 05:46:35 PM
    Author     : 57313
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Exchange.proyecto.persistencia.conexion.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.vo.PublicarVO"%>
<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


    </head>
    <body>
        <%

            usuariovo vo = (usuariovo) session.getAttribute("usuario");
            CategoriaDao cd = new CategoriaDao();
            ProductoDAO pdao = new ProductoDAO();
            List<CategoriasVo> lista = cd.listar();
            int id=vo.getId();

        %>

        <nav class="navbar-fixed-top">
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i>${usuario.getTelefono()}</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> ${usuario.getCorreo()}</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> ${usuario.getCiudadVO().getDescripcion()}</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-user-o"></i>${usuario.getNombres()}</a></li>
                        <li><a href="${pageContext.request.contextPath}/cerrar"><i class="fa fa-user-o"></i>Salir</a></li>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="${pageContext.request.contextPath}/inicio" class="logo">
                                    <img src="${pageContext.request.contextPath}/img/logolargo.png" alt="" width="285" height="80">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form action="${pageContext.request.contextPath}/categoria_Usuario" method="GET">
                                    <select class="input-select" name="idcategoria">
                                        <option value="0">Categorias</option>
                                        <c:forEach var="ca" items="<%=lista%>">
                                            <option value="${ca.getIdCategoria()}">${ca.getDescripcion()}</option>
                                        </c:forEach>
                                    </select>
                                    <input class="input" name="busquedad" placeholder="Busca aqui">
                                    <button class="search-btn">Buscar</button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Wishlist -->

                                <!-- /Wishlist -->

                                <!-- Cart -->
                                <div class="dropdown" onclick="publicaciones()">
                                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <i class="fa fa-user-plus"></i>
                                        <span>Perfil</span>
                                        <div class="qty"><%=pdao.countproducto(id)%></div>
                                    </a>
                                    <div class="cart-dropdown">
                                        <div class="cart-list">
                                            <div id="publicaciones">
                                                
                                            </div>
                                            
                                        </div>
                                        <center><p>Mis Productos</p></center>
                                        <div class="cart-summary">
                                             
                                        </div>
                                        <div class="cart-btns">
                                            <a href="${pageContext.request.contextPath}/publicarproductos">Publicar</a>
                                            <a href="#" onclick="abrireditar();">Editar Usuario  <i class="fa fa-arrow-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /Cart -->

                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <div>
                <nav id="navigation">
                    <!-- container -->
                    <div class="container">
                        <!-- responsive-nav -->
                        <div id="responsive-nav">
                            <!-- NAV -->
                            <ul class="main-nav nav navbar-nav">
                                <li class="active"><a href="${pageContext.request.contextPath}/inicio">Mejores productos</a></li>
                                    <c:forEach var="ca" items="<%=lista%>">
                                    <li><a href="${pageContext.request.contextPath}/categoria_Usuario?idcategoria=${ca.getIdCategoria()}">${ca.getDescripcion()}</a></li>
                                    </c:forEach>
                            </ul>
                            <!-- /NAV -->
                        </div>
                        <!-- /responsive-nav -->
                    </div>
                    <!-- /container -->
                </nav>
            </div>
        </nav>
        <jsp:include page="/complementos/modal.jsp"></jsp:include>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


    </body>

</html>
