package com.daniel.couseplataform_backend.repository;

import com.daniel.couseplataform_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
