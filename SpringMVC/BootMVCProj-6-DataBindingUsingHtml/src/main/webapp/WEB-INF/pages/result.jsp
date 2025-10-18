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
				<th>EMPNO</th>
				<th>EMPNAME</th>
				<th>EMPDESG</th>
				<th>EMPSALARY</th>
			</tr>		
				<tr>
					<td>${employee.eno}</td>
					<td>${employee.ename}</td>
					<td>${employee.edesg}</td>
					<td>${employee.salary}</td>

				</tr>
			
		</table>
	
	</center>
</body>
</html>