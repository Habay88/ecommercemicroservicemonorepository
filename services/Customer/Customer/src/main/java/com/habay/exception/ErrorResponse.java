package com.habay.exception;

import java.util.Map;
import java.util.Set;

public record ErrorResponse(
        Map<String, String> errors
) {

}

