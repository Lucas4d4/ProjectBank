<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="entidad.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HTML Elements Reference</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<link href='css\Recuadro.css' rel='stylesheet'>
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
	        <li><a href="servletPrestamo?Param6=<%=cliente.getDni()%>">Pago Prestamos</a></li>	 
<!-- 	        <li><a href="PagoPrestamos.jsp">Pago Prestamos</a></li>	         -->
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="PerfilCliente.jsp">Perfil Cliente</a></li>	      
	</div>
</nav>



<br>
<br>
<br>
<br>
<div class="box">
<h1>BANCO.com</h1>
<p class="centrado12">Sistema de gestión de banco para solicitar préstamos, pagar préstamos, realizar transferencias y mostrar el historial de tus cuentas</p>
</div>

</body>
</html>