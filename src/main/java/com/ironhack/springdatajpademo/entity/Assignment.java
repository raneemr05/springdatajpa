package com.ironhack.springdatajpademo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name ="tbl_assignments")
@Data
public class Assignment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne(mappedBy = "assignment")
    private Grade grade;

    private String assignmentTitle;
    private int score;
}
