package com.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.model.BookList;

@Controller
public class EditController {
	
	RestController restController =new RestController();
	@RequestMapping("/editBook")
	public ModelAndView editBookList(HttpServletRequest request, HttpServletResponse response) {		
		ModelAndView mv=new ModelAndView();
		BookList book=new BookList();
		book.setBookCode(Integer.parseInt(request.getParameter("bookcode")));
		book.setBookName(request.getParameter("bookname"));
		book.setAuthor(request.getParameter("author"));
		//System.out.println(book);
		restController.callUpdateBookAPI(book);
		mv.setViewName("home.jsp");	
		
		return mv;
	}

}
