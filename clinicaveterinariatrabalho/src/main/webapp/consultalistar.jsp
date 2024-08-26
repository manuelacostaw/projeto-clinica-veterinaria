<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Consultas</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Valor</th>
            <th>Desconto</th>
        </tr>
        <c:forEach items="${consultas}" var="consulta">
            <tr>
                <td>${consulta.id}</td>
                <td>${consulta.tipo}</td>
                <td>${consulta.valor}</td>
                <td>${consulta.valorDesconto}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
