package com.daniel.couseplataform_backend.service.impl;

import com.daniel.couseplataform_backend.dto.request.CourseCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseUpdateRequestDto;
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
        Page<CourseSummaryDto> coursePage = courseRepository.findAll(pageable).map(courseMapper::toDto);
        return new PageDto<>(coursePage);
    }

    @Override
    public CourseResponseDto  findById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
        return courseMapper.toCourseDto(course);
    }

    @Override
    public CourseSummaryDto update(Long id, CourseUpdateRequestDto dto){
        log.info("Update Course");
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));

        if(dto.title() != null && !dto.title().isBlank()){
            course.setTitle(dto.title());
        }
        if(dto.description() != null && !dto.description().isBlank()){
            course.setDescription(dto.description());
        }
        if(dto.thumbnailUrl() != null && !dto.thumbnailUrl().isBlank()){
            course.setThumbnailUrl(dto.thumbnailUrl());
        }
        if(dto.level() != null){
            course.setLevel(dto.level());
        }

        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public CourseSummaryDto create(CourseCreateRequestDto dto){
        Course course = courseMapper.toEntity(dto);
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public void delete(Long id){
        courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
        courseRepository.deleteById(id);
    }

}
