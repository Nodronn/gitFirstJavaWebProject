<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update person information</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="editForm">
    <div class="editFormTitle">
        Update person
    </div>
    <form method="post">
    <table>
    <tr><th>Name:</th><td><input type="text" value=${person.userName} name="userName"/></td></tr>
    <tr><th>Password:</th><td><input type="password" value=${person.userPass} name="userPass"/></td></tr>
    <tr><th>Email:</th><td><input type="email" value=${person.userEmail} name="userEmail"/></td></tr>
    <tr><th>Country:</th><td>
        <select name="userCountry" style="width:178px">
        <option selected="selected"> ${person.userCountry}</option>
        <option>India</option>
        <option>USA</option>
        <option>UK</option>
        <option>Russia</option>
        <option>Germany</option>
        <option>Other</option>
        </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="save"/></td></tr>
    </table>
    </form>
</div>
</body>
</html>