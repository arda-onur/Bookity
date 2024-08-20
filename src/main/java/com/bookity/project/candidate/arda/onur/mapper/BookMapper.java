package com.bookity.project.candidate.arda.onur.mapper;

import com.bookity.project.candidate.arda.onur.dto.BookDto;
import com.bookity.project.candidate.arda.onur.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface BookMapper {
    BookDto map(Book book);

    List<BookDto> map(List<Book> books);
}
