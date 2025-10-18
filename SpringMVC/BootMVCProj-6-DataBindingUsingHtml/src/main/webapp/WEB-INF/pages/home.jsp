<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form method='POST'>
			<table>
				<tr>
					<th>ENO</th>
					<td><input type='text' name='eno'></td>
				</tr>
				<tr>
					<th>ENAME</th>
					<td><input type='text' name='ename'></td>
				</tr>
				<tr>
					<th>EDESG</th>
					<td><input type='text' name='edesg'></td>
				</tr>
				<tr>
					<th>SALARY</th>
					<td><input type='text' name='salary'></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='submit' value='register'></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>