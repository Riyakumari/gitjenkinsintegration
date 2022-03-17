<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<form action="login" method="post">
		<center>
			<table border="2" bgcolor="#f0f8ff" bordercolor="#f0f8ff"
				height="150" width="500">
				<thead>
					<tr>
						<th colspan="2" align="left" style="border: 2px solid #06038D">Librarian Login
							Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><b><i>User ID:</i></b></td>
						<td><input type="text" name="uname" required /></td>
					</tr>
					<tr>
						<td><b><i>Password:</i></b></td>
						<td><input type="password" name="pass" required /></td>
					</tr>
					<tr>
						<td colspan="2" align="right" height="25px"
							style="border: 2px solid #06038D"><input type="submit"
							value="Login" /> &nbsp;</td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>