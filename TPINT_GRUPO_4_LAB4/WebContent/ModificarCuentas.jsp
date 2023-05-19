<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
    <%@ page import="entidad.Cuenta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<title>Insert title here</title>
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
<%
List<Cuenta> listaCuentas=null;
if(request.getAttribute("ListaCuentas")!=null){
	listaCuentas=((List<Cuenta>)request.getAttribute("ListaCuentas"));
}
%>
<div style="margin-top: 10px;padding: 5px;background-color:#75baff;">
<table id="tablax" class="styled-table">
	<thead>
		<tr>
			<th>Nro. de cuenta</th>
			<th>Tipo de cuenta Actual</th>
			<th>Modificar Tipo de cuenta</th>
			<th>CBU</th>
			<th>Saldo Actual</th>
			<th>Modificar Saldo</th>
			<th>Modificar</th>
		</tr>
	</thead>
	<tbody>
	<%
if(listaCuentas!=null)
	for(Cuenta user:listaCuentas){
%>
		<tr><form action="servletCuenta?NroCuentaModificar=<%=user.getNroCuenta() %>" method="get">
<td><%=user.getNroCuenta()%> <input type="hidden" name="NroCuentaModificar" value="<%=user.getNroCuenta()%>"></td>
<td><%=user.getTipoCuenta() %></td>
<td><select name="opcTipo">
				<option value="CuentaCorriente" selected>Cuenta Corriente</option>
				<option value="CajaDeAhorro" selected>Caja De Ahorro</option>
		</select></td>
<td><%=user.getCBU()%></td>
<td><%=user.getSaldo() %></td>
<td><input type="number" step="0.01" min="0" name="txtSaldoModificar" required></td>
    <td><input type="submit" class="button-7" name="btnModificarCuenta" value="Modificar"></td>
    </form></tr> 
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