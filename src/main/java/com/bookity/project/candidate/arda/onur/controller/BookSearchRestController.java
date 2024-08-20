package com.bookity.project.candidate.arda.onur.controller;

import com.bookity.project.candidate.arda.onur.dto.BookDto;
import com.bookity.project.candidate.arda.onur.dto.SearchRequest;
import com.bookity.project.candidate.arda.onur.mapper.BookMapper;
import com.bookity.project.candidate.arda.onur.service.BookSearchService;
import com.bookity.project.candidate.arda.onur.service.PageRequestFactory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
@Slf4j
public class BookSearchRestController {
    private final BookSearchService bookSearchService;
    private final PageRequestFactory pageRequestFactory;
    private final BookMapper bookMapper;

    @PostMapping
    public ResponseEntity<List<BookDto>> searchBooks(@Valid @RequestBody SearchRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(this.bookMapper.map(
            this.bookSearchService.searchBooks(searchRequest, this.pageRequestFactory.createPageRequest(pageable))
                .orElseGet(() -> {
                    log.warn("Could not find any data for the specified search request!");
                    return Page.empty();
                })
                .getContent()));
    }
}
