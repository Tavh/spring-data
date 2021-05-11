package com.lab.springdata;

import java.util.List; 

import javax.validation.ConstraintViolationException;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.lab.springdata.dto.TimePeriod;
import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.errors.exceptions.LibraryCustomException;
import com.lab.springdata.repositories.AuthorRepository;
import com.lab.springdata.services.LibraryService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DevRunner implements CommandLineRunner {
	
	private static final int EARLIEST_DATE = 1980;
	private static final int LATEST_DATE = 2020;
	
	private final LibraryService libraryService;
	private final AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = List.of(new Book("Norwegian wood", EARLIEST_DATE), new Book("Kafka on the shore", LATEST_DATE));
		int authorId = saveAuthorTest(new Author("Haruki murakami", 61.42f, books));
		findAllBooksTest();
		findBooksByTimeRangeTest();
		findBooksByTimeRangeInvalidTest();
		deleteAuthorTest(authorId);
	}

	
	private int saveAuthorTest(Author author) throws LibraryCustomException {
		int id = libraryService.saveAuthor(author);
		if (authorRepository.findById(id).isPresent()) {
			return id;
		}
		throw new LibraryCustomException("Library test failure! - saveAuthorTest");
	}
	
	private void deleteAuthorTest(int id) throws LibraryCustomException {
		libraryService.deleteAuthor(id);
		if (authorRepository.findById(id).isEmpty()) {
			return;
		}
		throw new LibraryCustomException("Library test failure! - deleteAuthorTest");
	}
	

	private void findAllBooksTest() throws LibraryCustomException {
		if (libraryService.findAllBooks().size() != 2) {
			throw new LibraryCustomException("Library test failure! - findAllBooks");
		}
	}
	
	private void findBooksByTimeRangeTest() throws LibraryCustomException {
		if (libraryService.findBooksByTimeRange(new TimePeriod(EARLIEST_DATE, LATEST_DATE)).size() != 2) {
			throw new LibraryCustomException("Library test failure! - findBooksByTimeRangeTest");
		}
	}
	
	private void findBooksByTimeRangeInvalidTest() throws LibraryCustomException {
		try {
			libraryService.findBooksByTimeRange(new TimePeriod(LATEST_DATE, EARLIEST_DATE));
		} catch (ConstraintViolationException e) {
			return;
		}
		throw new LibraryCustomException("Library test failure! - findBooksByTimeRangeInvalidTest");
	}
}
