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

		<h1 style='color: red; text-align: center'>Employee Record</h1>
		<table boder='1'>
			<tr>
				<th>SNO</th>
				<th>SNAME</th>
				
			</tr>		
				<tr>
					<td>${param.sno}</td>
					<td>${param.sname}</td>
				</tr>
			
		</table>
	
	</center>
</body>
</html>