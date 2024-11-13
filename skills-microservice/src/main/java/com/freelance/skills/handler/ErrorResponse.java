package com.freelance.skills.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
