<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
		<center>
		<h1 style="color: red; text-align: center;">Employee Registration
			Page</h1>
		<form:form method='POST' modelAttribute="emp">
			<table>
				<tr>
					<th>ENO</th>
					<td><form:input path='eno'/></td>
				</tr>
				<tr>
					<th>ENAME</th>
					<td><form:input path='ename'/></td>
				</tr>
				<tr>
					<th>EDESG</th>
					<td><form:input path='edesg'/></td>
				</tr>
				<tr>
					<th>SALARY</th>
					<td><form:input path='salary'/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='submit' value='register'></td>
				</tr>

			</table>
		</form:form>
	</center>
</body>
</html>