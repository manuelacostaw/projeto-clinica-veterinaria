<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Agendamento</title>
</head>
<body>
 <form action="/clinicaveterinariatrabalho/AgendamentoExcluir" method="post">
        <label>ID do Agendamento a Excluir:</label>
        <input type="text" name="id" required><br>
        <input type="submit" value="Excluir">
    </form>
</body>
</html>