package com.cosmere.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.cosmere.books.Books;
import com.cosmere.repository.BookRepository;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Books("Elantris")));
            log.info("Preloading " + repository.save(new Books("Warbreaker")));

        };
    }
}
