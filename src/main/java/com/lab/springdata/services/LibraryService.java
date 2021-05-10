package com.lab.springdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.errors.exceptions.LibraryCustomException;
import com.lab.springdata.repositories.AuthorRepository;
import com.lab.springdata.repositories.BookRepository;

@Service
public class LibraryService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}
	
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public List<Book> findBooksByTimeRange(int startYear, int endYear) throws LibraryCustomException {
		if (startYear > endYear) {
			throw new LibraryCustomException("startYear must be higher than endYear");
		}
		return bookRepository.findBooksByTimeRange(startYear, endYear);
	}

}
