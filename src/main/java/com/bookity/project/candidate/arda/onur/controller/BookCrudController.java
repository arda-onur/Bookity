package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.persistence.dto.BookDto;
import com.bookity.project.candidate.arda.onur.persistence.mapper.BookMapper;
import com.bookity.project.candidate.arda.onur.service.BookCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookCrudController {
    private final BookCrudService bookCrudService;
    private final BookMapper bookMapper;

    @GetMapping
    public String getAllBooks(Model model) {
    List<BookDto> books = this.bookMapper.map(this.bookCrudService.getAllBooks());
    model.addAttribute("books", books);
    return "main";
    }


    public List<BookDto> getBooksBy(@RequestParam String input, @RequestParam String category) {
        return this.bookMapper.map(this.bookCrudService.getBooksBy(input, category));
    }
}
