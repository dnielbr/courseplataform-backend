package com.daniel.couseplataform_backend.service.impl;

import com.daniel.couseplataform_backend.dto.request.CourseModuleCreateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseModuleUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.request.CourseUpdateRequestDto;
import com.daniel.couseplataform_backend.dto.response.CourseModuleSummaryDto;
import com.daniel.couseplataform_backend.exception.ResourceNotFoundException;
import com.daniel.couseplataform_backend.mapper.CourseModuleMapper;
import com.daniel.couseplataform_backend.model.Course;
import com.daniel.couseplataform_backend.model.CourseModule;
import com.daniel.couseplataform_backend.repository.CourseModuleRepository;
import com.daniel.couseplataform_backend.service.CourseModuleService;
import com.daniel.couseplataform_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor()
public class CourseModuleServiceImpl implements CourseModuleService {

    private final CourseModuleRepository courseModuleRepository;
    private final CourseService courseService;
    private final CourseModuleMapper courseModuleMapper;

    @Override
    public CourseModuleSummaryDto create(CourseModuleCreateRequestDto dto){
        CourseModule courseModule = courseModuleMapper.toEntity(dto);
        Course course = courseService.findEntityById(dto.courseId());
        courseModule.setCourse(course);
        return courseModuleMapper.toSummaryDto(courseModuleRepository.save(courseModule));
    }

    @Override
    public CourseModuleSummaryDto update(Long id, CourseModuleUpdateRequestDto dto){
        CourseModule courseModule = findEntityById(id);

        if(dto.title() != null && !dto.title().isBlank()){
            courseModule.setTitle(dto.title());
        }
        if(dto.description() != null && !dto.description().isBlank()){
            courseModule.setDescription(dto.description());
        }
        if(dto.order_index() != null){
            courseModule.setOrder_index(dto.order_index());
        }

        return courseModuleMapper.toSummaryDto(courseModuleRepository.save(courseModule));

    }

    @Override
    public void delete(Long id){
        CourseModule courseModule = findEntityById(id);
        courseModuleRepository.delete(courseModule);
    }

    @Override
    public CourseModule findEntityById(Long id){
        return courseModuleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course Module not found with id: " + id));
    }
}
