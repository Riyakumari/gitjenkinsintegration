package com.springMVC.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();		
		HttpSession session = request.getSession();
		session.invalidate();		
		mv.setViewName("index.jsp");
		
		return mv;
	}

}
