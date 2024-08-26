<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Tutor</title>
</head>
<body>
 <form action="/clinicaveterinariatrabalho/TutorAlterar" method="post">
        <input type="hidden" name="id" value="${idDoTutor}">
        Nome: <input type="text" name="nome" value="${nomeDoTutor}"> <br>
        Telefone: <input type="text" name="telefone" value="${telefoneDoTutor}"> <br>
        Email: <input type="text" name="email" value="${emailDoTutor}"> <br>
        <input type="submit" value="Salvar Alterações">
    </form>
</body>
</html>