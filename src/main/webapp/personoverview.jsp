<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8">
        <title>Overview</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Persons"/>
            </jsp:include>
            <h2>
                User overview
            </h2>
            <main>
                <c:if test="${persons != null}">
                    <table id="overview">
                        <tr>
                            <th>E-mail</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                        <c:forEach var="person" items="${persons}">
                            <tr>
                                <td>${person.email}</td>
                                <td>${person.firstName}</td>
                                <td>${person.lastName}</td>
                                <c:if test="${person==personLogin}">
                                    <td><a href="Controller?command=DeletePage">Verwijder</a></td>
                                </c:if>
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