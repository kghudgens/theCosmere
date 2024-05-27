package com.cosmere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmere.books.Books;

public interface BookRepository extends JpaRepository<Books, Long> {

}
