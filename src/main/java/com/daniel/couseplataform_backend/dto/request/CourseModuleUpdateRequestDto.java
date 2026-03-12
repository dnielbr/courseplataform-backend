package com.daniel.couseplataform_backend.dto.request;

public record CourseModuleUpdateRequestDto(
        String title,
        String description,
        Integer order_index
) {
}
