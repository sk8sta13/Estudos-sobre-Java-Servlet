<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="rota" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${rota}" method="post">
		<input type="hidden" name="acao" value="Login" />
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" />
		<input type="submit" />
	</form>
</body>
</html>