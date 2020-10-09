<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>Home</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="header.jsp">
				<jsp:param name="title" value="Index"/>
			</jsp:include>
			<h2>
				Home
			</h2>
			<main>
				<p>
					Sed ut perspiciatis unde omnis iste natus error sit
					voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
					ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
					dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
					aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
					qui ratione voluptatem sequi nesciunt.
				</p>
				<c:if test="${not empty errorLogin}">
					<div class="alert alert-danger">
						${errorLogin}
					</div>
				</c:if>
				<c:choose>
					<c:when test="${not empty personLogin}">
						<h3>
							Welkom ${personLogin.firstName}
						</h3>
						<form action="Controller?command=Logout" method="post">
							<p>
								<input type="submit" id="logout" value="Log out">
							</p>
						</form>
					</c:when>
					<c:otherwise>
						<h3>
							Log in
						</h3>
						<form action="Controller?command=Login" method="post">
							<p>
								<label for="userId">User ID</label>
								<input type="text" id="userId" name="userId" value="${userIdPrevious}">
							</p>
							<p>
								<label for="password">Password</label>
								<input type="password" id="password" name="password">
							</p>
							<p>
								<input type="submit" id="login" value="Log in">
							</p>
						</form>
					</c:otherwise>
				</c:choose>
			</main>
			<footer>
				&copy; Webontwikkeling 3, UC Leuven-Limburg
			</footer>
		</div>
	</body>
</html>
