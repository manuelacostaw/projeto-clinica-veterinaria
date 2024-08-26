<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Consulta</title>
</head>
<body>
 <form action="/clinicaveterinariatrabalho/ConsultaAlterar" method="post">
        <input type="hidden" name="id" value="${idDaConsulta}">
        Tipo: <input type="text" name="tipo" value="${tipoDaConsulta}"> <br>
        Valor: <input type="text" name="valor" value="${valorDaConsulta}"> <br>
        Desconto: <input type="text" name="desconto" value="${descontoDaConsulta}"> <br>
        <input type="submit" value="Salvar Alterações">
    </form>
</body>
</html>