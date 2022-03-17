<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% DateFormat df = new SimpleDateFormat("dd/MM/yy");
String formattedDate = df.format(new Date());%>
<form align="right" action="logout" method="post">
		<b>Hii <%=session.getAttribute("uname")%>
		</b><input type="submit"
			style="background-color: #00008b; color: white; font-weight: bold"
			value="Logout">
	</form>
	<center>
		<h1><u><b><i>Add Book Details</i></b></u></h1>
		</center>
	
	<form action="addBook" method="post">
		<div>
			<label>Book Code:&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="bookcode">
		</div>
		<br>
		<div>
			<label>Book Name:&nbsp;&nbsp;</label> <input type="text" name="bookname">
		</div>
		<br>
		<div>
			<label>Author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<select name="author" required>
			    <option value="author">--select--</option>
				<option value="J.K. Rowling">J.K. Rowling</option>
				<option value="William Shakespeare">William Shakespeare</option>
				<option value="Oscar Wilde">Oscar Wilde</option>
				<option value="Charles Dickens">Charles Dickens</option>
				<option value="George Orwell">George Orwell</option>
				<option value="Leo Tolstoy">Leo Tolstoy</option>
		</select></div><br>
		<div>
			<label>Date Added:&nbsp;&nbsp;&nbsp;</label><% out.print(formattedDate);%><br><br>
		</div>
		<div>
			<button type="submit" style="background-color: #00008b; color: white; font-weight: bold">
            Add
        </button>
          
        <button type="submit" method="post" formaction="cancel" style="background-color: red; color: white; font-weight: bold">
           Cancel
        </button>
			
		</div>
	</form>
	
</body>
</html>