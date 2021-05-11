package com.lab.springdata.services;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.lab.springdata.dto.TimePeriod;
import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.repositories.AuthorRepository;
import com.lab.springdata.repositories.BookRepository;
import com.lab.springdata.validation.annotations.ValidTimePeriod;

import lombok.RequiredArgsConstructor;


@Validated
@Service
@RequiredArgsConstructor
public class LibraryService {
	
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public int saveAuthor(Author author) {
		authorRepository.save(author);
		return author.getId();
	}
	
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}
	
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public List<Book> findBooksByTimeRange(@Valid @ValidTimePeriod TimePeriod timePeriod) {
		return bookRepository.findBooksByTimeRange(timePeriod.getStartYear(), timePeriod.getEndYear());
	}

}
