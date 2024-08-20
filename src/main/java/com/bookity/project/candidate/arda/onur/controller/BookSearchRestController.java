package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.persistence.dto.BookDto;
import com.bookity.project.candidate.arda.onur.persistence.dto.SearchRequest;
import com.bookity.project.candidate.arda.onur.persistence.mapper.BookMapper;
import com.bookity.project.candidate.arda.onur.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookSearchRestController {
    private final BookSearchService bookSearchService;
    private final BookMapper bookMapper;

    @PostMapping
    public ResponseEntity<List<BookDto>> searchBooks(@RequestBody SearchRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(List.of());
    }
}
