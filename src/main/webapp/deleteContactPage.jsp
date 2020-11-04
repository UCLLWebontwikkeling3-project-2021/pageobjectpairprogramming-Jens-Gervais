<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-04
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Delete contact"/>
    </jsp:include>
    <h2>Delete contact</h2>
    <main>
        <p>Bent u zeker dat u dit contact wilt verwijderen?</p>
    </main>
    <form method="post" action="Controller?command=DeleteContact&ContactId=${ContactUserId}">
        <p>
            <input type="submit" id="delete" value="Ja, ik wil dit contact verwijderen">
        </p>
    </form>
    <form method="post" action="Controller?command=Contacts">
        <p>
            <input type="submit" id="terug" value="Nee, ik wil dit contact niet verwijderen">
        </p>
    </form>
</div>
</body>
</html>
