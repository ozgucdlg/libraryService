package com.library.libraryService.dto;

import com.library.libraryService.model.Book;

public class Convert {
	
	 public  static Book BookDtoToBook(BookDto bookDto){
	        Book book =new Book();
	        book.setId(bookDto.getId());
	        book.setBookName(bookDto.getBookName());
	        book.setPageNumber(bookDto.getPageNumber());
	        book.setReleaseDate(bookDto.getReleaseDate());
	        return  book;
	    }

	    public  static BookDto  BookToBookDto(Book book){
	        BookDto bookDto =new BookDto();
	        bookDto.setId(book.getId());
	        bookDto.setBookName(book.getBookName());
	        bookDto.setPageNumber(book.getPageNumber());
	        bookDto.setReleaseDate(book.getReleaseDate());
	        return  bookDto;
	    }

}
