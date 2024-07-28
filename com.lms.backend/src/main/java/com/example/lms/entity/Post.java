package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private User author;
    private String datePosted;

    @ManyToOne
    private DiscussionForum forum;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
