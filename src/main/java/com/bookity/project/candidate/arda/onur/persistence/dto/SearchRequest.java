package com.bookity.project.candidate.arda.onur.persistence.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 6950381811507424763L;

    @NotBlank(message = "{search.request.criteria.not.blank.message}")
    private String criteria;

    @NotBlank(message = "{search.request.search.key.not.blank.message}")
    private String searchKey;
}
