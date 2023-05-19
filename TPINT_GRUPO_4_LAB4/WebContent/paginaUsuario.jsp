<%@page import="entidad.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
<link href='css\Cliente.css' rel='stylesheet'>
</head>
<body>
<%
	HttpSession sesion = request.getSession();
	Cliente usuario = null;
	
	if(sesion.getAttribute("user")!=null){
		usuario = (Cliente)sesion.getAttribute("user");
		out.print("<a href=login.jsp?cerrar=true'><h3>Cerrar Sesion "+ usuario.toString() +" </h3></a>");
		session.invalidate();
	}else{
		out.print("<script>location.replace('login.jsp');</script>");
		
	}
%>



<br>
<br>
	<h2>BIENVENIDO A LA PAGINA DE USUARIO</h2>
</body>
</html>