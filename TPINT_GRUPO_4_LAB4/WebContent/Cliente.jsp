<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	 <!-- Bootstrap CSS -->
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
        
        
        <script type="text/javascript">
        	$(document).ready( function () {
        		$('#table_id').DataTable();
        	});
        </script>
        
<link href='css\menu.css' rel='stylesheet'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>      
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"> 
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
   <script type="text/javascript">
        	$(document).ready( function () {
        		$('#table_id').DataTable();
        	});
        </script>     
</head>
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<body>

<div>




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
<br>

</div>

	<div class="form-group">
			<form method="post" action="servletCliente">
				<div><input style=" height:33px; width:30%; float:right" placeholder="Ingrese Nombre"  type="text" name="txtbuscar"> </div>
				<input style=" height:33px; width:10%; float:right;" class="btnClick" type="submit" name="btnBuscar" value="buscar">
			</form>
	</div>
	
<br>
<br>

<%
	List<Cliente> listaClientes = null;
	if(request.getAttribute("ListaClientesB")!=null){
		listaClientes = (List<Cliente>) request.getAttribute("ListaClientesB");
	}
	
%>

<div style="width:100%; height:150px " class="center">
	<table id="table_id" class="table table-success table-striped">
		<thead>
			<tr>
				<th>DNI</th>
				<th>CUIL</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Sexo</th>
				<th>Nacionalidad</th>
				<th>Fecha de<br>nacimiento</th>
				<th>Dirección</th>
				<th>Localidad</th>
				<th>Provincia</th>
				<th>Correo</th>
				<th>Teléfono</th>
				<th>Estado</th>
			</tr>
		</thead>
		

			<% 	
					if(listaClientes!=null)
					for(Cliente cli : listaClientes)
					{
			%>
			
	<tr>
			<form action="servletCliente" method="post">
				
				<td><%= cli.getDni() %> <input type="hidden" name="dnicliente" value="<%= cli.getDni() %>"> </td>
				<td><%= cli.getCuil_c() %></td>
				<td><%= cli.getNombre() %></td>
				<td><%= cli.getApellido() %></td>
				<td><%= cli.getSexo()%></td>
				<td><%= cli.getNacionalidad()%></td>
				<td><%= cli.getFechaNacimiento()%></td>
				<td><%= cli.getDireccion()%></td>
				<td><%= cli.getLocalidad()%></td>
				<td><%= cli.getProvincia()%></td>
				<td><%= cli.getMail()%></td>
				<td><%= cli.getTelefono()%></td>
				<td><%= cli.getEstado() %></td>
<%-- 				<td><a class="btn btn-warning" href="ModificarCliente.jsp?dni=<%= cli.getDni() %>">Editar</a><a class="btn btn-danger" href="BajaCliente.jsp?dni=<%= cli.getDni() %>">Eliminar</a></td> --%>

			</form>
			
	</tr>
			<%  } %>
	
	</table>
</div>

<div>
<br />
	
	
</div>



</body>
</html>
