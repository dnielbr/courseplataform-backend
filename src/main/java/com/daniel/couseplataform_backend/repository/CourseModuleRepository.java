package com.daniel.couseplataform_backend.repository;

import com.daniel.couseplataform_backend.model.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {
}
