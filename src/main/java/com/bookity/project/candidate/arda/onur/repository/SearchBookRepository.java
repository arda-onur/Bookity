package com.bookity.project.candidate.arda.onur.persistence.repository;

import com.bookity.project.candidate.arda.onur.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchBookRepository extends JpaRepository<Book, String> {
    Optional<List<Book>> findAllByTitleContainingIgnoreCase(String title);

    Optional<List<Book>> findAllByCategoryContainingIgnoreCase(String category);

    Optional<List<Book>> findAllByIsbnContaining(String isbn);
}
