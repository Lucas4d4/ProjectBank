<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="daoImpl.DaoPrestamoImpl"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Prestamo"%>
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
<link href='css\menu.css' rel='stylesheet'>
<link href='css\FondoPantalla.css' rel='stylesheet'>
<link href='css\tabla.css' rel='stylesheet'>
<link href='css\Botones.css' rel='stylesheet'>
<link href='css\Recuadro.css' rel='stylesheet'>
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
<div class="box2">
<label class="letracambio">AUTORIZAR/RECHAZAR PRESTAMOS</label>
<%
if(request.getAttribute("MensajeError")!=null){
	%>
	<label class="textoConErrores"><%=request.getAttribute("MensajeError") %></label>
	<%
}
%>
</div>

<%
List<Prestamo> listaPrestamos=null;
if(request.getAttribute("ListaPedidosPrestamos")!=null){
	listaPrestamos=((List<Prestamo>)request.getAttribute("ListaPedidosPrestamos"));
}
%>
<div style="margin-top: 10px;padding: 5px;background-color:#75baff;">
<table id="tablax" class="content-table">
<thead>
<tr><th>Nro. pedido</th><th>Nro. Cuenta</th><th>Importe Pedido</th><th>Cant. Cuotas</th><th>Fecha Vencimiento</th><th>Intereses</th><th>Plazos pago</th><th>Monto por mes</th><th>Autorizar/Rechazar</th></tr>
</thead>
<tbody>
<%
if(listaPrestamos!=null)
	for(Prestamo user:listaPrestamos){

%>
<tr><form action="servletPrestamo?NroPedido=<%=user.getNroPrestamo() %>" method="get">
<td><%=user.getNroPrestamo()%> <input type="hidden" name="NroPedido" value="<%=user.getNroPrestamo()%>"></td>
<td><%=user.getNroCuenta_P() %></td>
<td><%=user.getImporteSolicitado() %></td>
<td><%=user.getCuotas() %></td>
<td><input type="date" name="FechaVencimiento" id="FechaVV"></td>
<td><input type="number" step="0.01" min="0" name="txtIntereses" id="Intereses"></td>
<td><input type="number" min="0" name="txtPlazos" id="Plazos"></td>
<td><input type="number" step="0.01" min="0" name="txtMontoMes" id="Mes"></td>

    <td>  <input  type="submit"  class="button-7" name="btnAutorizar" value="Autorizar">&nbsp;&nbsp;<input type="submit"  class="button-9" name="btnRechazar" value="Rechazar"></td>
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