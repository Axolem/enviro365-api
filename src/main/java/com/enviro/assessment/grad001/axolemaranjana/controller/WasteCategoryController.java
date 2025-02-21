package com.enviro.assessment.grad001.axolemaranjana.controller;

import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    WasteCategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WasteCategory>> getCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = categoryService.getCategoryById(id);
        if (category.isEmpty()) {
            return new ResponseEntity<>(category, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory category) {
        return new ResponseEntity<>(categoryService.createWasteCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updatedCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        try {
            return new ResponseEntity<>(categoryService.updateWasteCategory(id, category), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<WasteCategory>> deleteCategory(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(categoryService.deleteWasteCategory(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
