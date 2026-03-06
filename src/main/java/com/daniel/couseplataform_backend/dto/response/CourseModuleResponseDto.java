package com.daniel.couseplataform_backend.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record CourseModuleResponseDto(
    Long id,
    String title,
    String description,
    Integer order_index,
    LocalDateTime createdAt,
    List<LessonResponseDto> lessons
) {
}