package com.bookity.project.candidate.arda.onur.controller;

import Project.bookity.Entity.BookEntity;
import Project.bookity.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookCrudRestController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<BookEntity> getBooksBy(@RequestParam String input, @RequestParam String category) {
        return bookService.getBooksBy(input, category);
    }
}
