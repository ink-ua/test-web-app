<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hello, world</title>
		<link rel="stylesheet" href="<spring:url value="/static/css/style.css" htmlEscape="true" />" type="text/css" />
	</head>
	<body>
		<h2>Hello, ${username}!</h2>
		<a href="<spring:url value="logout" htmlEscape="true" />">Logout</a>
	</body>
</html>
