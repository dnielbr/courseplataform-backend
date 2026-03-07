package com.daniel.couseplataform_backend.controller;

import com.daniel.couseplataform_backend.dto.request.CourseCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseResponseDto;
import com.daniel.couseplataform_backend.dto.response.CourseSummaryDto;
import com.daniel.couseplataform_backend.dto.response.PageDto;
import com.daniel.couseplataform_backend.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
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

    @PutMapping("{id}")
    public ResponseEntity<CourseSummaryDto> updateCourseById(@PathVariable Long id, @RequestBody CourseUpdateRequestDto payload){
        return ResponseEntity.ok(courseService.update(id, payload));
    }

    @PostMapping
    public ResponseEntity<CourseSummaryDto> createCourse(@Valid @RequestBody CourseCreateRequestDto payload){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(payload));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}