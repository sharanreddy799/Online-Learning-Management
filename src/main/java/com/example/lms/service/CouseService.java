package com.example.lms.service;

import com.example.lms.entity.Course;
import com.example.lms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
