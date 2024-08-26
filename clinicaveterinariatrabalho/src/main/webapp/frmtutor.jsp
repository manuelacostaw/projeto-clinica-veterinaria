<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Tutor</title>
</head>
<body>
	<form action="/clinicaveterinariatrabalho/TutorAdd" method="post">
	 	Nome: <input type="text" name="nome" required> <br>
        Telefone: <input type="text" name="telefone" required> <br>
        Endereço: <input type="text" name="endereco" required> <br>
        <input type="submit" value="Registrar">
	</form>
</body>
</html>