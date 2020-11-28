<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-28
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Alter role</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Alter role"/>
    </jsp:include>
    <h2>
        Alter role
    </h2>
    <main>
        <form method="post" action="Controller?command=AlterRole&UseridRole=${UseridRole}">
            <p>
                <label for="Roles">Choose a role</label>
                <select id="Roles" name="Roles">
                    <option value="admin">Admin</option>
                    <option value="gebruiker">User</option>
                </select>
                <input type="submit" id="alterRole" value="Are you sure you want to change the role of ${personRole.getFirstName()} ${personRole.getLastName()}">
            </p>
        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
