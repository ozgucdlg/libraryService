package com.library.libraryService.dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BookDto {
    private Long id;
    private String bookName;
    private String pageNumber;
    private  Date releaseDate;
}