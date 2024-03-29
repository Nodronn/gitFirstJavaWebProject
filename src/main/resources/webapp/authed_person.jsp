<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<%
HttpSession httpSession = request.getSession();
if(session == null){
	response.sendRedirect("authorization.html");
}
else {
String userName = (String) httpSession.getAttribute("userName");
String userEmail = (String) httpSession.getAttribute("userEmail");
String userCountry = (String) httpSession.getAttribute("userCountry");
String userPermission = (String) httpSession.getAttribute("userPermission");
int userId = (Integer) httpSession.getAttribute("userId");
}
%>
<div class="authedInfo">
<div class="authedInfoTitle">
    Person information
</div>
<table>
<tr><th>Hello ${sessionScope.userName}</th><td><img src="images/simpleAvatar.png" width="30" height="30" alt="avatar" class="avatar"></td></tr>
<tr><th>Your Id:</th><td> ${userId}</td></tr>
<tr><th>Your name:</th><td>${sessionScope.userName}</td></tr>
<tr><th>Your email</th><td>${sessionScope.userEmail}</td></tr>
<tr><th>Your country</th><td>${sessionScope.userCountry}</td></tr>
</table>
</div>
<br>
<p><a href="edit?id=${sessionScope.userId}"><button>Edit</button></a></p>
<c:if test="${userPermission.equals('admin')}">
    <p><a href="view"><button>View all persons</button></a></p>
</c:if>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>