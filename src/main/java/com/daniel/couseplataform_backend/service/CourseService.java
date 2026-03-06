package com.daniel.couseplataform_backend.service;

import com.daniel.couseplataform_backend.dto.request.CourseUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.dto.response.PageDto;
import org.springframework.data.domain.Pageable;


public interface CourseService {
    PageDto<CourseSummaryDto> findAll(Pageable pageable);
    CourseResponseDto findById(Long id);
    CourseSummaryDto update(Long id, CourseUpdateRequestDto dto);
}
