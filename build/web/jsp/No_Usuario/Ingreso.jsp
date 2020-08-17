<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="es">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <jsp:include page="/complementos/linkcss.jsp"></jsp:include> 
        <link href="${pageContext.request.contextPath}/recursos/css/estiloo.css" rel="stylesheet" type="text/css"/>
        <title>Ingreso</title>
    </head>
    <body>

    <center>
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
    </center>
</header> 
<div class="contenedor">
    <div class="container mt-10">
        <form class="formulario" action="${pageContext.request.contextPath}/ingresar" method="Post" onsubmit="">

            <div class="card-header">
                <center><h3>Ingresar</h3></center>
            </div>
            <br>
            <c:if test="${not empty requestScope.Errorlogin}">
                <div class="alert alert-danger">
                    <c:forEach var="Error" items="${requestScope.Errorlogin}">
                        <strong>${Error}</strong> 
                        <br>
                    </c:forEach>
                </div>
            </c:if>
            <div class="contenedor">
                <label for="Name"><p>Correo Electronico</p></label>
                <div class="input-contenedor">
                    <center>
                        <input class="form-control" type="email"  required="" id="correo"  name="correo">
                    </center>
                </div>
                <br>
                <label for="Name">Contraseña</label>
                <div class="input-contenedor">
                    <center>
                        <input class="form-control" type="password" id="clave" required="" name="password"  >
                    </center>
                </div>
                <br>
                <center>
                    <div class="card-footer">
                        <input type="submit" value="Ingresar" class=" btn btn-primary btn-lg btn-block">
                    </div>

            </div>
            <center>
                <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
                <p>¿No tienes una cuenta? <a class="link" href="regristar.jsp">Registrate </a></p>
                <p>¿No tienes una cuenta? <a class="link" href="#" onclick="abrircorreo();" >Recuperar </a></p>
            </center>
    </div>
</form>        

</div>
<jsp:include page="/complementos/modal.jsp"></jsp:include>
<jsp:include page="/complementos/footer.jsp"></jsp:include>
</body>                 
<jsp:include page="/complementos/linkJS.jsp"></jsp:include>

</html>



