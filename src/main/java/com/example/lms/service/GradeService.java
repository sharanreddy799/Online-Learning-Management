package com.example.lms.service;

import com.example.lms.entity.Grade;
import com.example.lms.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
