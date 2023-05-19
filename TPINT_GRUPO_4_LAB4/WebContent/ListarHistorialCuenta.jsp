<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
        <%@page import="entidad.Cliente"%>
        <%@page import="entidad.Movimiento"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
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



<%
List<Movimiento> listaMovimientos=null;
if(request.getAttribute("ListaMovimientos")!=null){
	listaMovimientos=((List<Movimiento>)request.getAttribute("ListaMovimientos"));
}
%>

<div style="margin-top: 10px;padding: 5px;background-color:#75baff;">
<table id="tablax" class="content-table">
<thead>
<tr><th>Nro. de Movimiento</th><th>Nro. de Cuenta</th><th>Fecha Movimiento</th><th>Detalle Movimiento</th><th>Tipo Movimiento</th><th>Importe Movimiento</th><th>Estado Movimiento</th></tr>
</thead>
<tbody>
<%
if(listaMovimientos!=null)
	for(Movimiento user:listaMovimientos){
%>
<form action="serverCuenta" method="post">
<tr>
<td><%=user.getNroMovimiento()%> </td>
<td><%=user.getNroCuentaM()%></td>
<td><%=user.getFechaMovimiento()%></td>
<td><%=user.getDetalleMovimiento() %></td>
<td><%=user.getTipoMovimiento() %></td>
<td><%=user.getImporteMovimiento() %></td>
<td><%=user.isEstadoMovimiento() %></td>
</form>
  </tr> 
<%}%>
</tbody>
</table>
</div>

<!-- JQUERY -->
    <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        </script>
    <!-- DATATABLES -->
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
    </script>
    <!-- BOOTSTRAP -->
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
    </script>
    <script>
        $(document).ready(function () {
            $('#tablax').DataTable({
                language: {
                    processing: "Tratamiento en curso...",
                    search: "Buscar&nbsp;:",
                    lengthMenu: "Agrupar de _MENU_ items",
                    info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                    infoEmpty: "No existen datos.",
                    infoFiltered: "(filtrado de _MAX_ elementos en total)",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron datos con tu busqueda",
                    emptyTable: "No hay datos disponibles en la tabla.",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                    aria: {
                        sortAscending: ": active para ordenar la columna en orden ascendente",
                        sortDescending: ": active para ordenar la columna en orden descendente"
                    }
                },
                scrollY: 400,
                lengthMenu: [ [10, 25, -1], [10, 25, "All"] ],
            });
        });
    </script>



</body>
</html>