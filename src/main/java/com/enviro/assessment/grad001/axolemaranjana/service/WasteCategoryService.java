package com.enviro.assessment.grad001.axolemaranjana.service;

import com.enviro.assessment.grad001.axolemaranjana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;
}
