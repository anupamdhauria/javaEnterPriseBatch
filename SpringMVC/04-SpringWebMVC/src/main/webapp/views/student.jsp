<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT DETAILS</title>
</head>
<body>

	<center>
		<table border=1>
			<tr>
				<th>Student ID</th>
				<td>${std.id }</td>
			</tr>
			<tr>
				<th>Stuent Name</th>
				<td>${std.firstName } ${std.lastName} </td>
			</tr>
			<tr>
				<th>Student Gender</th>
				<td>${std.gender }</td>
			</tr>
			<tr>
				<th>Student City</th>
				<td>${std.city }</td>
			</tr>
			
			
		</table>
	</center>
</body>
</html>