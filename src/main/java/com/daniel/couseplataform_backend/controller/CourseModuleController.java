package com.daniel.couseplataform_backend.controller;

import com.daniel.couseplataform_backend.dto.request.CourseModuleCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseModuleUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleSummaryDto;
import com.daniel.couseplataform_backend.service.CourseModuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/modules")
@RequiredArgsConstructor
public class CourseModuleController {

    private final CourseModuleService courseModuleService;

    @PostMapping
    public ResponseEntity<CourseModuleSummaryDto> createCourseModule(@Valid @RequestBody CourseModuleCreateRequestDto payload){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseModuleService.create(payload));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourseModule(@PathVariable Long id){
        courseModuleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<CourseModuleSummaryDto> updateCourseModule(@PathVariable Long id, @Valid @RequestBody CourseModuleUpdateRequestDto payload){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseModuleService.update(id, payload));
    }
}
