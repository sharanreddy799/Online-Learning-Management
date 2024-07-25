package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class DiscussionForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "forum")
    private List<Post> posts;
}
