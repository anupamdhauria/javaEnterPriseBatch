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
			<c:forEach var="emp" items="${employees}">
				<tr>
					<td>${emp.eno}</td>
					<td>${emp.ename}</td>
					<td>${emp.edesg}</td>
					<td>${emp.salary}</td>

				</tr>
			</c:forEach>
		</table>
		<hr />
		<h1 style='color: red; text-align: center'>Single Object</h1>		
		<h3>Emp_no:${employee.eno}</h3>		
		<h3>Emp_name:${employee.ename}</h3>	
		<h3>Emp_desg:${employee.edesg}</h3>		
		<h3>Emp_salary:${employee.salary}</h3>		
	</center>
</body>
</html>