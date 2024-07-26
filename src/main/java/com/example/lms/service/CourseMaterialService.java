package com.example.lms.service;

import com.example.lms.entity.CourseMaterial;
import com.example.lms.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialService {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public List<CourseMaterial> getAllCourseMaterials() {
        return courseMaterialRepository.findAll();
    }

    public CourseMaterial getCourseMaterialById(Long id) {
        return courseMaterialRepository.findById(id).orElse(null);
    }

    public CourseMaterial createCourseMaterial(CourseMaterial courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);
    }

    public void deleteCourseMaterial(Long id) {
        courseMaterialRepository.deleteById(id);
    }
}
