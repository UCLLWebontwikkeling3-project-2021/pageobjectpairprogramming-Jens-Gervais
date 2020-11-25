<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-11-25
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta charset="UTF-8">
        <title>Register test result</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp">
                <jsp:param name="title" value="Register test result"/>
            </jsp:include>
            <h2>
                Register test result
            </h2>
            <main>
                <form action="Controller?command=RegisterTestResult&LoggedInUserId=${personLogin.getUserid()}" method="post">
                    <p>
                        <label for="datumTest">Datum</label>
                        <input type="date" id="datumTest" name="datumTest">
                    </p>
                    <p>
                        <input type="submit" id="signUp" value="Test positive">
                    </p>

                </form>
            </main>
            <footer>
                &copy; Webontwikkeling 3, UC Leuven-Limburg
            </footer>
        </div>
    </body>
</html>
