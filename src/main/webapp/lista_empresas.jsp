<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="rotaRm" />
<c:url value="/mostraEmpresa" var="rotaSw" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><%= (String) request.getAttribute("pageTitle") %></title>
	</head>
	<body>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					<fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy" /> - 
					${empresa.nome}
					<a href="${rotaSw}?id=${empresa.id}">Editar</a>
					<a href="${rotaRm}?id=${empresa.id}">Excluir</a>
				</li>
			</c:forEach>
		</ul>
		<hr />
		<ul>
		<% List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas"); %>
		<% for (Empresa empresa : lista) { %>
			<li><%= empresa.getNome() %></li>
		<% } %>
		</ul>
	</body>
</html>