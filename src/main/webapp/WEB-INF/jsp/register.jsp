<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		<link rel="stylesheet" href="<spring:url value="/static/css/style.css" htmlEscape="true" />" type="text/css" />
	</head>
	<body>
		<h2>Register</h2>
		<form:form modelAttribute="user" method="post">
	    	<fieldset>
		    	<form:errors path="username" cssClass="errorblock" element="div" />
				<form:input path="username" maxlength="32" placeholder="Username" autofocus="true" />
				<form:errors path="password" cssClass="errorblock" element="div" />
			    <form:input path="password" type="password" placeholder="Password" />
			    <input name="password2" type="password" placeholder="Repeat password" />
		   	</fieldset>
	    	<fieldset>
			   	<input type="submit" value="Register"/>
			   	<a href="<spring:url value="login" htmlEscape="true" />">Login</a>
	    	</fieldset>
		</form:form>
	</body>
</html>