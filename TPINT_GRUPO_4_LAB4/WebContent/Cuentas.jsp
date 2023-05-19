<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href='css\Botones.css' rel='stylesheet'>
	<link href='css\FondoPantalla.css' rel='stylesheet'>
	<link href='css\tabla.css' rel='stylesheet'>
	<link href='css\menu.css' rel='stylesheet'>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cuentas</title>
</head>
	<title>Insert title here</title>
</head>
<body>
<nav>
	<div class="menu"> 
	    <ul class="menup"> 
	        <li class="divider"></li> 
	        <li><a href="ListarHistorialCuenta.jsp">Historial Cuenta</a> </li>
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="Transferencias.jsp">Transferencias</a></li>
	        <li class="divider"></li>  
	        <li class="divider"></li>   
	        <li class="divider"></li>
	        <li><a href="PedidosPrestamos.jsp">Pedidos Prestamos</a></li>
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
<div>

<table class="styled-table">
	<thead>
		<tr>
			<th>nro. de cuenta</th>
			<th>tipo</th>
			<th>CBU</th>
			<th>saldo</th>
			<th>Historial</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>66532</td>
			<td>caja de ahorro</td>
			<td>00022225556669888</td>
			<td>10000</td>
			<td><span class="btn-ver"><a href="ListarHistorialCuenta.jsp">ver</a></span></td>
		</tr>
		<tr>
			<td>66532</td>
			<td>caja de ahorro</td>
			<td>00022225556669888</td>
			<td>10000</td>
			<td><span class="btn-ver"><a href="ListarHistorialCuenta.jsp">ver</a></span></td>
		</tr>
		<tr>
			<td>66532</td>
			<td>caja de ahorro</td>
			<td>00022225556669888</td>
			<td>10000</td>
			<td><span class="btn-ver"><a href="ListarHistorialCuenta.jsp">ver</a></span></td>
		</tr>
	</tbody>
</table>

</div>

</body>
</html>