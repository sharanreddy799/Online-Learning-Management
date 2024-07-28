package com.example.lms.controller;

import com.example.lms.entity.DiscussionForum;
import com.example.lms.service.DiscussionForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussion-forums")
public class DiscussionForumController {
    @Autowired
    private DiscussionForumService discussionForumService;

    @GetMapping("/")
    public List<DiscussionForum> getAllDiscussionForums() {
        return discussionForumService.getAllDiscussionForums();
    }

    @GetMapping("/{id}")
    public DiscussionForum getDiscussionForumById(@PathVariable Long id) {
        return discussionForumService.getDiscussionForumById(id);
    }

    @PostMapping("/")
    public DiscussionForum createDiscussionForum(@RequestBody DiscussionForum discussionForum) {
        return discussionForumService.createDiscussionForum(discussionForum);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscussionForum(@PathVariable Long id) {
        discussionForumService.deleteDiscussionForum(id);
    }
}
