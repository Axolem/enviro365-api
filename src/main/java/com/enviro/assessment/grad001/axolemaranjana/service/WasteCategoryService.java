package com.enviro.assessment.grad001.axolemaranjana.service;

import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllCategories(){
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Long id){
        return wasteCategoryRepository.findById(id);
    }
}
