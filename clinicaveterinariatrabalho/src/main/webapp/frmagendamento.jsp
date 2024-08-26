<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Agendamento</title>
</head>
<body>
    <!-- adicionar um novo agendamento -->
    <form action="/clinicaveterinariatrabalho/AgendamentoAdd" method="post">
        <label>Data:</label>
        <input type="date" name="data" required><br>
        <label>Hora:</label>
        <input type="time" name="hora" required><br>
        <input type="submit">
        
    </form>

</body>
</html>