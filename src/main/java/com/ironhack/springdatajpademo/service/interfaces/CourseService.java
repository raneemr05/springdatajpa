package com.ironhack.springdatajpademo.service.interfaces;

import com.ironhack.springdatajpademo.entity.Course;

import java.util.List;

public interface CourseService {

    //1. Fetch/Get the list of all courses
    public List<Course> getAllCourses();

    public Course addCourse(Course course);

    public List<Course> addAllCourses(List<Course> courses);
}
