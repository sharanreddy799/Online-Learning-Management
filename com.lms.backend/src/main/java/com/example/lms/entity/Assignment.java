package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String dueDate;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

}
