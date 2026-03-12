package com.daniel.couseplataform_backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseModuleCreateRequestDto(
        @NotNull(message = "course_id is required")
        Long courseId,
        @NotBlank(message = "title is required")
        @Size(min = 3, max = 100)
        String title,
        @Size(min = 3, max = 250)
        String description,
        @NotNull(message = "order_index is required")
        Integer order_index
) {
}
