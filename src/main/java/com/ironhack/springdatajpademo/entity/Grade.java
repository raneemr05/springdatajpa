package com.ironhack.springdatajpademo.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_name")
    private String studentName;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="streetName",column=@Column(name="current_street")),
            @AttributeOverride(name="POBox",column=@Column(name="current_pobox")),
            @AttributeOverride(name="city",column=@Column(name="current_city")),
            @AttributeOverride(name="country",column=@Column(name="current_country"))
    })
    private Address address;

    private String sectionId;

    private Integer score;

    public Grade() {
    }

    public Grade(String studentName, String sectionId, Integer score) {
        this.studentName = studentName;
        this.sectionId = sectionId;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(id, grade.id) && Objects.equals(studentName, grade.studentName) && Objects.equals(sectionId, grade.sectionId) && Objects.equals(score, grade.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, sectionId, score);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", score=" + score +
                '}';
    }
}
