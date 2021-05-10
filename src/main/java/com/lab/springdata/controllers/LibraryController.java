package com.lab.springdata.controllers;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.errors.exceptions.LibraryCustomException;
import com.lab.springdata.services.LibraryService;


@RestController
@RequestMapping("library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("authors")
	public void saveAuthor(@RequestBody Author author) {
		System.out.println(author);
		libraryService.saveAuthor(author);
	}
	
	@DeleteMapping("authors/delete/{id}")
	public void deleteAuthor(@PathVariable int id) {
		libraryService.deleteAuthor(id);
	}
	
	@GetMapping("books/find-all")
	public List<Book> findAllBooks() {
		return libraryService.findAllBooks();
	}
	
	@GetMapping("books/find-by-time-range")
	public List<Book> findBooksByTimeRange(@RequestParam int startYear, @RequestParam int endYear) throws LibraryCustomException {
		return libraryService.findBooksByTimeRange(startYear, endYear);
	}

}
