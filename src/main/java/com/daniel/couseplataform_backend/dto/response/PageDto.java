package com.daniel.couseplataform_backend.dto.response;

import java.util.List;

public record PageDto<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last,
        boolean first,
        boolean hasNext,
        boolean hasPrevious
) {
}
