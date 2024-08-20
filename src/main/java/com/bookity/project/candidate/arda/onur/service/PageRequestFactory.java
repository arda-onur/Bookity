package com.bookity.project.candidate.arda.onur.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PageRequestFactory {
    public PageRequest createPageRequest(Pageable pageable) {
        Objects.requireNonNull(pageable, "Argument 'pageable' can not be null!");
        return PageRequest.of(
            (pageable.getPageNumber() == 0 ? pageable.getPageNumber() : pageable.getPageNumber() - 1),
            pageable.getPageSize());
    }
}
