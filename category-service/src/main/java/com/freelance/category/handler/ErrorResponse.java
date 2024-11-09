package com.freelance.category.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
