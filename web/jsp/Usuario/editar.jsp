<%-- 
    Document   : editar
    Created on : 17/08/2019, 08:22:11 PM
    Author     : 57313
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Exchange.proyecto.persistencia.vo.CiudadVO"%>
<%@page import="java.util.List"%>
<%@page import="Exchange.proyecto.persistencia.dao.CiudadDao"%>
<%@page import="Exchange.proyecto.persistencia.vo.usuariovo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form id="formEditarUsuario" >
    <div class="form-group">Nombre</label>
        <input type="text" class="form-control" name="nombre" id="name" placeholder="digite nombre">
        <input type="hidden" class="form-control" name="idusuario" id="idusuario" placeholder="digite nombre">

    </div>
    <div class="form-group">Correo</label>
        <input type="text" class="form-control" name="correo"  id="correo" placeholder="digite Correo">
    </div>  
    <div class="form-group">Telefono</label>
        <input type="text" class="form-control" name="telefono"  placeholder="digite Telefono">
    </div>  
    <div class="form-group">
        <label for="exampleFormControlSelect1">Departamentos</label>
        <select class="form-control" name="country" id="departamento"  required="" > 

        </select>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1" id="country">Ciudad</label>
        <select class="form-control"name="txtciudad" id="ciudad" required="" >
            <option value="${usuario.getCiudadVO().getIdciudad()}" >${usuario.getCiudadVO().getDescripcion()}</option>
        </select>
    </div>
</form>
<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <button class="btn btn-success form-control" id="btnEditarUsuario">EDITAR</button>       
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <input class="btn btn-success form-control" onclick="abrircambiodeclave();" type="submit"  id="btnEditarUsuario" value="EDITAR CLAVE">
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/Scripts/Usuario.js" type="text/javascript"></script>

