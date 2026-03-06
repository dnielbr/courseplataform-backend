package com.daniel.couseplataform_backend.mapper;

import com.daniel.couseplataform_backend.dto.response.LessonResponseDto;
import com.daniel.couseplataform_backend.model.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonResponseDto toDto(Lesson lesson);
    List<LessonResponseDto> toDto(List<Lesson> lessons);
}
