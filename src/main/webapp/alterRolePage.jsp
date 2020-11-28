<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-28
  Time: 11:40
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
        Alter Role
    </h2>
    <main>
        <c:if test="${personsRole != null}">
            <table id="overview">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Current Role</th>
                </tr>
                <c:forEach var="person" items="${personsRole}">
                    <tr>
                        <td>${person.firstName}</td>
                        <td>${person.lastName}</td>
                        <td>${person.getRol()}</td>
                        <td><a href="Controller?command=AlterRolePage2&AlterRoleUser=${person.getUserid()}">Update role</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
