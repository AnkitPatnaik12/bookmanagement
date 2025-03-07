package com.project.bookmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookId;
    private String bookTitle;
    private String author;
    private String genre;
    private String price;
}
