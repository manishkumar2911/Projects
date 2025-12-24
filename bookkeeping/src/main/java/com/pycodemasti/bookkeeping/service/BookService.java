package com.pycodemasti.bookkeeping.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pycodemasti.bookkeeping.entity.Book;
import com.pycodemasti.bookkeeping.repository.BookRepo;

@Service
public class BookService {

	
	@Autowired 
	BookRepo repo;
	
	public List<Book> getAll(){
		return repo.findAll();
	}
	
	public Book getById(int id) {
		
		return repo.findById(id).get();
		
	}
	
	public void deleteall() {
		repo.deleteAll();
	}
	
	public void deletebyId(int id) {
		repo.deleteById(id);
	}
	
	public List<Book> findByAuthor(String name){
		return repo.findByAuthor(name);
	}
	
	public Book Save(Book book) {
		return repo.save(book);
	}

	public Book patch(int id, Map<String, Object> updates) {
		// TODO Auto-generated method stub
		
		Book book=repo.findById(id).get();
		if(updates.containsKey("author")) {
			book.author=(String) updates.get("author");
			
		}
		if(updates.containsKey("name")) {
			book.name=(String) updates.get("name");
			
		}
		
		return repo.save(book);
	}
}
