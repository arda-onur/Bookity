package com.bookity.project.candidate.arda.onur.controller;

import Project.bookity.Entity.BookEntity;
import com.bookity.project.candidate.arda.onur.service.BookCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookCrudRestController {
    private final BookCrudService bookCrudService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookCrudService.getAllBooks();
    }

    @GetMapping("/search")
    public List<BookEntity> getBooksBy(@RequestParam String input, @RequestParam String category) {
        return bookCrudService.getBooksBy(input, category);
    }
}
