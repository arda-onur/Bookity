package com.bookity.project.candidate.arda.onur.persistence.dto;

import java.io.Serial;
import java.io.Serializable;

public record CustomerDto(
        String email,
        String password) implements Serializable   {
    @Serial
    private static final long serialVersionUID = 83498734252853342L;

}
