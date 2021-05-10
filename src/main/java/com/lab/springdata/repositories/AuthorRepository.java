package com.lab.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.springdata.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{}
