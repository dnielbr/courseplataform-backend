package com.daniel.couseplataform_backend.service;

import com.daniel.couseplataform_backend.dto.request.CourseModuleCreateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleSummaryDto;

public interface CourseModuleService {
    CourseModuleSummaryDto create(CourseModuleCreateRequestDto dto);
    //CourseModuleSummaryDto update(Long id, CourseModuleUpdateRequestDto dto);
    //void delete(Long id);
}
