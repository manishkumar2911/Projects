package com.pycodemasti.bookkeeping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pycodemasti.bookkeeping.entity.Book;
import com.pycodemasti.bookkeeping.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	
	@GetMapping("/")
	public List<Book> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/") 
	public Book saveBook(@RequestBody Book book) {
		return service.Save(book);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/")
	public void DeleteAll() {
		service.deleteall();
	}
	
	@DeleteMapping("/{id}")
	
	public void DeleteById(@PathVariable int id) {
		service.deletebyId(id);
	}
	
	@GetMapping("/Authors/{Author}")
	public List<Book> getByAuthorName(@PathVariable String Author){
		return service.findByAuthor(Author);
	}
	
	@PutMapping("/")
	public Book updateBook(@RequestBody Book book) {
		return service.Save(book);
	}
	
	@PatchMapping("/{id}")
	public Book partialUpdate(@PathVariable int id ,@RequestBody Map<String, Object> updates) {
		
		return service.patch(id,updates);
		
	}

}
