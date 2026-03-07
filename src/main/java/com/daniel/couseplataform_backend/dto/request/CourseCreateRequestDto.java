package com.daniel.couseplataform_backend.dto.request;

import com.daniel.couseplataform_backend.model.enums.ELevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record CourseCreateRequestDto(
        @NotBlank(message = "title is required")
        @Size(min = 3, max = 100)
        String title,
        @Size(min = 3, max = 250)
        String description,
        @NotBlank(message = "description")
        @Size(min = 3, max = 250)
        String thumbnailUrl,
        @NotNull(message = "level is required")
        ELevel level
) {
}

