package com.daniel.couseplataform_backend.controller;

import com.daniel.couseplataform_backend.dto.response.CourseResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.dto.response.PageDto;
import com.daniel.couseplataform_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<PageDto<CourseSummaryDto>> getAllCourses(Pageable pageable){
        return ResponseEntity.ok(courseService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

}