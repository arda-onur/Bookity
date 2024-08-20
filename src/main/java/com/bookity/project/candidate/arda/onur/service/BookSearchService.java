package com.bookity.project.candidate.arda.onur.service;

import com.bookity.project.candidate.arda.onur.dto.SearchRequest;
import com.bookity.project.candidate.arda.onur.model.Book;
import com.bookity.project.candidate.arda.onur.persistence.repository.SearchBookRepository;
import com.bookity.project.candidate.arda.onur.vo.BookRetrieval;
import com.bookity.project.candidate.arda.onur.vo.PageContent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookSearchService {
    private final SearchBookRepository searchBookRepository;

    public Optional<Page<Book>> searchBooks(SearchRequest searchRequest, Pageable pageable) {
        Objects.requireNonNull(searchRequest, "Argument 'searchRequest' can not be null!");
        Objects.requireNonNull(pageable, "Argument 'pageable' can not be null!");

        List<Book> booksFound = BookRetrieval.of(this.searchBookRepository).retrievedBooks(searchRequest);
        List<Book> pageList = PageContent.of(booksFound).computePageContent(pageable);
        return Optional.of(new PageImpl<>(pageList, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            booksFound.size()));
    }
}
