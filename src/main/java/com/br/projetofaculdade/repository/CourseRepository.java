package com.br.projetofaculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projetofaculdade.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
