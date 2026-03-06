package com.daniel.couseplataform_backend.dto.response;

import java.time.LocalDateTime;

public record LessonResponseDto(
        Long id,
        String title,
        String description,
        String youtubeUrl,
        Integer durationSeconds,
        String thumbnailUrl,
        Integer orderIndex,
        LocalDateTime createdAt
) {
}