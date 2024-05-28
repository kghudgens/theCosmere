package com.cosmere.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosmere.entities.Books;
import com.cosmere.repository.BookRepository;

@RestController
public class BookController {

    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Books> all() {
        return repository.findAll();
    }

    @PostMapping("/book")
    Books newBook(@RequestBody Books newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Books getBook(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book with the id of " + id + " is not saved yet"));
    }

    @PostMapping("/books/{id}")

    Books replaceBook(@RequestBody Books newBook, @PathVariable Long id) {

        return repository.findById(id).map(book -> {
            book.setAuthor(newBook.getAuthor());
            book.setTitle(newBook.getTitle());
            book.setPublisher(newBook.getPublisher());
            book.setDatePublished(newBook.getDatePublished());
            return repository.save(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return repository.save(newBook);
        });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
