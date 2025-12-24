package com.pycodemasti.bookkeeping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pycodemasti.bookkeeping.entity.Book;


@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{

	List<Book> findByAuthor(String name);
	
	

}
