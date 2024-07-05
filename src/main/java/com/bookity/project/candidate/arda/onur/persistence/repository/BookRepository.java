package com.bookity.project.candidate.arda.onur.persistence.repository;

import com.bookity.project.candidate.arda.onur.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<List<Book>> findByBookNameLike(String bookName);


    @Query("SELECT book FROM Book book WHERE book.isbn=:isbn")
    List<Book> findByIsbn(@Param("isbn") String isbn);
    @Query("SELECT book FROM Book book WHERE book.category=:category")
    List<Book> findByCategory(@Param("category") String category);
}
