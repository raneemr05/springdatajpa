package com.ironhack.springdatajpademo.service.implementations;

import com.ironhack.springdatajpademo.entity.Course;
import com.ironhack.springdatajpademo.repository.CourseRepository;
import com.ironhack.springdatajpademo.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> addAllCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }
}
