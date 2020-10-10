<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Register"/>
            </jsp:include>
            <h2>
                Register
            </h2>
            <main>
                <c:if test="${not empty errors}">
                    <div class="alert alert-danger">
                        <c:forEach var="error" items="${errors}">
                            <ul>
                                <li>${error}</li>
                            </ul>
                        </c:forEach>
                    </div>
                </c:if>


                <form action="Controller?command=Register" method="post">
                    <p>
                        <label for="userid">User id</label>
                        <input type="text" id="userid" name="userid" value="${previousId}">
                    </p>
                    <p>
                        <label for="firstName">First Name</label>
                        <input type="text" id="firstName" name="firstName" value="${previousFirstName}">
                    </p>
                    <p>
                        <label for="lastName">Last Name</label>
                        <input type="text" id="lastName" name="lastName" value="${previousLastName}">
                    </p>
                    <p>
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" value="${previousEmail}">
                    </p>
                    <p>
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" value="${previousPassword}">
                    </p>
                    <p>
                        <input type="submit" id="signUp" value="Sign Up">
                    </p>

                </form>
            </main>
            <footer>
                &copy; Webontwikkeling 3, UC Leuven-Limburg
            </footer>
        </div>
    </body>
</html>
