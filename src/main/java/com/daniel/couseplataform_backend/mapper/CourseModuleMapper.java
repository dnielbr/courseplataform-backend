package com.daniel.couseplataform_backend.mapper;

import com.daniel.couseplataform_backend.dto.response.CourseModuleResponseDto;
import com.daniel.couseplataform_backend.model.CourseModule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface CourseModuleMapper {

    CourseModuleResponseDto toDto(CourseModule courseModule);
    List<CourseModuleResponseDto> toDto(List<CourseModule> courseModules);

}
