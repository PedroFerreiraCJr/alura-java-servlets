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
			<input type="hidden" name="action" value="Login"/>
			
			<div>
				<label for="nome">Login: </label>
				<input id="nome" type="text" name="login">
			</div>
			
			<div>
				<label for="dataAbertura">Senha: </label>
				<input id="dataAbertura" type="password" name="senha">
			</div>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
