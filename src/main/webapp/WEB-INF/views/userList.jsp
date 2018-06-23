<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of users</title>
</head>
<body>
	<h1>Users</h1>
	<table border=1>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td><a href="<c:url value="/user/${user.id}/delete"/>">Delete
				</a> <a href="<c:url value="/user/${user.id}/edit"/>">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value='/home'/>"> Back to home page </a>

</body>
</html>