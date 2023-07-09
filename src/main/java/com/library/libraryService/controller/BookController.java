package com.library.libraryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryService.dto.BookDto;
import com.library.libraryService.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAllUser() {
        return ResponseEntity.ok(bookService.getAllUser());
    }

    @GetMapping("book/{id}")
    public ResponseEntity<BookDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<BookDto> createUser(@RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.createUser(book));
    }

    @PutMapping("book/{id}")
    public ResponseEntity<BookDto> updateUser(@PathVariable Long id,
                                              @RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.updateUser(id,book));
    }
    
    
}