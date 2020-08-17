<%-- 
    Document   : regristar
    Created on : 29/05/2019, 01:46:55 PM
    Author     : jonathan
--%>

<%@page import="Exchange.proyecto.persistencia.vo.CategoriasVo"%>
<%@page import="Exchange.proyecto.persistencia.dao.CategoriaDao"%>
<%@page import="Exchange.proyecto.persistencia.dao.departamentoDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.DepartamentosVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.CiudadDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.CiudadVO"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page import="Exchange.proyecto.persistencia.conexion.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>

        <meta charset="UTF-8">
        <title>Registrar</title> 

        <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 


        </head>  
        <body >
            <header>
                <div id="top-header">
                    <div class="container">
                        <ul class="header-links pull-left">
                            <li><a href="#"><i class="fa fa-phone"></i> 3114862038</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i> exchange@gmail.com</a></li>
                            <li><a href="../../index.jsp"> Inicio </a></li>
                        </ul>
                        <ul class="header-links pull-right">
                            <li><a href="${pageContext.request.contextPath}/jsp/No_Usuario/Ingreso.jsp"><i class="fa fa-user-o"></i> Iniciar sesión</a></li>
                        <li><a href="${pageContext.request.contextPath}/jsp/No_Usuario/regristar.jsp"><i class="fa fa-user-o"></i> Regristate</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <center>
            <img src="${pageContext.request.contextPath}/img/logolargo.png">
        </center>
    </header>


    <form class="formulario" action="${pageContext.request.contextPath}/regristar" method="Post"  >

        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <div class="col-md-7">
                        <c:if test="${not empty requestScope.listaerrores}">
                            <div class="alert alert-danger">
                                <c:forEach var="Error" items="${requestScope.listaerrores}">
                                    <strong>${Error}</strong> 
                                    <br>
                                </c:forEach>
                            </div>
                        </c:if>
                        <!-- Billing Details -->              
                        <div class="billing-details">
                            <div class="section-title">
                                <h3 class="title">Regristar</h3>
                            </div>
                            <div class="form-group">
                                <p>Ingresa el nombre de Usuario<p>
                                    <input class="input" type="text" name="txtnombre" value="${campos.getNombres()}" value=""
                                           required onkeypress="return soloLetras(event);" onKeyUp="this.value = this.value.toUpperCase();" >
                            </div>

                            <div class="form-group">
                                <p>Ingrese el Correo Electronico </p>
                                <input class="input" type="email" name="txtcorreo" value="${campos.getCorreo()}" id="correo" maxlength="30" required="">
                            </div>
                            <div class="form-group">
                                <p>Ingrese Una Clave</p>
                                <input class="input" type="password"  name="txtpassword" value="${campos.getPassword()}" id="clave" minlength="7" maxlength="20" required="">
                            </div>
                            <div class="form-group">
                                <p>Confirmar Clave</p>
                                <input class="input" type="password"  name="txtpassword2" value="${campos.getPassword()}" id="clave2" required="">
                            </div>
                            <div class="form-group">
                                <p>Ingresa un Telefono</p>
                                <input class="input" type="text" name="txttelefono"  value="${campos.getTelefono()}" class="" id="telefono" required onKeyPress="return SoloNumeros(event);" maxlength="10">
                            </div>

                            <div class="form-group">
                                <select class="form-control" name="country" id="departamento"  required="" >               
                                </select>
                            </div>
                            <div class="form-group ">
                                <select class="form-control"name="txtciudad" id="ciudad" required="" >
                                </select>
                            </div>
                            <div class="form-group "> 
                                <select name="sexo" class="form-control" id="genero" >
                                    <option value="">Genero</option>
                                    <option value="Masculino">Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                </select>
                            </div>
                            <button class="primary-btn">Registrar</button>

                        </div>  
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</form>

<jsp:include page="/complementos/footer.jsp"></jsp:include>
</body>
<jsp:include page="/complementos/linkJS.jsp"></jsp:include>
<script src="../../Scripts/ciudad.js" type="text/javascript"></script>
<script src="../../Scripts/validaciones.js" type="text/javascript"></script>
</html>