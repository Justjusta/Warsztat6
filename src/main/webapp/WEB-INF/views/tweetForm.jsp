<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Tweet</title>
</head>
<body>
	<form:form method="post" modelAttribute="tweet">
		<form:hidden path="id" placeholder="Id" />

		<label>Title:</label>
		<form:input path="title" placeholder="title" />
		<form:errors path="title" />

		<label>Tweet text:</label>
		<form:input path="tweetText" placeholder="tweetText" />
		<form:errors path="tweetText" />

		<label>Users</label>
		<form:select itemLabel="lastName" itemValue="id" path="user.id"
			items="${users}" />
		<form:errors path="user" />
		<br />

		<input type="submit" value="Save" />
	</form:form>
	<br>
	<a href="<c:url value='/home'/>"> Back to home page </a>


</body>
</html>
