package com.cosmere.books;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Books {

    private @Id @GeneratedValue Long id;
    private String title;
    private LocalDate datePublished;
    private String author;
    private String publisher;

    public Books() {
    }

    public Books(String title) {
        this.title = title;
    }

    public Books(String title, LocalDate datePublished, String author, String publisher) {
        this.title = title;
        this.datePublished = datePublished;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDatePublished() {
        return this.datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Books title(String title) {
        setTitle(title);
        return this;
    }

    public Books datePublished(LocalDate datePublished) {
        setDatePublished(datePublished);
        return this;
    }

    public Books author(String author) {
        setAuthor(author);
        return this;
    }

    public Books publisher(String publisher) {
        setPublisher(publisher);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Books)) {
            return false;
        }
        Books books = (Books) o;
        return Objects.equals(title, books.title) && Objects.equals(datePublished, books.datePublished)
                && Objects.equals(author, books.author) && Objects.equals(publisher, books.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, datePublished, author, publisher);
    }

    @Override
    public String toString() {
        return "{" +
                " title='" + getTitle() + "'" +
                ", datePublished='" + getDatePublished() + "'" +
                ", author='" + getAuthor() + "'" +
                ", publisher='" + getPublisher() + "'" +
                "}";
    }
}
