package com.daniel.couseplataform_backend.dto.response;

import com.daniel.couseplataform_backend.model.enums.ELevel;

import java.time.LocalDateTime;

public record CourseSummaryDto(
    Long id,
    String title,
    String description,
    String thumbnailUrl,
    ELevel level,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
