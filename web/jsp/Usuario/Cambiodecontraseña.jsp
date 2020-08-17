<%-- 
    Document   : Cambiodecontraseña
    Created on : 26/08/2019, 05:56:36 PM
    Author     : 57313
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container-fluid">
    <div class="row">

        <form id="formcambioclave" method="POST" >
            <div id="errores"></div>
            <div class="form-group">
                Anterior Clave
                <div>
                    <input type="password" name="claveanterior" id="claveanterior" class="form-control">
                </div>
            </div>
            <div class="form-group">
                Nueva Clave
                <div>
                    <input type="password" name="clavenueva" class="form-control" id="nuevaclave">
                </div>
            </div>
            <div class="form-group">
                Confirmar Clave
                <div>
                    <input type="password" name="confirmarclave" class="form-control" id="confirmarclave">
                </div>
                <br>
            </div>
        </form>     



    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <button class="btn btn-success form-control"  id="btnEditarUsuario">Cancelar</button>       
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <button class="btn btn-success form-control"   id="btnclave">Cambiar</button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/Scripts/Usuario.js" type="text/javascript"></script>