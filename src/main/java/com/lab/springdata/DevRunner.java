package com.lab.springdata;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lab.springdata.entities.Author;
import com.lab.springdata.entities.Book;
import com.lab.springdata.services.LibraryService;

@Component
public class DevRunner implements CommandLineRunner {

	@Autowired
	private LibraryService libraryService;

	@Override
	public void run(String... args) throws Exception {
		libraryService.saveAuthor(new Author("Haruki murakami",
				61.42f,
				List.of(new Book("Norwegian wood", 1987), new Book("Kafka on the shore", 2002))));
		
		
		System.out.println(libraryService.findBooksByTimeRange(1980, 2020));
		System.out.println(libraryService.findBooksByTimeRange(1995, 2020));
	}
}
