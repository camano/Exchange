<%-- 
    Document   : Catalogo
    Created on : 10/11/2019, 01:17:15 PM
    Author     : 57313
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.vo.PublicarVO"%>
<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo</title>
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 
        </head>
        <body>

            <header>
            <jsp:include page="/jsp/No_Usuario/Encabezado.jsp"></jsp:include>

            </header
        <%

            int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
            ProductoDAO pdao = new ProductoDAO();
            CategoriaDao cd = new CategoriaDao();
            List<CategoriasVo> lista = cd.listar();
            List<PublicarVO> producto = pdao.listarcategoria(idcategoria);

        %>
        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- ASIDE -->
                    <div id="aside" class="col-md-3">
                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Categorias</h3>
                            <%for (int i = 0; i < lista.size(); i++){ %>
                            <div class="checkbox-filter">

                                <div class="input-checkbox">
                                    <input type="checkbox"  value="${ca.getIdCategoria()}" id="category-1">
                                    <label for="category-1">
                                        <span></span>
                                        <%=lista.get(i).getDescripcion()%>

                                        <small>(<%=cd.countcategoria(lista.get(i).getIdCategoria())%>)</small>
                                    </label>
                                </div>                     

                            </div>
                            <% }%>
                        </div>

                        <!-- aside Widget -->

                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Mejores Productos</h3>
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product01.png" alt="">
                                </div>
                                <div class="product-body">
                                    <h3 class="product-name"><a href="#">Portatil HP gris</a></h3>
                                    <h4 class="product-price">Bogotá </h4>
                                </div>
                            </div>

                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product02.png" alt="">
                                </div>
                                <div class="product-body">
                                    <h3 class="product-name"><a href="#">Cascos gamers </a></h3>
                                    <h4 class="product-price">Medellin </h4>
                                </div>
                            </div>

                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="./img/product03.png" alt="">
                                </div>
                                <div class="product-body">
                                    <h3 class="product-name"><a href="#">Portatil Gamer </a></h3>
                                    <h4 class="product-price">Cali</h4>
                                </div>
                            </div>
                        </div>
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">
                        <!-- store top filter -->
                        <div class="store-filter clearfix">
                            <div class="store-sort">
                                <label>
                                    Organizar por:
                                    <select class="input-select">
                                        <option value="0">Popular</option>
                                        <option value="1">Primer Publicación</option>
                                        <option value="2">Ultima Publicación</option>
                                    </select>
                                </label>


                            </div>

                        </div>
                        <!-- /store top filter -->

                        <!-- store products -->
                        <div class="row">
                            <!-- product -->
                            <div id="catalogo">
                                <c:forEach items="${listarcategoria}" var="pd" >
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="${pd.getImagen1()}" alt="">
                                                <div class="product-label">
                                               
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${pd.getCategoriasVo().getDescripcion()}</p>
                                                <h3 class="product-name"><a href="${pageContext.request.contextPath}/detalles?idproducto=${pd.getId_publicar()}">${pd.getNombre()}</a></h3>
                                                <h4 class="product-price">${pd.getUsuario().getCiudadVO().getDescripcion()}</h4>                                            
                                                   <h4 class="product-price">$${pd.getPrecioestimado()}<del class="product-old-price"></del></h4>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Me interesa</span></button>

                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">Ver mejor</span></button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> ¡Lo quiero intercambiar!</button>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /product -->

                                    <div class="clearfix visible-sm visible-xs"></div>

                                </c:forEach>
                            </div>
                        </div>
                        <!-- /store products -->

                        <!-- store bottom filter -->
                        <div class="store-filter clearfix">
                            <ul class="store-pagination">
                                <li class="active">1</li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                            </ul>
                        </div>
                        <!-- /store bottom filter -->
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>

        <jsp:include page="/complementos/footer.jsp"></jsp:include>
        </body>
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include>
</html>
