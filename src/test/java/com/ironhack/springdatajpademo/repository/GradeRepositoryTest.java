//package com.ironhack.springdatajpademo.repository;
//
//import com.ironhack.springdatajpademo.entity.Course;
//import com.ironhack.springdatajpademo.entity.Grade;
//import com.ironhack.springdatajpademo.entity.Section;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//class GradeRepositoryTest {
//
//    @Autowired
//    private GradeRepository gradeRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private SectionRepository sectionRepository;
//
//
//
////    private Grade grade1;
////    private Grade grade2;
//
//    private List<Grade> grades;
//    private List<Course> courses;
//
//    private List<Section> sections;
//
//    @BeforeEach
//    public void setUp(){
//
//        courses = courseRepository.saveAll(
//                List.of(
//                        new Course("CS101", "Intro to java"),
//                        new Course("CS103", "Databases")
//                )
//        );
//
//        grades = gradeRepository.saveAll(
//                List.of(
//                        new Grade("Maya Charlotte", "CS101-A", 98),
//                        new Grade("James Fields", "CS101-A", 82),
//                        new Grade("Michael Alcocer", "CS101-B", 65),
//                        new Grade("Maya Charlotte", "CS103-A", 89),
//                        new Grade("Tomas Lacroix", "CS101-A", 99),
//                        new Grade("Sara Bisat", "CS101-A", 87),
//                        new Grade("James Fields", "CS101-B", 46),
//                        new Grade("Helena Sepulvida", "CS103-A", 72)
//                )
//        );
//
//        sections = sectionRepository.saveAll(List.of(
//                new Section("CS101-A", "CS101",  (short) 1802, "Balderez"),
//                new Section("CS101-B", "CS101",  (short) 1650, "Su"),
//                new Section("CS103-A", "CS103",  (short) 1200, "Rojas"),
//                new Section("CS103-B", "CS103",  (short) 1208, "Tonno")
//        ));
//
////        grade1 = new Grade("Michael Alcocer", "CS103-A", 65);
////        gradeRepository.save(grade1);
//
////        grade2 = new Grade("Maya Charlotte", "CS101-A", 98);
////        gradeRepository.save(grade2);
//    }
//
//    @AfterEach
//    public void removeAll(){
//        gradeRepository.deleteAll();
//        sectionRepository.deleteAll();
//        courseRepository.deleteAll();
//    }
//
//    @Test
//    public void FindAllGrades(){
//        List<Grade> gradeList = gradeRepository.findAll();
//        assertEquals(2, gradeList.size());
//    }
//
//    @Test
//    void findAverageScoreBySection(){
//        List<Object[]> results = gradeRepository.findAverageScoreBySection();
//        assertEquals(3, results.size());
//        assertEquals(55.5, results.get(1)[1]);
//    }
//
//    @Test
//    void findAverageScoreBySectionWithCapacity(){
//        List<Object[]> results = gradeRepository.findAverageScoreBySectionWithCapacity(2);
//        assertEquals("CS101-B", results.get(0)[0]);
//        assertEquals(55.5, results.get(0)[1]);
//    }
//
//    @Test
//    void findAverageScoreBySectionWithCapacityNamed(){
//        List<Object[]> results = gradeRepository.findAverageScoreBySectionWithCapacityNamed(2);
//        assertEquals("CS101-B", results.get(0)[0]);
//        assertEquals(55.5, results.get(0)[1]);
//    }
//
//    @Test
//    void findAverageScoreBySectionWithMinimumScore(){
//        List<Object[]> results = gradeRepository.findAverageScoreBySectionWithNative(80);
//        assertEquals("Michael Alcocer", results.get(0)[0]);
//        assertEquals(65.0, results.get(0)[1]);
//    }
//
//    @Test
//    void findStudentNameAndScore(){
//        List<Object[]> results = gradeRepository.findStudentNameAndScore("Maya Charlotte", 98 );
//        // Outer loop to iterate over the list
//        for(Object[] row : results){
//            // Inner loop to display the values of each object
//            for(Object obj : row){
//                System.out.println(obj.toString() + " ");
//            }
//            System.out.println(); // A new line after each record
//        }
//    }
//
//
//
//}