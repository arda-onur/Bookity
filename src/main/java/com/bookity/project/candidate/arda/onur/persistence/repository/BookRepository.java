package com.bookity.project.candidate.arda.onur.persistence.repository;

import Project.bookity.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,String> {
    @Query("SELECT book FROM BookEntity book WHERE book.bookname=:name")
    List<BookEntity> findByName(@Param("name") String name);
    @Query("SELECT book FROM BookEntity book WHERE book.isbn=:isbn")
    List<BookEntity> findByIsbn(@Param("isbn") String isbn);
    @Query("SELECT book FROM BookEntity book WHERE book.category=:category")
    List<BookEntity> findByCategory(@Param("category") String category);
}
