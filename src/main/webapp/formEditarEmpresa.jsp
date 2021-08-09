<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%-- import de taglib core da lib jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkFrontController"/>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Página Principal</title>
	</head>
	<body>
		<form action="${linkFrontController}" method="POST">
			<input type="hidden" name="id" value="${requestScope.empresa.id}"/>
			<input type="hidden" name="action" value="AlteraEmpresa"/>
			
			<div>
				<label for="nome">Nome: </label>
				<input id="nome" type="text" name="nome" value="${requestScope.empresa.nome}">
			</div>
			
			<div>
				<label for="dataAbertura">Data Abertura: </label>
				<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" var="dataAberturaFormatada" />
				<input id="dataAbertura" type="text" name="data" value="${dataAberturaFormatada}">
			</div>
			
			<button type="submit">Atualizar</button>
		</form>
	</body>
</html>
