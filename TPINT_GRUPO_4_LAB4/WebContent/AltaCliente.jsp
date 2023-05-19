<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="entidad.Provincia"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>       
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

 <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<title>Alta Cliente</title>
</head>

<body>





<%
	Cliente cli = new Cliente();
	if(request.getAttribute("Cliente")!=null)
		cli = (Cliente)request.getAttribute("Cliente");

%>

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

<div style="margin-left:auto;margin-right:auto;">
	
	<form action="servletCliente" method="post">
	<table class="styled-table" >
		<thead>
		<tr>
			<td colspan="2">
                    <h2 class="text-center" style="font-weight: bold">Agregar Cliente</h2>
			
			</td>
		</tr>
			<tr>
				<td>Dni</td>
				<td><input type="number" min="0" name="txtDni"  required/></td>
			</tr>
			<tr>
				<td>Cuil</td>
				<td><input type="number" min="0" name="txtCuil" required/></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="txtNombre" required/></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" name="txtApellido" required/></td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td><select name="ddlSexo" required>
					<option value="Masculino" selected>Masculino</option>
					<option value="Femenino" selected>Femenino</option>
				</select></td>
			</tr>
			<tr>
				<td>Nacionalidad</td>
				<td><input type="text" name="txtNacionalidad" required/></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento</td>
				<td><input type="text" name="FechaNacimiento" placeholder="AAAA-MM-DD" required></td>	
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text"  name="txtDireccion" required/></td>
			</tr>
			
			<tr>
				<td>Provincia</td>
				<td>
			<%
				ArrayList<Provincia> listaProvincias = null;
				
			if(request.getAttribute("ListaProvincias")!=null){
				listaProvincias = (ArrayList<Provincia>) request.getAttribute("ListaProvincias");
				
					if(listaProvincias != null){
			%>


					<select name="ddlProvincia" id="provincia">
			<% 	
						
						for (Provincia p : listaProvincias) {
			%>			
						<option value="<%=p.getNombre()%>"><%=p.getNombre() %></option>
								
			<%				}
		

							%>
					</select>
				<% 	
					}
					
				}
				%>
				</td>
			</tr>
			<tr>
				<td>Localidad</td>
				<td><input type="text" name="txtLocalidad" required/></td>
			</tr>
			<tr>
			<tr>
				<td>Correo Electronico</td>
				<td><input type="text" name="txtCorreoElectronico" required/></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="number" min="1" name="txtTelefono" required/></td>
			</tr>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="txtUsuario" required/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="txtPassword" required/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="agregarCliente" class="btn btn-primary" value="agregar"></td>
				
			</tr>
			<tr>
					<td colspan="2">
					<%
						boolean agregado;
						if(request.getAttribute("exito")!=null){
							agregado = (boolean)request.getAttribute("exito");
							if(agregado){
						%>	<div class="alert alert-success" role="alert">
							  El Cliente ha sido agregado con Exito!
							</div>	
						<% 		
							}else{
								%>
									<div class="alert alert-danger" role="alert">
									  ERROR! NO se pudo agregar el Cliente
									</div>
								<%
							}
						
						}
					%>
					<%
					
						if(request.getAttribute("MensajeDni")!=null){
						String mensajeDni=(String)request.getAttribute("MensajeDni");
						%>	<div class="alert alert-danger" role="alert">
						<%=mensajeDni%>
							</div>	
						<% 		
						}
					%>
					
					<%
						if(request.getAttribute("MensajeCuil")!=null){
						String mensajeCuil=(String)request.getAttribute("MensajeCuil");
						%>	<div class="alert alert-danger" role="alert">
						<%=mensajeCuil%>
							</div>	
						<% 		
						}
					%>
					
					<%
						if(request.getAttribute("MensajeUsuario")!=null){
						String mensajeUsuario=(String)request.getAttribute("MensajeUsuario");
						%>	<div class="alert alert-danger" role="alert">
						<%=mensajeUsuario%>
							</div>	
						<% 		
						}
					%>
				</td>
									
			</tr>
			<tr>

			</tr>
			
		</thead>
	</table>
		</form>
	</div>





	
	
	

</body>
</html>