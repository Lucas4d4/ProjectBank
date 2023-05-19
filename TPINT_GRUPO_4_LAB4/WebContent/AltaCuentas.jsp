<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\menu.css' rel='stylesheet'>
<link href='css\Cuenta.css' rel='stylesheet'>
<title>Alta de Cuentas</title>
</head>
<body>


<%
	HttpSession sesion = request.getSession();
	String usuario = null;

	if(sesion.getAttribute("user")!=null){
		usuario = sesion.getAttribute("user").toString();
		%>
					<div class="derechas">
			<div class="btn-group" role="group" aria-label="Basic example">
			  <button type="button" class="btnAdmin2"><%=usuario.toString()%></button>
			  &nbsp;&nbsp;&nbsp;
			   <form action="servletLogout" method="post">
			  <input type="submit" class="btnSalir" name="salir" value="Salir" >
				</form>
			</div>
		</div>
	<%
	
	}
%>

<jsp:include page="Menu.html"></jsp:include>

<form action="servletCuenta" method="post">
<div class="div-alta">
<h1>Alta de Cuenta</h1>
	<p>N° Cuenta de cliente: </p>
	<input type="number" min="0" name="txtNumCli" required>
	<p>DNI de cliente: </p>
	<input type="number" min="0" name="txtDNICli" required>
	<p>Seleccione el tipo de cuenta</p>
		<select name="opcTipo">
				<option value="CuentaCorriente" selected>Cuenta Corriente</option>
				<option value="CajaDeAhorro" selected>Caja De Ahorro</option>
		</select>
	<br>
	<p>Fecha: </p>
	<input type="date" name="fecha" required>
	<br>
	<p>CBU: </p>
	<input type="number" min="0" name="txtCBU" required>
	<br>
	<br>
	<input type="submit" class="btnAceptar" value="Aceptar" name="btnAltaCliente">
<br>
		<p class="textoCartel">Ingrese sus datos</p>

<%
int filas=0;
int verifi=0;
if(request.getAttribute("filasAfectadas")!=null){

	if((int)request.getAttribute("filasAfectadas")==1){
		%>
<p class="textoSinErrores">Cuenta agregada con éxito</p>		
<% 
	}
	
	if((int)request.getAttribute("filasAfectadas")==0){
		%>
		<p class="textoConErrores">Error. Existe Nro cuenta y/o NO existe DNI</p>		
		<% 
	}
	if((int)request.getAttribute("filasAfectadas")==2){
		%>
		<p class="textoConErrores">Error. Ya existe el CBU</p>		
		<% 
	}
	if((int)request.getAttribute("filasAfectadas")==3){
		%>
		<p class="textoConErrores">Error. Solo se puede asignar un máximo de 3 cuentas</p>		
		<% 
	}
	
}
		
		
	
		


%>


</div>

</form>
</body>
</html>