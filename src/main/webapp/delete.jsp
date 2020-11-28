<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-10-09
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Delete</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Delete person"/>
    </jsp:include>
    <h2>Delete</h2>
    <main>
        <p>Bent u zeker dat u dit account wilt verwijderen?</p>
    </main>
    <form method="post" action="Controller?command=Delete">
        <p>
            <input type="submit" id="delete" value="Ja, ik wil dit account verwijderen">
        </p>
    </form>
    <form method="post" action="Controller?command=Overview">
        <p>
            <input type="submit" id="terug" value="Nee, ik wil dit account niet verwijderen">
        </p>
    </form>
</div>
</body>
</html>