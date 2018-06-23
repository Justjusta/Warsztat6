<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Tweet List</title>
</head>
<body>
	<h1>List of tweets</h1>
	<br> Change parameter in address <br>
	<br>
	<table border=1>
		<tr>
			<th>Title</th>
			<th>Tweet text</th>
			<th>Created</th>
			<th>User</th>
		</tr>
		<c:forEach items="${tweets}" var="tweet">
			<tr>
				<td>${tweet.title}</td>
				<td>${tweet.tweetText}</td>
				<td>${tweet.created}</td>
				<td>${tweet.user.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value='/home'/>"> Back to home page </a>

</body>
</html>