<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-26
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8">
        <title>Search</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Search person"/>
            </jsp:include>
            <h2>Search</h2>
            <main>
                <c:if test="${searchContacts != null}">
                    <table id="search">
                        <tr>
                            <th>Name</th>
                            <th>Phone number</th>
                            <th>Email</th>
                        </tr>
                        <c:forEach var="contact" items="${searchContacts}">
                            <c:if test="${contact.getUserid() == personLogin.getUserid() && personLogin.getTest() == 'positief'}">
                                <tr>
                                    <td>${contact.getFirstName()} ${contact.getLastName()}</td>
                                    <td>${contact.getTelefoonnummer()}</td>
                                    <td>${contact.getEmail()}</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </c:if>
            </main>
        </div>
    </body>
</html>
