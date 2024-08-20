/**
 * [REGISTER]
 * Project : bookity
 * User    : pasmakoglu
 * Date    : 3/9/2019
 * Time    : 6:23 AM
 */
package com.bookity.project.candidate.arda.onur.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CriteriaTypes {
    CRITERIA("Criteria"),
    TITLE("Title"),
    CATEGORY("Category"),
    ISBN("ISBN");

    private final String criteriaType;
}
