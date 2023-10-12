package com.ironhack.springdatajpademo.repository;

import com.ironhack.springdatajpademo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    //    Grade findByStudentNameAndSectionId(String studentName, String sectionId);


    // Query to find the average score of the students
    // grouped by section
    // ordered by the average ascending

    // Using JPQL
    @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId ORDER BY AVG(score) ASC")
    List<Object[]> findAverageScoreBySection();

    // Parameters in JPQL
    // ?1 --> this ? indicates Positional Bind Parameter
    @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= ?1 ORDER BY AVG(score)")
    List<Object[]> findAverageScoreBySectionWithCapacity(Integer minEnrolled); // ?1 ?2 ?3

    // :naming --> Named Parameter
    @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(score)")
    List<Object[]> findAverageScoreBySectionWithCapacityNamed(@Param("minEnrolled") int minEnrolled);

    // Using named parameter
    // Find by student name and score
    @Query("SELECT studentName, score FROM Grade WHERE studentName = :studentNameParam AND score = :scoreParam")
    List<Object[]> findStudentNameAndScore(@Param("studentNameParam") String studentName, @Param("scoreParam") int score);


    //Native SQL
    @Query(value = "SELECT student_name, CAST(AVG(score) AS double) FROM tbl_grade GROUP BY student_name HAVING AVG(score) < :score ORDER BY student_name DESC", nativeQuery = true)
    List<Object[]> findAverageScoreBySectionWithNative(@Param("score") double score);

}
