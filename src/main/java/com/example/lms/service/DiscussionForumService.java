package com.example.lms.service;

import com.example.lms.entity.DiscussionForum;
import com.example.lms.repository.DiscussionForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionForumService {
    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    public List<DiscussionForum> getAllDiscussionForums() {
        return discussionForumRepository.findAll();
    }

    public DiscussionForum getDiscussionForumById(Long id) {
        return discussionForumRepository.findById(id).orElse(null);
    }

    public DiscussionForum createDiscussionForum(DiscussionForum discussionForum) {
        return discussionForumRepository.save(discussionForum);
    }

    public void deleteDiscussionForum(Long id) {
        discussionForumRepository.deleteById(id);
    }
}
