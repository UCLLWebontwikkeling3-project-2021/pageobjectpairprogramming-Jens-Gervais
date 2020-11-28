<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <c:if test="${contact.getUserid() == personLogin.getUserid() || personLogin.getRol() == 'admin'}">
                            <tr>
                                <td>
                                    <fmt:formatDate pattern="yyyy-MM-dd" value="${contact.timestamp}"/>
                                </td>
                                <td>
                                    <fmt:formatDate pattern="HH:mm" value="${contact.timestamp}"/>
                                </td>
                                <td>${contact.getFirstName()} ${contact.getLastName()}</td>
                                <td><a href="Controller?command=DeleteContactPage&ContactId=${contact.getId()}">Verwijder</a></td>
                            </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </c:if>

                <c:if test="${not empty contactErrors}">
                    <div class="alert alert-danger">
                        <c:forEach var="error" items="${contactErrors}">
                            <ul>
                                <li>${error}</li>
                            </ul>
                        </c:forEach>
                    </div>
                </c:if>


                <form action="Controller?command=AddContact&LoggedInUseridContact=${personLogin.getUserid()}" method="post">
                    <p>
                        <label for="firstNameContact">First Name</label>
                        <input type="text" id="firstNameContact" name="firstNameContact" value="${previousFirstNameContact}">
                    </p>
                    <p>
                        <label for="lastNameContact">Last Name</label>
                        <input type="text" id="lastNameContact" name="lastNameContact" value="${previousLastNameContact}">
                    </p>
                    <p>
                        <label for="emailContact">Email</label>
                        <input type="email" id="emailContact" name="emailContact" value="${previousEmailContact}">
                    </p>
                    <p>
                        <label for="telefoonnummerContact">Telefoonnummer</label>
                        <input type="tel" id="telefoonnummerContact" name="telefoonnummerContact" value="${previousTelefoonnummerContact}">
                    </p>
                    <p>
                        <label for="datumContact">Datum</label>
                        <input type="date" id="datumContact" name="datumContact" value="${previousDatumContact}">
                    </p>
                    <p>
                        <label for="tijdstipContact">Tijdstip</label>
                        <input type="time" id="tijdstipContact" name="tijdstipContact" value="${previousTijdstipContact}">
                    </p>
                    <p>
                        <input type="submit" id="signUp" value="Register contact">
                    </p>
                </form>
            </main>
            <footer>
                &copy; Webontwikkeling 3, UC Leuven-Limburg
            </footer>
        </div>
    </body>
</html>
