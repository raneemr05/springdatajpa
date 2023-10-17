package com.ironhack.springdatajpademo.service.interfaces;

import com.ironhack.springdatajpademo.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    //1. Fetch/Get the list of all courses
    public List<Course> getAllCourses();

    public Course addCourse(Course course);

    public List<Course> addAllCourses(List<Course> courses);

    String deleteCourse(String courseCode);

    String updateCourse(String courseCode, Course course);

    String partialUpdateCourse(String courseCode, Map<String, Object> updates);
}
