package com.bookity.project.candidate.arda.onur.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterNewUserRegexPatterns {
    public static final String EMAIL_PATTERN = "^" + "([a-zA-Z0-9_\\.\\-+])+" // local
        + "@" + "[a-zA-Z0-9-.]+" // domain
        + "\\." + "[a-zA-Z0-9-]{2,}" // tld
        + "$";
}
