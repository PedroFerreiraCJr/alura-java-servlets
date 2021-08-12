<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<c:if test="${not empty sessionScope.usuarioLogado}">
	<a href="${linkFrontController}?action=Logout" style="margin: 10px; float: right; clear: both; text-decoration: none">Sair</a>				
</c:if>
