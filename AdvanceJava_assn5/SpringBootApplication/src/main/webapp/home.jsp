<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><form action="/add" method="post">
<input type="text" name="bookcode">
<input type="text" name="bookname">
<input type="text" name="author">
<input type="submit">
</form>
<form action="/delete">
<input type="text" name="bookcode">
<input type="submit">
</form>
<form action="/update" method="post">
<input type="text" name="bookcode">
<input type="text" name="bookname">
<input type="text" name="author">
<input type="submit">
</form>
</body>
</html>