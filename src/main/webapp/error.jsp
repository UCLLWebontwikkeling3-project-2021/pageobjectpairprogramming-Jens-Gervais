<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-10-01
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Error"/>
            </jsp:include>
            <h2>
                Errors
            </h2>
            <main>De pagina waar u naartoe probeerde te gaan bestaat niet.</main>
            <footer>
                &copy; Webontwikkeling 3, UC Leuven-Limburg
            </footer>
        </div>
    </body>
</html>
