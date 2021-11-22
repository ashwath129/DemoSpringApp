<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world! - AlertOps - Commit Change: 2.35 PM EST 11/22/2021</h1>

	<P>The time on the server is ${serverTime}.</p>

	<form action="user" method="post">
		<input type="text" name="userName"><br> <input type="text" name="num"><br>  <input
			type="submit" value="Login">
	</form>
</body>
</html>
