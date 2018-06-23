<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<h1>Home page - Exam6</h1>
	
	<a href="<c:url value='/user/1/tweets'/>">Find tweet by user id</a><br>
	<br>
	<a href="<c:url value='/user/search-tweets/tw?'/>">Find tweet by title</a><br>
	<br>
	<a href="<c:url value='/user/add'/>">Add new user</a><br>
	<br>
	<a href="<c:url value='/tweet/add'/>">Add new tweet</a><br>
	<br>
	<a href="<c:url value='/user/all'/>">All users</a><br>
	
</body>
</html>
