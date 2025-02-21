package com.enviro.assessment.grad001.axolemaranjana.controller;

import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    WasteCategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<WasteCategory>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

}
