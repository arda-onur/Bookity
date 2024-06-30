package com.bookity.project.candidate.arda.onur.persistence.dto;

import java.io.Serial;
import java.io.Serializable;

public record BookDto(
    String isbn,
    String bookName,
    String imageUrl) implements Serializable {

    @Serial
    private static final long serialVersionUID = 5509873642328532413L;
}
