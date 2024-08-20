package com.bookity.project.candidate.arda.onur.vo;

import com.bookity.project.candidate.arda.onur.constant.CriteriaTypes;
import com.bookity.project.candidate.arda.onur.dto.SearchRequest;
import com.bookity.project.candidate.arda.onur.model.Book;
import com.bookity.project.candidate.arda.onur.persistence.repository.SearchBookRepository;
import lombok.Value;

import java.util.List;
import java.util.Objects;

@Value(staticConstructor = "of")
public class BookRetrieval {
    private static final List<Book> EMPTY_BOOK_LIST = List.of();
    SearchBookRepository searchBookRepository;

    public List<Book> retrievedBooks(SearchRequest searchRequest) {
        Objects.requireNonNull(searchRequest, "Argument 'searchRequest' can not be null!");
        return switch (CriteriaTypes.valueOf(searchRequest.getCriteria().toUpperCase())) {
            case CATEGORY -> this.searchBookRepository.findAllByCategoryContainingIgnoreCase(
                    searchRequest.getSearchKey().toLowerCase())
                .orElse(EMPTY_BOOK_LIST);
            case TITLE ->
                this.searchBookRepository.findAllByTitleContainingIgnoreCase(searchRequest.getSearchKey().toLowerCase())
                    .orElse(EMPTY_BOOK_LIST);
            case ISBN -> this.searchBookRepository.findAllByIsbnContaining(searchRequest.getSearchKey().toLowerCase())
                .orElse(EMPTY_BOOK_LIST);
            default -> EMPTY_BOOK_LIST;
        };
    }
}
