package com.lab.springdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lab.springdata.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("from Book b where year BETWEEN :startYear AND :endYear")
	List<Book> findBooksByTimeRange(int startYear, int endYear);
}
