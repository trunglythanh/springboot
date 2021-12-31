<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="displayStudentInfo" modelAttribute="studentDto">
	Name: <form:input path="name" required="true" placeholder="Please enter name"/><form:errors path="name" cssStyle="color:red" /><br>
	Gender: <form:radiobutton path="gender" value="Male" label="Male"/> <form:radiobutton path="gender" value="Female" label="Female"/><br>
	Student Number: <form:input path="studentNumber"/> <br>
	<input type="submit" value="Submit"> 
	
</form:form>
<a href="/logout">Log out</a>
</body>
</html>