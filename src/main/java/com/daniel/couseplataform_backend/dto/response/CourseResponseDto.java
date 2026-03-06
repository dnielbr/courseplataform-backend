package com.daniel.couseplataform_backend.dto.response;

import com.daniel.couseplataform_backend.model.enums.ELevel;

import java.time.LocalDateTime;
import java.util.List;

public record CourseResponseDto(
        Long id,
        String title,
        String description,
        String thumbnailUrl,
        ELevel level,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<CourseModuleResponseDto> courseModules
) {
}
