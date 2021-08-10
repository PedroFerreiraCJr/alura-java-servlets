<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%-- import de taglib core da lib jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Página Principal</title>
	</head>
	<body>
		<%--
			requestScope é um objeto implícito das páginas JSP que possibilita o acesso a atributos
			pendurados na requisição através do método setAttribute da classe HttpServletRequest.
		 --%>
		 	<c:if test="${not empty requestScope.message}">
		 		<p style="color: #ff0000;">Mensagem de Erro - ${requestScope.message}</p>
		 	</c:if>
		 	
			<c:if test="${not empty requestScope.empresa}">
				<p>Empresa ${requestScope.empresa} cadastrada com sucesso!</p>
			</c:if>
			
			<c:if test="${empty requestScope.empresa and empty requestScope.message}">
				<p>Nenhuma empresa cadastrada</p>
			</c:if>
	</body>
</html>
