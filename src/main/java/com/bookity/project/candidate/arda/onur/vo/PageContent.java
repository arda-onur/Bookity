package com.bookity.project.candidate.arda.onur.vo;

import com.bookity.project.candidate.arda.onur.model.Book;
import lombok.Value;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

@Value(staticConstructor = "of")
public class PageContent {
    List<Book> booksFound;

    public List<Book> computePageContent(Pageable pageable) {
        Objects.requireNonNull(pageable, "Argument 'pageable' can not be null!");

        int pageStartIndex = pageable.getPageNumber() * pageable.getPageSize();
        if (this.booksFound.size() < pageStartIndex) {
            return List.of();
        } else {
            int pageEndIndex = Math.min(pageStartIndex + pageable.getPageSize(), this.booksFound.size());
            return this.booksFound.subList(pageStartIndex, pageEndIndex);
        }
    }
}
