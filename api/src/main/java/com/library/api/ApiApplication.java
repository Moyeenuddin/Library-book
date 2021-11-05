package com.library.api;

import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
//        Book book = new Book();
//        book.setName("Lin T U");
//        book.setAuthor("Del Cor");
//        bookRepository.save(book);
//
//        Book book1 = new Book();
//        book1.setName("A Brief History of Time");
//        book1.setAuthor("St. H");
//        bookRepository.save(book1);

    }
}
