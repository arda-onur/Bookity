package com.bookity.project.candidate.arda.onur.utility;

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
