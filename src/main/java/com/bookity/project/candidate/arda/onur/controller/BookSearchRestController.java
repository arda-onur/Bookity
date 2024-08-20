package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.persistence.dto.BookDto;
import com.bookity.project.candidate.arda.onur.persistence.mapper.BookMapper;
import com.bookity.project.candidate.arda.onur.service.BookCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookCrudRestController {
    private final BookCrudService bookCrudService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return this.bookMapper.map(this.bookCrudService.getAllBooks());
    }

    @GetMapping("/search")
    public List<BookDto> getBooksBy(@RequestParam String input, @RequestParam String category) {
        return this.bookMapper.map(this.bookCrudService.getBooksBy(input, category));
    }
}
