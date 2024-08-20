package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.persistence.model.Book;
import com.bookity.project.candidate.arda.onur.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookSearchService {
    private final BookRepository bookRepository;

    public List<Book> getBooksBy(String input, String category) {
        log.info("Getting Books {} {}", category, input);
        if ("NAME".equals(category)) {
            return bookRepository.findByBookNameLike(input).get();
        } else if ("ISBN".equals(category)) {
            return bookRepository.findByIsbn(input);
        } else
            return bookRepository.findByCategory(input);
    }
}
