<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link rel="stylesheet" href="<spring:url value="/static/css/style.css" htmlEscape="true" />" type="text/css" />
	</head>
	<body>
	   	<h2>Login</h2>
	    <form:form id="login" modelAttribute="user" method="post">
	    	<fieldset>
		    	<form:errors path="username" cssClass="errorblock" element="div" />
				<form:input path="username" maxlength="32" placeholder="Username" autofocus="true" />
			    <form:errors path="password" cssClass="errorblock" element="div" />
			    <form:input path="password" type="password" placeholder="Password"/>
	    	</fieldset>
	    	<fieldset>
		    	<input name="submit" type="submit" value="Login">
		    	<a href="<spring:url value="register" htmlEscape="true" />">Register</a>
	    	</fieldset>
	    </form:form>
	</body>
</html>