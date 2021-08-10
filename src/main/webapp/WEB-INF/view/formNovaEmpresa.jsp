<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%-- import de taglib core da lib jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkFrontController"/>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Página Principal</title>
	</head>
	<body>
		<form action="${linkFrontController}" method="POST">
			<input type="hidden" name="action" value="NovaEmpresa"/>
			
			<div>
				<label for="nome">Nome: </label>
				<input id="nome" type="text" name="nome">
			</div>
			
			<div>
				<label for="dataAbertura">Data Abertura: </label>
				<input id="dataAbertura" type="text" name="data">
			</div>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
