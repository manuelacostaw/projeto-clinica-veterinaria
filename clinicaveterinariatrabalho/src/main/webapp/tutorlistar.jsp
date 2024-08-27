<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Tutores</title>
</head>
<body>
        <c:forEach items="${tutores}" var="tutor">
            <tr>
                <td>${tutor.id}</td>
                <td>${tutor.nome}</td>
                <td>${tutor.telefone}</td>
                <td>${tutor.endereco}</td>
                <label>teste</label>
            </tr>
        </c:forEach>
</body>
</html>