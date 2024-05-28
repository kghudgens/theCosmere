package com.cosmere.books;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cosmere.entities.Books;
import com.cosmere.enumerators.Publishers;

@SpringBootTest(classes = Books.class)
public class BooksTest {

    private Books book;

    @Test
    public void gettersAndSettersTest() {
        book = new Books();
        Publishers publisher = Publishers.GOLLANCZ;
        book.setTitle("Elantris");
        book.setAuthor("Brandon Sanderson");
        book.setDatePublished(LocalDate.of(2005, Month.APRIL, 21));
        book.setPublisher(publisher.toString());

        assertEquals("Elantris", book.getTitle());
        assertEquals("Brandon Sanderson", book.getAuthor());
        assertEquals(LocalDate.of(2005, Month.APRIL, 21), book.getDatePublished());
        assertEquals("GOLLANCZ", book.getPublisher());
    }
}
