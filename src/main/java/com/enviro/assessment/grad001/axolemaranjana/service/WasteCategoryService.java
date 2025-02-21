package com.enviro.assessment.grad001.axolemaranjana.service;

import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.axolemaranjana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // I should use the service instead?
    @Autowired
    private DisposalGuidelinesRepository guidelinesRepository;

    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    public WasteCategory createWasteCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory newCategory) {
        Optional<WasteCategory> toBeUpdated = getCategoryById(id);

        if (toBeUpdated.isEmpty()) {
            throw new RuntimeException("Category with id: " + id + " not found.");
        }

        newCategory.setId(id);
        newCategory.setCreatedAt(toBeUpdated.get().getCreatedAt());
        return wasteCategoryRepository.save(newCategory);
    }

    public Optional<WasteCategory> deleteWasteCategory(Long id) {
        Optional<WasteCategory> toBeDeleted = getCategoryById(id);

        if (toBeDeleted.isEmpty()) {
            throw new RuntimeException("Category with id: " + id + " not found.");
        }

        wasteCategoryRepository.deleteById(id);
        return toBeDeleted;
    }

    public Optional<WasteCategory> getCategoryByIdAndGuidelines(Long id)    {
        return wasteCategoryRepository.findByIdWithGuidelines(id);
    }
}
