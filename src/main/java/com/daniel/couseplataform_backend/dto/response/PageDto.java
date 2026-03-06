package com.daniel.couseplataform_backend.dto.response;

import java.util.List;

public record PageDto<T>(
        List<T> content,
        int size,
        long totalElements,
        int totalPages,
        boolean last,
        boolean fist,
        boolean hasNext,
        boolean hasPrevious
) {
}
