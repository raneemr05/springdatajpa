package com.ironhack.springdatajpademo.controller;


import com.ironhack.springdatajpademo.entity.Course;
import com.ironhack.springdatajpademo.service.implementations.CourseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> addCourse(@RequestBody @Valid Course course){
        try{
            //Use the service layer add method to add the course
            courseServiceImpl.addCourse(course);
            String message = "Course Added Successfully";
            // return the response status and the message in the body
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch(Exception e){
            // Saving the error message in a variable and calling getMessage method
            // to get a detailed error message from exception class
            String errorMessage = "Course Not Added successfully" + e.getMessage();
            // return the response status and the message in the body
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PostMapping("/courses/addAll")
    public List<Course> addAllCourses(@RequestBody List<Course> courses){
        return courseServiceImpl.addAllCourses(courses);
    }

    // Delete a course
    @DeleteMapping("/courses/delete/{courseCode}")
    public String deleteCourse(@PathVariable String courseCode){
       return courseServiceImpl.deleteCourse(courseCode);
    }

    @PutMapping("/courses/update/{courseCode}")
    public String updateCourse(@PathVariable String courseCode, @RequestBody Course course){
        return courseServiceImpl.updateCourse(courseCode, course);
    }

    @PatchMapping("/courses/PatchUpdate/{courseCode}")
    public String updateCourse(@PathVariable String courseCode, @RequestBody Map<String, Object> updates) {
        return courseServiceImpl.partialUpdateCourse(courseCode, updates);
    }//

//    Get Request with Parameters
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
