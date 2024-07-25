package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String url;

    @ManyToOne
    private Course course;
}
