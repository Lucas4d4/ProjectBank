<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href='css\Login.css' rel='stylesheet'>
<title>Iniciar Sesion</title>
</head>


<body>
	<div class="container mt-4 col-lg-4">
		<div class="card col-sm-10">
			<div class="card-body text-center">
				<form class="form-sing" action="servetLogin" method="post">
					<div class="form-group">
					<h3>Login</h3>
	<!-- 				<img src="" alt="70" width="170"/> -->
					<label>Bienvenido al Banco</label>
					</div>
					<div class="form-group text-center">
						<label>Usuario:</label>
						<input type="text" name="txtusuario" class="form-control">
					</div>
					<div class="form-group text-center">
						<label>Password:</label>
						<input type="password" name="txtpassword" class="form-control">
					</div>
					<input type="submit" name="loguear" value="Ingresar" class="btn btn-primary">
					</form>
					
					<%
					String resultado = (String) request.getAttribute("mensaje");
					String mensaje = "";
					if(resultado!=null){
						mensaje = resultado;
					}
	
					%>
					
					<%=mensaje %>
					
		</div>
	</div>
	</div>
</body>

</html>
