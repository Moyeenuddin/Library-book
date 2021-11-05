package com.library.api.controller;

import com.library.api.exception.ResourceNotFoundException;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    //Get mathod
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Save
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //get by id
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        return ResponseEntity.ok(book);
    }

    //Update
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book bookDetails) {
        Book updateBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));

        updateBook.setName(bookDetails.getName());
        updateBook.setAuthor(bookDetails.getAuthor());

        bookRepository.save(updateBook);

        return ResponseEntity.ok(updateBook);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));

        bookRepository.delete(book);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
