package com.ironhack.springdatajpademo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.springdatajpademo.entity.Course;
import com.ironhack.springdatajpademo.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CourseControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CourseRepository courseRepository;

    private MockMvc mockMvc;

    // to convert JSON to POJO and vice versa
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Course course1 = new Course("CS505", "Website Development");
        Course course2 = new Course("CS503", "Mobile App development");
        courseRepository.saveAll(List.of(course1,course2));
    }

    @AfterEach
    public void flushResources(){
        courseRepository.deleteAll();
    }

    @Test
    void getAllCoursesTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("abcsde"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("bahsbdjk"));
    }

    @Test
    void PostCourseTest() throws Exception {
        //Create a new object to add
        Course newCourse = new Course("CS606","Any new course");
        // Convert the object to JSON
        String requestBody = objectMapper.writeValueAsString(newCourse);

        //MockMvc post request
        MvcResult mvcResult =
        mockMvc.perform(post("/courses/add")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Course Added Successfully"));
    }



}