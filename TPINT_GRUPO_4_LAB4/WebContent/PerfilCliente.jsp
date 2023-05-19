<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ page import="java.util.List" %>
        <%@page import="entidad.Cliente"%>
        <%@page import="entidad.Cuenta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
</head>
<body>

    <%
	HttpSession sesion = request.getSession();
	String usuario = null;
	Cliente cliente=null;
	if(sesion.getAttribute("user")!=null){
		usuario = sesion.getAttribute("user").toString();
		cliente=(Cliente)sesion.getAttribute("user");
		%>
		<div class="derechas">
			<div class="btn-group" role="group" aria-label="Basic example">
			<form action="PerfilCliente.jsp" method="post">
			<input type="submit" name="btnPerfil" value="Usuario:<%=cliente.getUsuario()%>" class='btnIngresars'>
			</form>
			  <form action="servletLogout" method="post">
			  <input type="submit" class="btnSalir" name="salir" value="Salir" >
				</form>
			</div>
		</div>
		

	<%
	
	}
%>

<nav>
	<div class="menu"> 
	    <ul class="menup"> 
	        <li class="divider"></li> 
	 	        <li><a href="servletCuenta?Param7=<%=cliente.getDni()%>">Historial Cuenta</a> </li>
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="servletCuenta?Param4=<%=cliente.getDni()%>">Transferencias</a></li>
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="servletPrestamo?Param5=<%=cliente.getDni()%>">Pedidos Prestamos</a></li>
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="PagoPrestamos.jsp">Pago Prestamos</a></li>	        
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="PerfilCliente.jsp">Perfil Cliente</a></li>	 	      
	</div>
</nav>

<br>
	
<div style="margin-left:auto;margin-right:auto;">
	<table class="styled-table" >
	<thead>
	<tr>
			<td colspan="2">
                    <h2 class="text-center" style="font-weight: bold">Perfil Cliente</h2>
			</td>
		</tr>
			<tr>
				<td>Dni:</td>
				<td><label><%=cliente.getDni() %></label></td>
			<tr>
			</tr>
				<td>Cuil:</td>
				<td><label><%=cliente.getCuil_c() %></label></td>
			<tr>
			</tr>
				<td>Nombre:</td>
				<td><label><%=cliente.getNombre() %></label></td>
			<tr>
			</tr>
				<td>Apellido:</td>
				<td><label><%=cliente.getApellido() %></label></td>
			<tr>
			</tr>
				<td>Sexo:</td>
				<td><label><%=cliente.getSexo() %></label></td>
			<tr>
			</tr>
				<td>Nacionalidad:</td>
				<td><label><%=cliente.getNacionalidad() %></label></td>
			<tr>
			</tr>
				<td>Fecha de Nacimiento:</td>
				<td><label><%=cliente.getFechaNacimiento() %></label></td>	
			<tr>
			</tr>
				<td>Direccion:</td>
				<td><label><%=cliente.getDireccion() %></label></td>
			<tr>
			</tr>
				<td>Localidad:</td>
				<td><label><%=cliente.getLocalidad() %></label></td>
			<tr>
			</tr>
				<td>Provincia:</td>
				<td><label><%=cliente.getProvincia() %></label></td>
			<tr>
			</tr>
				<td>Correo Electronico:</td>
				<td><label><%=cliente.getMail() %></label></td>
			<tr>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><label><%=cliente.getTelefono() %></label></td>
			</tr>
		</thead>
	</table>
	</div>
	

</body>
</html>