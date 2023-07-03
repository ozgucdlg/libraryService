package com.library.libraryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.libraryService.model.Book;

public interface BookRepository  extends JpaRepository<Book,Long> {
}