<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Error</title>
		<link rel="stylesheet" href="<spring:url value="/static/css/style.css" htmlEscape="true" />" type="text/css" />
	</head>
	<body>
		<h2>${errorMessage}</h2>
		<ul>
			<li><a href="<spring:url value="login" htmlEscape="true" />">Login</a></li>
			<li><a href="<spring:url value="register" htmlEscape="true" />">Register</a></li>
			<li><a href="<spring:url value="helloWorld" htmlEscape="true" />">HelloWorld</a></li>
		</ul>
	</body>
</html>