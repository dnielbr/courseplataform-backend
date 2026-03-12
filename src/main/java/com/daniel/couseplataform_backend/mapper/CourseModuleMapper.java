package com.daniel.couseplataform_backend.mapper;

import com.daniel.couseplataform_backend.dto.request.CourseCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseModuleCreateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleSummaryDto;
import com.daniel.couseplataform_backend.model.CourseModule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface CourseModuleMapper {
    //target é o campo da entidade destino, source é de onde vem o valor

    CourseModule toEntity(CourseModuleCreateRequestDto dto);
    CourseModuleSummaryDto toSummaryDto(CourseModule courseModule);
    CourseModuleResponseDto toDto(CourseModule courseModule);
    List<CourseModuleResponseDto> toDto(List<CourseModule> courseModules);

}
