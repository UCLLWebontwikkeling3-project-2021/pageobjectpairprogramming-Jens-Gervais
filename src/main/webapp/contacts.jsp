<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-02
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8">
        <title>Contacts</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Contacts"/>
            </jsp:include>
            <h2>
                Contacts overview
            </h2>
            <main>
                <c:if test="${contacts != null}">
                    <table id="overview">
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Name</th>
                        </tr>
                        <c:forEach var="contact" items="${contacts}">
                            <tr>
                                <td>${contact.getDatum()}</td>
                                <td>${contact.getAankomstuur()}</td>
                                <td>${contact.getFirstName()} ${contact.getLastName()}</td>
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
