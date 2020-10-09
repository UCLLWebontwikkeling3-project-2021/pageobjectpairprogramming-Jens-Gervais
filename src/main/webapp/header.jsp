<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jensg
  Date: 2020-10-01
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>${param.title}</h1>
    <nav>
        <ul>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?command=Overview">Overview</a></li>
            <li><a href="Controller?command=RegisterPage">Register</a></li>
        </ul>
    </nav>

</header>