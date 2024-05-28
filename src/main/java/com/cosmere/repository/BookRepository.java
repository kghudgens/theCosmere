package com.cosmere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmere.entities.Books;

public interface BookRepository extends JpaRepository<Books, Long> {

}
