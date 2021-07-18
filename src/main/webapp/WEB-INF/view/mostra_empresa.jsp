<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="rota" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editar</title>
	</head>
	<body>
		<c:import url="logout_parcial.jsp" />
		<form action="${rota}" method="post">
			<input type="hidden" name="acao" value="EditaEmpresa" />
			<input type="hidden" name="id" value="${empresa.id}" />
			Nome: <input type="text" name="nome" value="${empresa.nome}" />
			Data: <input type="text" name="data" value="<fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy" />" />
			<input type="submit" />
		</form>
	</body>
</html>