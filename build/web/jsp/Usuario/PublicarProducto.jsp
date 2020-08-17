<%-- 
    Document   : PublicarProducto
    Created on : 24/06/2019, 01:49:10 PM
    Author     : jonathan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicación</title>

        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 


        </head>
        <body >


        <%

            usuariovo vo = (usuariovo) session.getAttribute("usuario");
            CategoriaDao cd = new CategoriaDao();
            List<CategoriasVo> lista = cd.listar();
           
        %>
        <header>
            <jsp:include page="/complementos/Encabezado.jsp"></jsp:include>    
            </header>
           
            <form action="publicar?id=${usuario.getId()}" enctype="multipart/form-data" method="POST" id="formpublicar" onsubmit="return validarFields()">
            <div class="container">
                <center>
                    <h1>Publicar Producto</h1>
                </center>
                <div class="row">

                    <div class="col-sm-8 ">
                        <div class="col-lg-8">
                            <label>Nombre del producto</label>
                            <input type="text" name="nombre" class="form-control" onkeypress="return soloLetras(event)" required="">
                            <div>
                                <label for="Descipcion">Descipcion</label>
                                <textarea class="form-control" id="Descripcion" name="descripcion" style="resize:none;" rows="6" value=""
                                          required onkeypress="return soloLetras(event);" onKeyUp="this.value = this.value.toUpperCase();"></textarea>                            </div>
                        </div>	
                        <br>                      
                        <div class="rows ">
                            <div class="form-group">
                                <div class="col-md-6 ">
                                    <label>Precio estimado</label>
                                    <input type="text" name="precio"class="form-control" onKeyPress="return SoloNumeros(event);" onkeyup="format(this)" onchange="format(this)" required="">	
                                </div>

                                <div class="col-md-6 ">
                                    <label>Cantidad</label>
                                    <select class="form-control" name="size" id="size" required="">
                                        <option value="Seleccione una opcion">Seleccione una opcion</option>
                                        <% for (int i = 1; i <= 30; i++) {%>
                                        <option value='<%= i%>'><%= i%></option>
                                        <%}%>
                                    </select>	
                                </div>
                            </div>
                        </div>     
                        <div class="form-group">			  
                            <div class="col-md-6 ">
                                <label>Marca</label>
                                <input type="text" name="marca"class="form-control" required="">	
                            </div> 


                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group " id="preview">
                            <a href="#" id="file-select" class="btn btn-default">Subir</a>
                            <img src="img/foto.webp" id="foto" height="250" width="250">
                        </div>
                        <div>
                            <span class="alert alert-info" id="file-info">No hay archivos</span>
                            <input class="form-control" type="file" name="fileimagen" id="archivos" multiple> 
                        </div>

                        <div class="form-group">
                            <label>Categoria</label>
                            <select name="categoria" class="form-control">
                                <c:forEach var="ca" items="<%=lista%>">
                                    <option value="${ca.getIdCategoria()}">${ca.getDescripcion()}</option>
                                </c:forEach>
                            </select>
                        </div>      
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <center>
                        <input type="submit" class="form-control btn-danger" name="accion" value="Publicar">
                    </center>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </form>
        <jsp:include page="/complementos/Informacion.jsp"></jsp:include>
        <jsp:include page="/complementos/footer.jsp"></jsp:include>
        </body>
        <script src="../../Scripts/validaciones.js" type="text/javascript"></script>
    <jsp:include page="/complementos/linkJS.jsp"></jsp:include>
</html>
