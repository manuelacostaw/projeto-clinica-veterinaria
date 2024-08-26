<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Agendamentos</title>
</head>
<body>
	<!-- Tabela p listar agendamentos -->
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Data</th>
                <th>Hora</th>
            </tr>
        </thead>
        <tbody>
            <!-- loop p exibir agendamentos -->
            <c:forEach items="${agendamentos}" var="agendamento">
                <tr>
                    <td>${agendamento.id}</td>
                    <td>${agendamento.data}</td>
                    <td>${agendamento.hora}</td>
                </tr>
            </c:forEach>
</tbody>
    </table>
</body>
</html>