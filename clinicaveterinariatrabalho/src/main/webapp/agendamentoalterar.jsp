<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Agendamento</title>
</head>
<body>
<form action="/clinicaveterinariatrabalho/AgendamentoAlterar" method="post">
        <label>ID do Agendamento a Alterar:</label>
        <input type="text" name="id" required><br>
        <label>Nova Data:</label>
        <input type="date" name="data" required><br>
        <label>Nova Hora:</label>
        <input type="time" name="hora" required><br>
        <input type="submit" value="Editar">
    </form>
</body>
</html>