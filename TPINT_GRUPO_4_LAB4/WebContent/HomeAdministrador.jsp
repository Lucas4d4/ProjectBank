<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page session="true"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME ADMINISTRADOR</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
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
</body>
</html>
