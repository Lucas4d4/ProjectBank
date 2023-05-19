<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@page import="entidad.Cliente"%>
<%@page import="java.util.List" %>
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
<title>Baja Cliente</title>
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

<%
List<Cliente> listaClientes=null;
if(request.getAttribute("ListaClientesB")!=null){
	listaClientes=((List<Cliente>)request.getAttribute("ListaClientesB"));
}
%>
<div style="margin-top: 10px;padding: 5px;background-color:#75baff; font-size:12px;">
<table id="tablax" class="content-table">
<thead>
<tr>
<th>DNI del Cliente</th>
<th>Nombre</th>
<th>Apellido</th>
<th>Sexo</th>
<th>Nacionalidad</th>
<th>Fecha de Nacimiento</th>
<th>Dirección</th>
<th>Localidad</th>
<th>Provincia del Cliente</th>
<th>Correo</th>
<th>Telefono</th>
<th>Usuario</th>
<th>Password</th>
<th>Eliminar</th>
</tr>
</thead>
<tbody>
<%
if(listaClientes!=null)
	for(Cliente user:listaClientes){
%>
<tr>
<form action="servletCliente?ParamBaja2=<%=user.getDni()%>" method="get">
<td><%=user.getDni()%> <input type="hidden" name="ParamBaja2" value="<%=user.getDni()%>"></td>
<td><%=user.getNombre()%></td>
<td><%=user.getApellido()%></td>
<td><%=user.getSexo()%></td>
<td><%=user.getNacionalidad() %></td>
<td><%=user.getFechaNacimiento() %></td>
<td><%=user.getDireccion() %></td>
<td><%=user.getLocalidad() %></td>
<td><%=user.getProvincia() %></td>
<td><%=user.getMail() %></td>
<td><%=user.getTelefono() %></td>
<td><%=user.getUsuario()%></td>
<td><%=user.getPassword()%></td>
<td><input type="submit" name="btnBajasCliente" value="Eliminar" class='button-9'></td>
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