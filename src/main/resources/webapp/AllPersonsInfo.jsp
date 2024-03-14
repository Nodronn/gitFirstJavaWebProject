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
    ArrayList persons = (ArrayList) request.getAttribute("persons");
    out.print("<table>");
    out.print("<tr><th>Id</th><th>User Name</th><th>User Password</th>" +
    			"<th>User Email</th><th>User Country</th></tr>");
    for (int i = 0; i < persons.size(); i++) {
            Person person = (Person) persons.get(i);
    		out.print("<tr>");
    		out.print("<td>" + person.getId() + "</td>");
    		out.print("<td>" + person.getUserName() + "</td>");
    		out.print("<td>" + person.getUserPass() + "</td>");
    		out.print("<td>" + person.getUserEmail() + "</td>");
    		out.print("<td>" + person.getUserCountry() + "</td>");
    		out.print("<td><a href =' updater?id=" + person.getId() + "'><button>update</button></a></td>");
            out.print("<td><a href =' delete?id=" + person.getId() + "'><button>delete</button></a></td>");
    		out.print("</tr>");
    }
    out.print("</table>");
%>

</body>
</html>