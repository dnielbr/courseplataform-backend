package com.daniel.couseplataform_backend.dto.request;

import com.daniel.couseplataform_backend.model.enums.ELevel;

public record CourseUpdateRequestDto(
        String title,
        String description,
        String thumbnailUrl,
        ELevel level
) {
}
