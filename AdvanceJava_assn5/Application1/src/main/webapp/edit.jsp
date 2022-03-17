<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.springMVC.controller.RestController"%>
<%@page import="com.springMVC.model.BookList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book Details</title>
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
<form method="post" action="editBook">
<br>
<%RestController restController=new RestController();
BookList book= restController.callGetBookByIdAPI(Integer.parseInt(request.getParameter("id"))); 
%>
<label>Book Code:&nbsp;&nbsp;&nbsp;&nbsp; </label><input type="text" name="bookcode"value="<%=request.getParameter("id")%>" readonly><br><br>
<label>Book Name:&nbsp;&nbsp;</label> <input type="text" name="bookname" value="<%=book.getBookName()%>"><br><br>
<label>Author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><select name="author" required>
			    <option value="1">--select--</option>
				<option value="J.K. Rowling">J.K. Rowling</option>
				<option value="William Shakespeare">William Shakespeare</option>
				<option value="Oscar Wilde">Oscar Wilde</option>
				<option value="Charles Dickens">Charles Dickens</option>
				<option value="George Orwell">George Orwell</option>
				<option value="Leo Tolstoy">Leo Tolstoy</option>
		</select><br><br>
<label>Added on: &nbsp;&nbsp;&nbsp;</label><% out.print(formattedDate);%><br><br>
<button type="submit" style="background-color: #00008b; color: white; font-weight: bold">
            Update
        </button>
          
        <button type="submit" method="post" formaction="cancel" style="background-color: red; color: white; font-weight: bold">
           Cancel
        </button>
</form>

</body>
</html>