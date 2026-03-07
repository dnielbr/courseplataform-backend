package com.daniel.couseplataform_backend.dto.response;

import org.springframework.data.domain.Page;

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
    public PageDto(Page<T> page){
        this(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast(),
                page.isFirst(),
                page.hasNext(),
                page.hasPrevious()
        );
    }
}
