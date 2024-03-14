<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update person information</title>
    <link rel="stylesheet" href="updater.css">
</head>

<body>
<div class="updateForm">
    <div class="updateFormTitle">
        <h3>Update person</h3>
    </div>
    <form method="post">
    <table>
    <tr><td>Name:</td><td><input type="text" value="${person.userName}" name="userName"/></td></tr>
    <tr><td>Password:</td><td><input type="password" value="${person.userPass}" name="userPass"/></td></tr>
    <tr><td>Email:</td><td><input type="email" value="${person.userEmail}" name="userEmail"/></td></tr>
    <tr><td>Country:</td><td>
        <select name="userCountry" style="width:150px">
        <option selected="selected"> ${person.userCountry}</option>
        <option>India</option>
        <option>USA</option>
        <option>UK</option>
        <option>Russia</option>
        <option>Germany</option>
        <option>Other</option>
        </select>
    </td></tr>
    <div class="updateButton">
    <tr><td colspan="2"><input type="submit" value="update"/></td></tr>
    </div>
    </table>
    </form>
</div>
<br/>
<div class="registrationLink">
<a href="index.html">Return to registration page</a>
<div>
</body>
</html>