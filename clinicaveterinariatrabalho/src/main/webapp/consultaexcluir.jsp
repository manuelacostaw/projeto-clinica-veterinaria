<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Consulta</title>
</head>
<body>
<form action="/clinicaveterinariatrabalho/ConsultaExcluir" method="post">
    <input type="hidden" name="id" value="${idDaConsulta}">
    <label>ID da Consulta a Excluir:</label>
    <input type="text" name="consultaId" value="${idDaConsulta}" required readonly><br>
    <input type="submit" value="Excluir">
</form>
</body>
</html>