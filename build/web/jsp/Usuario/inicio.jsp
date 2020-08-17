<%-- 
    Document   : inicio
    Created on : 10/08/2019, 05:04:02 PM
    Author     : Caamaño
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.vo.PublicarVO"%>
<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.dao.ProductoDAO"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exchange</title>
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 
        </head>
        <body>
        <body>
        <%
            usuariovo vo = (usuariovo) session.getAttribute("usuario");
            ProductoDAO pdao = new ProductoDAO();
            List<PublicarVO> producto = pdao.verproducto();
            if (vo == null) {
                response.sendRedirect(request.getContextPath() + "/Controlador_Errores");
            }


        %>
        
        <header>
            <jsp:include page="/complementos/Encabezado.jsp"></jsp:include> 
            </header>  

           
                <!--Productos-->
                <div class="section">
                    <!-- container -->
                    <div class="container">
                        <!-- row -->
                        <div class="row">

                            <!-- section title -->
                            <div class="col-md-12">
                                <div class="section-title">
                                    <h3 class="title">Nuevos productos</h3>
                                    <div class="section-nav">

                                    </div>
                                </div>
                            </div>
                            <!-- /section title -->

                            <!-- Products tab & slick -->
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="products-tabs">
                                        <!-- tab -->
                                        <div id="tab1" class="tab-pane active">
                                            <div class="products-slick" data-nav="#slick-nav-1">
                                                <!-- product -->
                                            <c:forEach var="pd" items="<%=producto%>" >
                                                <div class="product">
                                                    <div class="product-img">
                                                        <img src="${pd.getImagen1()}" alt="">
                                                        <div class="product-label">

                                                            <span class="new">NEW</span>
                                                        </div>
                                                    </div>
                                                    <div class="product-body">
                                                        <p class="product-category"></p>
                                                        <h3 class="product-name"><a href="${pageContext.request.contextPath}/producto?producto=${pd.getId_publicar()}">${pd.getNombre()}</a></h3>
                                                        <h4 class="ciudad">${pd.getUsuario().getCorreo()}</h4>
                                                         <h4 class="product-price">$${pd.getPrecioestimado()}<del class="product-old-price"></del></h4>

                                                        <div class="product-btns">
                                                            <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Me interesa</span></button>

                                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">Observar Mejor</span></button>
                                                        </div>
                                                    </div>
                                                    <div class="add-to-cart">
                                                        <button class="add-to-cart-btn" onclick="agregarinteresados(${usuario.getId()},${pd.getId_publicar()})"><i class="fa fa-shopping-cart"></i>¡Lo quiero intercambiar!</button>
                                                    </div>
                                                </div>
                                                <!-- /product -->
                                            </c:forEach>

                                        </div>
                                        <div id="slick-nav-1" class="products-slick-nav"></div>
                                    </div>
                                    <!-- /tab -->
                                </div>
                            </div>
                        </div>
                        <!-- Products tab & slick -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
         ${bienvenida}
        <!--I
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include>nformacion-->
        <jsp:include page="/complementos/Informacion.jsp"></jsp:include>
            <!--footer-->
        <jsp:include page="/complementos/footer.jsp"></jsp:include>
        </body>
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include>
    
</html>

