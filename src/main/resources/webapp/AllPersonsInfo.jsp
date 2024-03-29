<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.ArrayList"%>
<%@page import="org.example.crud.*"%>
<head>
    <meta charset="UTF-8">
    <title>All Persons Information</title>
    <link rel="stylesheet" href="AllPersonsInfo.css">
</head>

<body>
<div class="viewTitle">
<h1>Persons list</h1>
</div>
<%
ArrayList<Person> arrayList = PersonDao.getAllPersons();
request.setAttribute("arrayList",arrayList);
%>
<table>
<tr>
<th>Id:</th>
<th>Name:</th>
<th>Password:</th>
<th>Email:</th>
<th>Country:</th>
</tr>
<c:forEach items="${arrayList}" var="person">
<tr>
<td>${person.getId()}</td>
<td>${person.getUserName()}</td>
<td>${person.getUserPass()}</td>
<td>${person.getUserEmail()}</td>
<td>${person.getUserCountry()}</td>
<td><a href ="edit?id=${person.getId()}"><button>edit</button></a></td>
<td><a href ="delete?id=${person.getId()}" ><button>delete</button></td>
</tr>
</c:forEach>
</table>
<p><a href = "registration.html">Add new person</a></p>
<p><a href = "authed_person.jsp">Return to authorized person page</a></p>
</body>
</html>