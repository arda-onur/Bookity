package com.bookity.project.candidate.arda.onur.utility;

import com.bookity.project.candidate.arda.onur.exception.MismatchPasswordsException;
import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArgumentPreconditions {
    public static void requireNotBlank(String message, String argument) {
        if (StringUtils.isBlank(argument)) {
            throw new IllegalArgumentException(message);
        }
    }
}
