<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="daoImpl.DaoCuentaImpl"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\Cuenta.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<link href='css\Recuadro.css' rel='stylesheet'>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listar Cuentas</title>
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
<br>
<form action="servletCuenta" method="post">
<div class="box2">
<label class="letracambio">LISTAR CUENTAS</label>
<br>
<label class="letracambio">Fecha desde: </label>
<input type="date" name="FechaDesde">
<br>
<label class="letracambio">Fecha hasta: </label>
<input type="date" name="FechaHasta">
<br>
<input type="submit" name="btnMostrarTodo" value="Mostrar todo" class="button-7">&nbsp;&nbsp;<input type="submit" name="btnFiltrar" value="Filtrar" class="button-7">
<br>
<%
if(request.getAttribute("Mensaje")!=null){
	%>
	<label class="textoConErrores"><%=request.getAttribute("Mensaje")%></label>
	<%
}


%>
</div>
</form>

<%
List<Cuenta> listaCuentas=null;
if(request.getAttribute("ListaCuentas")!=null){
	listaCuentas=((List<Cuenta>)request.getAttribute("ListaCuentas"));
}
%>
<div style="margin-top: 10px;padding: 5px;background-color:#75baff;">
<table id="tablax" class="content-table">
<thead>
<tr><th>Nro. de cuenta</th><th>DNI</th><th>Fecha Creacion</th><th>Tipo</th><th>CBU</th><th>Saldo</th></tr>
</thead>
<tbody>
<%
if(listaCuentas!=null)
	for(Cuenta user:listaCuentas){
%>
<tr>
<td><%=user.getNroCuenta()%></td>
<td><%=user.getDNI()%></td>
<td><%=user.getFechaCreacion()%></td>
<td><%=user.getTipoCuenta()%></td>
<td><%=user.getCBU()%></td>
<td><%=user.getSaldo() %></td>
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