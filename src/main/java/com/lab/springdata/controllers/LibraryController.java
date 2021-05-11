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

import com.lab.springdata.dto.IdWrapper;
import com.lab.springdata.dto.TimePeriod;
import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.services.LibraryService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class LibraryController {
	
	private final LibraryService libraryService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("authors")
	public IdWrapper saveAuthor(@RequestBody Author author) {
		return new IdWrapper(libraryService.saveAuthor(author));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("authors/{id}")
	public void deleteAuthor(@PathVariable int id) {
		libraryService.deleteAuthor(id);
	}
	
	@GetMapping("books/all")
	public List<Book> findAllBooks() {
		return libraryService.findAllBooks();
	}
	
	@GetMapping("books/by-time-range")
	public List<Book> findBooksByTimeRange(@RequestParam int startYear, @RequestParam int endYear) {
		return libraryService.findBooksByTimeRange(new TimePeriod(startYear, endYear));
	}
}
