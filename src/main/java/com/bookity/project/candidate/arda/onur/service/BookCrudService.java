package com.bookity.project.candidate.arda.onur.service;

import Project.bookity.Entity.BookEntity;
import com.bookity.project.candidate.arda.onur.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookCrudService {
    private final BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        log.info("Getting all Books");
        return bookRepository.findAll();
    }

    public List<BookEntity> getBooksBy(String input, String category) {
        log.info("Getting Books {} {}", category, input);
        if ("NAME".equals(category)) {
            return bookRepository.findByName(input);
        } else if ("ISBN".equals(category)) {
            return bookRepository.findByIsbn(input);
        } else
            return bookRepository.findByCategory(input);
    }
}
