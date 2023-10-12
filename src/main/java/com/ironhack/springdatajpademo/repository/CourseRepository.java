package com.ironhack.springdatajpademo.repository;

import com.ironhack.springdatajpademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    Course findByCourseName(String courseName);
    Course findByCourseNameLike(String courseName);

}
