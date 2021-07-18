<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="rota" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><%= (String) request.getAttribute("pageTitle") %></title>
	</head>
	<body>
		<h1>${usuarioLogado.login}</h1>
		<c:import url="logout_parcial.jsp" />
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					<fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy" /> - 
					${empresa.nome}
					<a href="${rota}?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
					<a href="${rota}?acao=RemoveEmpresa&id=${empresa.id}">Excluir</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>