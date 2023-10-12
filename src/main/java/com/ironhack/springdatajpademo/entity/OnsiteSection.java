package com.ironhack.springdatajpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tbl_onsite")
public class OnsiteSection extends Section {

    private int totalHours;
    private String campusLocation;

    public OnsiteSection() {
    }

    public OnsiteSection(String id, Course courseCode, Short roomNum, String instructor, int totalHours, String campusLocation) {
        super(id, courseCode, roomNum, instructor);
        this.totalHours = totalHours;
        this.campusLocation = campusLocation;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public String getCampusLocation() {
        return campusLocation;
    }

    public void setCampusLocation(String campusLocation) {
        this.campusLocation = campusLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OnsiteSection that = (OnsiteSection) o;
        return totalHours == that.totalHours && Objects.equals(campusLocation, that.campusLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHours, campusLocation);
    }

    @Override
    public String toString() {
        return "OnsiteSection{" +
                "totalHours=" + totalHours +
                ", campusLocation='" + campusLocation + '\'' +
                '}';
    }
}
