package com.daniel.couseplataform_backend.service.impl;

import com.daniel.couseplataform_backend.dto.response.CourseResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.dto.response.PageDto;
import com.daniel.couseplataform_backend.exception.ResourceNotFoundException;
import com.daniel.couseplataform_backend.mapper.CourseMapper;
import com.daniel.couseplataform_backend.model.Course;
import com.daniel.couseplataform_backend.repository.CourseRepository;
import com.daniel.couseplataform_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public PageDto<CourseSummaryDto> findAll(Pageable pageable) {

        Page<Course> coursePage = courseRepository.findAll(pageable);
        List<CourseSummaryDto> courseSummaries = coursePage.getContent().stream()
                .map(courseMapper::toDto)
                .toList();

        return new PageDto<>(
                courseSummaries,
                coursePage.getSize(),
                coursePage.getTotalElements(),
                coursePage.getTotalPages(),
                coursePage.isLast(),
                coursePage.isFirst(),
                coursePage.hasNext(),
                coursePage.hasPrevious());
    }

    @Override
    public CourseResponseDto  findById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
        return courseMapper.toCourseDto(course);
    }

}
