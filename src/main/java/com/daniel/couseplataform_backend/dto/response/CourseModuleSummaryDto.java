package com.daniel.couseplataform_backend.dto.response;

import java.time.LocalDateTime;

public record CourseModuleSummaryDto(
        Long id,
        String title,
        String description,
        Integer order_index,
        LocalDateTime createdAt
) {
}
