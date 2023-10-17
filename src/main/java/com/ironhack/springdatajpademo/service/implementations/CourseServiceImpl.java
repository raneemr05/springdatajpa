package com.ironhack.springdatajpademo.service.implementations;

import com.ironhack.springdatajpademo.entity.Course;
import com.ironhack.springdatajpademo.repository.CourseRepository;
import com.ironhack.springdatajpademo.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public String deleteCourse(String courseCode) {
        if(courseRepository.existsById(courseCode))
        {
            courseRepository.deleteById(courseCode);
            return "Course deleted Successfully";
        }
        else{
            return  "Course not found";
        }
    }

    @Override
    public String updateCourse(String courseCode, Course course) {
        //1. Find the Id
         Optional<Course> courseFound = courseRepository.findById(courseCode);
            if(courseFound.isPresent()){
                //2. Update the courseName
                course.setCourseName(course.getCourseName());
                //3. Save it in the Database
                courseRepository.save(course);
                return "Course Details Updated";
            }
            else
            {
                return "Course with course code " + courseCode + " not found";
            }
    }
    @Override
    public String partialUpdateCourse(String courseCode, Map<String, Object> updates) {
        Optional<Course> courseFound = courseRepository.findById(courseCode);
        if (courseFound.isPresent()) {
            Course existingCourse = courseFound.get();

            if (updates.containsKey("courseName")) {
                existingCourse.setCourseName((String) updates.get("courseName"));
            }

            courseRepository.save(existingCourse);
            return "Course updated using patch ";
        } else
        {
            return "Course Not Found";
        }
    }
}
