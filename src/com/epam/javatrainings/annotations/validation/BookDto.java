package com.epam.javatrainings.annotations.validation;

import java.util.Set;

public class BookDto {
    @Length(min = 1, max = 4)
    private Set<String> authors;

    @Email
    @Length
    private String publisher;

    @Min(50)
    private int pages;

    @Min(100)
    @Max(1000)
    private int price;

    public BookDto(Set authors, String publisher, int pages, int price) {
        this.authors = authors;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
    }
}
