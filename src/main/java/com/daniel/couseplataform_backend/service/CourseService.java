package com.daniel.couseplataform_backend.service;

import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import java.util.List;

public interface CourseService {
    List<CourseSummaryDto> findAll();
}
