package com.daniel.couseplataform_backend.service.impl;

import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.model.Course;
import com.daniel.couseplataform_backend.repository.CourseRepository;
import com.daniel.couseplataform_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseSummaryDto> findAll() {
        log.info("In CourseServiceImpl.findAll()");
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> new CourseSummaryDto(
                        course.getId(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getThumbnailUrl(),
                        course.getLevel(),
                        course.getCreatedAt(),
                        course.getUpdatedAt()))
                .toList();
    }
}
