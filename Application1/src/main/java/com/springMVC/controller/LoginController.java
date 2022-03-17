package com.springMVC.controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.controller.service.LoginService;



@Controller
public class LoginController {
	
	@PostMapping("/login")
	 public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 ModelAndView mv=new ModelAndView();
		 
		 String uname=request.getParameter("uname");
		 String pass=request.getParameter("pass");
		 
		 if(new LoginService().check(uname, pass)) {
			 HttpSession session=(HttpSession) request.getSession();
			 session.setAttribute("uname",uname);
			 mv.setViewName("home.jsp");
		 }
		 else {
			 PrintWriter out=response.getWriter();        	
	        	out.println("<script type=\"text/javascript\">");
	        	out.println("alert('incorrect username or password');");
	        	out.println("location='index.jsp';");
	        	out.println("</script>");
			 //mv.setViewName("index.jsp");
		 }		 
		 return mv;
	 }
	

}
