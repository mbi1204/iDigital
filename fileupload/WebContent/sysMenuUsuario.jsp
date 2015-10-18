<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%-- <jsp:forward page="/ctCompaniaCtrl?action=list" /> --%>
<a href="ctCompaniaCtrl?action=list">Compañias</a>	
		 
<a href = "ctMenuCtrl?action=list" >Menu</a>

<a href = "ctPuestoCtrl?action=list" >Puesto</a>

<a href = "ctProgramaCtrl?action=list" >Programa</a>

<a href = "ctEmisorCtrl?action=list" >Emisor</a>

<a href = "ctUsuarioCtrl?action=list" >Usuario</a>

</body>
</html>