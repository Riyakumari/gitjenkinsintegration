package com.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
	RestController restController=new RestController();
	@RequestMapping("Delete")
	public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int code=Integer.parseInt(request.getParameter("id"));
		//System.out.println(code);
		restController.callDeleteBookAPI(code);
		mv.setViewName("home.jsp");
		return mv;
	}

}
