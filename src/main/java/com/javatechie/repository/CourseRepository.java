package com.javatechie.repository;

import com.javatechie.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}
