package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String syllabus;
    private String schedule;

    @ManyToOne
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    private List <CourseMaterial> courseMaterials;

    @OneToMany(mappedBy = "course")
    private List <Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<DiscussionForum> discussionForums;

    // Getters and Setters
}