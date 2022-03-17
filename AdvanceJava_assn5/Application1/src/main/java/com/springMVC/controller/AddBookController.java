package com.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.model.BookList;

@Controller
public class AddBookController {

	RestController restController=new RestController();

	@PostMapping("/addBook")
	public ModelAndView addBookToList(HttpServletRequest request, HttpServletResponse response) {
		BookList book=new BookList();
		book.setBookCode(Integer.parseInt(request.getParameter("bookcode")));
		book.setBookName(request.getParameter("bookname"));
		book.setAuthor(request.getParameter("author"));
		ModelAndView mv = new ModelAndView();
		//System.out.println(book);
		restController.callCreateBookAPI(book);
		mv.setViewName("home.jsp");
		return mv;
	}

	@RequestMapping("/cancel")
	public ModelAndView Cancel() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;

	}

}
