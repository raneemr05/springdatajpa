package com.ironhack.springdatajpademo.repository;

import com.ironhack.springdatajpademo.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Course course1;
    private Course course2;

    // Inserting record into the database
    @BeforeEach
    public void insertToTheDB(){
        course1 = new Course("CS101","Introduction to Java");
        courseRepository.save(course1);
        course2 = new Course("CS201", "Mobile application development");
        courseRepository.save(course2);
    }

    //finding record from the database
    @Test
    public void FindCourseById(){
        Optional<Course> courseFromDB = courseRepository.findById("CS301");
        assertTrue(courseFromDB.isPresent());
        assertEquals(course1, courseFromDB.get());
    }

    @Test
    public void FindByCourseName(){
        Course course3 = courseRepository.findByCourseName("Introduction to Java");
        assertEquals(course3.getCourseName(), "Introduction to Java");
    }

//    @Test
//    public void FindByCourseNameLike(){
//        Course course4 = courseRepository.findByCourseNameLike("%a");
//        assertEquals(course4.getCourseName(), "Introduction to Jav");
//    }



}