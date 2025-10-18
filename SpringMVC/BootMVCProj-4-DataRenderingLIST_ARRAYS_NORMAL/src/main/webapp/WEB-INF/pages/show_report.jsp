<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<center>
		<h1 style='color: red; text-align: center'>Displaying Simple Data</h1>
		<h1>name is:: ${name}</h1>
		<br />
		<h1>age is:: ${age}</h1>
		<br />
		<h1>address is:: ${address}</h1>
		<br />
		<hr />


		<h1 style='color: red; text-align: center'>Displaying Arrays Concept</h1>
		<h2 style='color: green; text-align: center'>Countries</h2>
		<c:forEach var="country" items="${countries }">
		${country }<br />
		</c:forEach>

		<h1 style='color: red; text-align: center'>Displaying List Concept</h1>
		<h2 style='color: green; text-align: center'>Subjects</h2>
		<c:forEach var="subject" items="${subjects }">
		${subject }<br />
		</c:forEach>

		<h1 style='color: red; text-align: center'>Displaying Sets Concept</h1>
		<h2 style='color: green; text-align: center'>Mobile Numbers</h2>
		<c:forEach var="mob" items="${mobileNumbers }">
		${mob }<br />
		</c:forEach>


		<h1 style='color: red; text-align: center'>Displaying Map Concept</h1>
		<h2 style='color: green; text-align: center'>IDS</h2>
		<c:forEach var="id" items="${ids }">
		${id.key }=${id.value} <br />
		</c:forEach>

	</center>
</body>
</html>