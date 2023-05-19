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
<link href='css\Recuadro.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
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
<br>

<div class="box2">
<label class="letracambio">TRANSFERENCIAS</label>
<br>
<br>
<%
if(request.getAttribute("Mensaje")!=null){
	%>
	<label class="textoConErrores"><%=request.getAttribute("Mensaje")%></label>
	<%
}


%>
</div>
<br>
<br>

<%
List<Cuenta> listaNroCuentas=null;
if(request.getAttribute("ListaNroCuentas")!=null){
	listaNroCuentas=((List<Cuenta>)request.getAttribute("ListaNroCuentas"));
}
%>

<form action="servletCuenta" method="post">
<div class="box">
<h1>Transferir dinero</h1>
<div class="center">
<label for="lblNroCuentaTransferencia">Nro.Cuenta</label>

<select name="CuentasTransferencia">
<%
if(listaNroCuentas!=null)
	for(Cuenta user:listaNroCuentas){
%>


<option><%=user.getNroCuenta() %></option>


<%} %>
</select>
<br>
<br>
<label for="lblCBU">CBU:</label>
<input type="number" min="0" name="txtCBU" required>
<br>
<br>
<label for="lblImporteTransferencia">Importe $:</label>
<input type="number" step="0.01" min="0" name="txtImporteTransferencia" required>
<br>
<br>
<label for="lblFechaTransferir">Fecha de transferencia:</label>
<input type="date" name="FechaTransferencia" required>
<br>
<br>
<input type="submit" name="btnTransferir" value="Transferencia" class="button-7">
<br>

</div>
</div>



</form>



</body>
</html>