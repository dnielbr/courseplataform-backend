package com.daniel.couseplataform_backend.service;

import com.daniel.couseplataform_backend.dto.request.CourseModuleCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseModuleUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleSummaryDto;
import com.daniel.couseplataform_backend.model.CourseModule;

public interface CourseModuleService {
    CourseModule findEntityById(Long id);
    CourseModuleSummaryDto create(CourseModuleCreateRequestDto dto);
    CourseModuleSummaryDto update(Long id, CourseModuleUpdateRequestDto dto);
    void delete(Long id);
}
