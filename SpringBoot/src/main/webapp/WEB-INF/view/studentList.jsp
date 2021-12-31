<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Student</title>
</head>
<body>
<table border="1">
	<tr>
        
        <th>NAME</th>
        <th>GENDER</th>
        <th>STUDENT NUMBER</th>
    </tr>
    <c:forEach var="student" items="${listStudentDto}">
        <tr>
            
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.studentNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>