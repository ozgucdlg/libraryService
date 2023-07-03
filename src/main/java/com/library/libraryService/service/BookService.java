package com.library.libraryService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryService.dto.BookDto;
import com.library.libraryService.dto.Convert;
import com.library.libraryService.exception.BookNotFoundException;
import com.library.libraryService.model.Book;
import com.library.libraryService.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()
                ->  new BookNotFoundException("Book couldn't be found! id:" + id));
        return Convert.BookToBookDto(book);
    }

    public List<BookDto> getAllUser() {
        return bookRepository.findAll().stream().map(Convert::BookToBookDto).collect(Collectors.toList());
    }

    public BookDto getUserById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()
                ->  new BookNotFoundException("Book couldn't be found! id:" + id));
        return Convert.BookToBookDto(book);
    }

    public BookDto createUser(BookDto bookDto) {
        Book book = Convert.BookDtoToBook(bookDto);

        return Convert.BookToBookDto(bookRepository.save(book));
    }

    public BookDto updateUser(Long id, BookDto bookDto) {
        Book book = Convert.BookDtoToBook(bookDto);
        book.setId(id);

        return Convert.BookToBookDto(bookRepository.save(book));
    }

    private Book findUserById(Long id) {
        return bookRepository.findById(id).
                orElseThrow(() -> new BookNotFoundException("Book couldn't be found! id:" + id));
    }

}
