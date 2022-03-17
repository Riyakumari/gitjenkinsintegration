<%@page import="com.springMVC.controller.RestController"%>
<%@page import="com.springMVC.model.BookList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
	RestController restController = new RestController();
	BookList[] books = restController.callGetAllBooksAPI();
	List<BookList> list = Arrays.asList(books);
	%>
	<form align="right" action="logout" method="post">
		<b>Hii <%=session.getAttribute("uname")%>
		</b><input type="submit"
			style="background-color: #00008b; color: white; font-weight: bold"
			value="Logout">
	</form>

	<center>
		<table border="1" width="1100px" border-collapse="collapse"
			border-spacing="inherit" border-color="black" text-align="center">
			<h2>
				<b>Lists of Books</b>
			</h2>
			<form align="right" action="addPage.jsp" method="post">
				<input type="submit"
					style="background-color: #00008b; color: white; font-weight: bold"
					value="Add">
			</form>
				<tr height="30px">
					<td><center>
							<b>Book Code</b>
						</center></td>
					<td><center>
							<b>Book Name</b>
						</center></td>
					<td><center>
							<b>Author</b>
						</center></td>
					<td><center>
							<b>Date Added</b>
						</center></td>
					<td><center>
							<b>Action</b>
						</center></td>
				</tr>

				<%
				for (BookList l : list) {
				%>
				<tr height="70px">
					<td><center><%=l.getBookCode()%></center></td>
					<td><center><%=l.getBookName()%></center></td>
					<td><center><%=l.getAuthor()%></center></td>
					<td><center><%=l.getDate()%></center></td>
					<td><center>
							<a href="edit.jsp?id=<%=l.getBookCode()%>"><button
									type="button"
									style="background-color: red; color: white; font-weight: bold"
									class="edit">Edit</button></a> <a
								href="Delete?id=<%=l.getBookCode()%>"><button type="button"
									style="background-color: green; color: white; font-weight: bold"
									class="delete">Delete</button></a>
						</center></td>
				</tr>
				<%
				}
				%>
			
		</table>
	</center>
</body>
</html>