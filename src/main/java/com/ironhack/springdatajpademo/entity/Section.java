package com.ironhack.springdatajpademo.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_section")
@Inheritance(strategy = InheritanceType.JOINED)
public class Section {

    @Id
    private  String id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private Course course;

//    private String courseCode;

    private Short roomNum;

    private  String instructor;


    public Section() {
    }

    public Section(String id, Course course, Short roomNum, String instructor) {
        this.id = id;
        this.course = course;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourseCode() {
        return course;
    }

    public void setCourseCode(Course courseCode) {
        this.course =  course;
    }

    public Short getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Short roomNum) {
        this.roomNum = roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", courseCode='" + course+ '\'' +
                ", roomNum=" + roomNum +
                ", instructor='" + instructor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id) && Objects.equals(course, section.course) && Objects.equals(roomNum, section.roomNum) && Objects.equals(instructor, section.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, roomNum, instructor);
    }
}
