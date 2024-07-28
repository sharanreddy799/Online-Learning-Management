package com.example.lms.service;

import com.example.lms.entity.Instructor;
import com.example.lms.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id){
        return  instructorRepository.findById(id).orElse(null);
    }

    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id){
        instructorRepository.deleteById(id);
    }
}
