<%-- 
    Document   : Producto
    Created on : 9/11/2019, 07:21:40 PM
    Author     : 57313
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Exchange.proyecto.persistencia.vo.ComentariosVo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.dao.ComentariosDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.PublicarVO"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 
            <title>Producto</title>
        </head>
        <body

            <header>
            <jsp:include page="/jsp/No_Usuario/Encabezado.jsp"></jsp:include> 
            </header>


            <!--Body-->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- Product main img -->
                        <div class="col-md-5 col-md-push-2">
                            <div id="product-main-img">
                                <div class="product-preview">
                                    <img src="${producto.getImagen1()}" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="${producto.getImagen2()}" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="${producto.getImagen3()}" alt="">
                            </div>

                        </div>
                    </div>
                    <!-- /Product main img -->

                    <!-- Product thumb imgs -->
                    <div class="col-md-2  col-md-pull-5">
                        <div id="product-imgs">
                            <div class="product-preview">
                                <img src="${producto.getImagen1()}" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="${producto.getImagen2()}" alt="">
                            </div>

                            <div class="product-preview">
                                <img src="${producto.getImagen3()}" alt="">
                            </div>

                        </div>
                    </div>
                    <!-- /Product thumb imgs -->

                    <!-- Product details -->
                    <div class="col-md-5">
                        <div class="product-details">
                            <h2 class="product-name">${producto.getNombre()}</h2>
                            <div>

                                <a class="review-link" href="#">Publicado el ${producto.getFecha()}</a>
                            </div>
                            <div>
                                <h3 class="product-price">${producto.getUsuario().getCiudadVO().getDescripcion()}</h3>

                            </div>

                            <p>${producto.getDescripcion()}</p>

                            <div class="product-options">

                            </div>

                            <div class="add-to-cart">
                                <div class="qty-label">

                                </div>
                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> ¡Lo quiero intercambiar!</button>
                            </div>

                            <ul class="product-links">
                                <li>Share:</li>
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                            </ul>

                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Descripcion</a></li>
                                <li><a data-toggle="tab" href="#tab2">Detalles</a></li>
                                <li><a data-toggle="tab" href="#tab3" onclick="vercomentarios(${producto.getId_publicar()})">Comentarios(3)</a></li>
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">
                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 class="product-price">Publicado el ${producto.getFecha()}</h4>
                                            <p>${producto.getDescripcion()}</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab1  -->

                                <!-- tab2  -->
                                <div id="tab2" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 class="product-price">Publicado Por ${producto.getUsuario().getNombres()}</h4>
                                            <p>Telefono : ${producto.getUsuario().getTelefono()} </p>
                                            <p></p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab2  -->

                                <!-- tab3  -->
                                <div id="tab3" class="tab-pane fade in">
                                    <div class="row">              
                                        <!-- Reviews -->
                                        <div class="col-md-6">
                                            <div id="reviews">
                                                <ul class="reviews">
                                                    <div id="comentarios"> 

                                                    </div>
                                                </ul>
                                                <ul class="reviews-pagination">
                                                    <li class="active">1</li>
                                                    <li><a href="#">2</a></li>
                                                    <li><a href="#">3</a></li>
                                                    <li><a href="#">4</a></li>
                                                    <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!-- /Reviews -->

                                        <!-- Review Form -->
                                        <div class="col-md-3">
                                            <div id="review-form">
                                                <form class="review-form">

                                                    <textarea class="input" placeholder="Tu comentario"></textarea>

                                                    <button class="primary-btn">Enviar</button>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- /Review Form -->
                                    </div>
                                </div>
                                <!-- /tab3  -->
                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div
        <!-- Section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">Related Products</h3>
                        </div>
                    </div>


                    <!-- product -->
                    <div id="productorelacionado">
                        <c:forEach var="pd" items="${requestScope.r}">
                            <div class="col-md-3 col-xs-6">
                                <div class="product">
                                    <div class="product-img">
                                        <img src="${pd.getImagen1()}" alt="">
                                        <div class="product-label">
                                            <span class="sale">-30%</span>
                                        </div>
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category"></p>
                                        <h3 class="product-name"><a href="#"></a></h3>
                                        <h4 class="product-price">$${pd.getPrecioestimado()}<del class="product-old-price"></del></h4>
                                        <div class="product-rating">
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                            <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                        </div>
                                    </div>
                                    <div class="add-to-cart">
                                        <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- /product -->


                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /Section -->

        <!--Body-->
        <!--Informcacion-->
        <jsp:include page="/complementos/Informacion.jsp"></jsp:include>
            <!--Informacion-->
        <jsp:include page="/complementos/footer.jsp"></jsp:include>
        </body>
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include>
</html>
