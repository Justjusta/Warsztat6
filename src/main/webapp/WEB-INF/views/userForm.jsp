<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>User</title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
	
		<label>First Name:</label>
		<form:input path="firstName" placeholder="firstName" />
		<form:errors path="firstName" />

		<label>Last Name:</label>
		<form:input path="lastName" placeholder="lastName" />
		<form:errors path="lastName" />

		<label>Email:</label>
		<form:input path="email" placeholder="email" />
		<form:errors path="email" />

		<form:hidden path="id" placeholder="Id" />

		<input type="submit" value="Save" />
		
	</form:form>

</body>
</html>
