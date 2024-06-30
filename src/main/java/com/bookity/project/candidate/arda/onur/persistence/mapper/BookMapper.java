package com.bookity.project.candidate.arda.onur.persistence.mapper;

import com.bookity.project.candidate.arda.onur.persistence.dto.BookDto;
import com.bookity.project.candidate.arda.onur.persistence.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface BookMapper {
    BookDto map(Book book);

    List<BookDto> map(List<Book> books);
}
