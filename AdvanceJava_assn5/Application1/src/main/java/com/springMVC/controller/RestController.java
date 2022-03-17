package com.springMVC.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springMVC.model.BookList;

@Service
public class RestController {
	
	public static final String GET_ALL_BOOKS_API = "http://localhost:8081/api/books";
	public static final String GET_BOOK_BY_ID_API = "http://localhost:8081/api/books/{id}";
	public static final String CREATE_BOOK_API = "http://localhost:8081/api/books";
	public static final String UPDATE_BOOK_API = "http://localhost:8081/api/books/{id}";
	public static final String DELETE_BOOK_APT = "http://localhost:8081/api/books/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();  
	public BookList[] callGetAllBooksAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<BookList[]> result=restTemplate.exchange(GET_ALL_BOOKS_API , HttpMethod.GET, entity, BookList[].class);
		//List<BookList> books=(List<BookList>)result.getBody();
		BookList[] books=result.getBody();
		return books;
	}
	public BookList callGetBookByIdAPI(int val) {
		Map<String,Integer> param = new HashMap<String, Integer>();
		param.put("id",val);
		BookList bookList = restTemplate.getForObject(GET_BOOK_BY_ID_API, BookList.class, param);
		return bookList;
	}
	public void callCreateBookAPI(BookList bookList) {

		restTemplate.postForEntity(CREATE_BOOK_API, bookList, BookList.class);
	}
	public void callUpdateBookAPI(BookList book) {
		Map<String,Integer> param = new HashMap<String, Integer>();
		param.put("id", book.getBookCode());
		BookList bookList=new BookList();
		bookList.setBookName(book.getBookName());
		bookList.setBookCode(book.getBookCode());
		bookList.setAuthor(book.getAuthor());
		restTemplate.put(UPDATE_BOOK_API, bookList, param);
		//System.out.println("update sucess");
		
		
	}
	public static void callDeleteBookAPI(int val) {
		Map<String,Integer> param = new HashMap<String, Integer>();
		param.put("id", val);
		restTemplate.delete(DELETE_BOOK_APT,param);
		//System.out.println("delete sucess");
	}

}
