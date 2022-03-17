package com.springBoot.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.model.BookList;
import com.springBoot.repository.BookRepo;

@RestController
@RequestMapping("/api/books")
public class LibraryResource {
	@Autowired
	BookRepo repo;
	
	@PostMapping
	public void addBook(@RequestBody BookList bookList) {
		repo.save(bookList);
	}
	
	@GetMapping
	public List<BookList> getBooks(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<BookList> getBookById(@PathVariable(value = "id") int code) {
		return repo.findById(code);
	}
	
	@PutMapping("/{id}")
	public BookList updateBook(@RequestBody BookList bookList,@PathVariable("id") int code) {
		BookList oldBookList = repo.findById(code)
				.orElseThrow();
		oldBookList.setBookName(bookList.getBookName());
		oldBookList.setAuthor(bookList.getAuthor());
		return repo.save(oldBookList);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<BookList> deleteBook(@PathVariable(value = "id") int code){
		BookList currBookList = repo.findById(code)
				.orElseThrow();
		repo.delete(currBookList);
		return ResponseEntity.ok().build();
	}
	
	

}