package com.ironhack.springdatajpademo.controller;


import com.ironhack.springdatajpademo.entity.Course;
import com.ironhack.springdatajpademo.repository.CourseRepository;
import com.ironhack.springdatajpademo.service.implementations.CourseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseControllerImpl {

//    @Autowired
//    private CourseRepository courseRepository;

    @Autowired
    private CourseServiceImpl courseServiceImpl;
    // GET method

    @GetMapping("/")
    public String helloWorld(){
        return  "Hello and Welcome";
    }

    @GetMapping("/welcome")
    public String greetingUser(){
      return "Welcome User";
    }

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses(){
        //return courseRepository.findAll();
        return courseServiceImpl.getAllCourses();
    }

    //A Post method to Add a new course
    @PostMapping("/courses/add")
    public Course addCourse(@RequestBody @Valid Course course){
        return courseServiceImpl.addCourse(course);
    }

    @PostMapping("/courses/addAll")
    public List<Course> addAllCourses(@RequestBody List<Course> courses){
        return courseServiceImpl.addAllCourses(courses);
    }
//
//    //Get Request with Parameters
//
//    // 1. Using Path Variable
//    @GetMapping("/courses/{courseCode}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<Course> getCourseByCode(@PathVariable String courseCode){
//        return courseRepository.findById(courseCode);
//    }
//
//    //2. Using Query Parameter
//    @GetMapping("/courses/courseCode") // ?courseCode = "......"
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<Course> getCourseByCodeQueryParam(@RequestParam String courseCode){
//        return courseRepository.findById(courseCode);
//    }

}
