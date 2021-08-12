<%-- Diretivas de JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- import de taglib core da lib jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkFrontController"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listagem de Empresas</title>
	</head>
	<body>
		<c:import url="./logout-fragment.jsp" />
		<br>
		<p>Usuário Logado: ${sessionScope.usuarioLogado.login}</p>
		<br>		
		<h2>Lista de Empresas Cadastradas</h2>
		
	 	<c:if test="${not empty requestScope.message}">
 			<p style="color: #00ff00;">${requestScope.message}</p>
	 	</c:if>
		
		<ul>
			<c:forEach items="${list}" var="empresa">
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="${linkFrontController}?action=MostraEmpresa&id=${empresa.id}">editar</a>
					<a href="${linkFrontController}?action=RemoveEmpresa&id=${empresa.id}">remover</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>
