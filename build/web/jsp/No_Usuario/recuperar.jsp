<%-- 
    Document   : recuperar
    Created on : 6/12/2019, 01:39:51 PM
    Author     : 57313
--%>

<%-- 
    Document   : Cambiodecontraseña
    Created on : 26/08/2019, 05:56:36 PM
    Author     : 57313
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container-fluid">
    <div class="row">

        <form id="formcorreo" method="POST" >
            <div id="errores"></div>
            <div class="form-group">
               Correo
                <div>
                    <input type="text" name="correo" id="correo" class="form-control">
                </div>
            </div>
       
        </form>     



    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <button class="btn btn-success form-control"  id="btnCorreo">Enviar</button>       
            </div>
        </div>
        
    </div>
</div>

<script src="${pageContext.request.contextPath}/Scripts/Usuario.js" type="text/javascript"></script>