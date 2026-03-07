package com.daniel.couseplataform_backend.mapper;

import com.daniel.couseplataform_backend.dto.request.CourseCreateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CourseModuleMapper.class)
public interface CourseMapper {

    Course toEntity(CourseCreateRequestDto dto);

    CourseResponseDto toCourseDto(Course course);
    CourseSummaryDto toDto(Course course);

    List<CourseSummaryDto> toDto(List<Course> courses);
}
