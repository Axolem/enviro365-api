package com.enviro.assessment.grad001.axolemaranjana.service;

import com.enviro.assessment.grad001.axolemaranjana.exception.NotFoundException;
import com.enviro.assessment.grad001.axolemaranjana.model.DisposalGuideline;
import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.repository.DisposalGuidelinesRepository;
import com.enviro.assessment.grad001.axolemaranjana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelinesService {

    @Autowired
    DisposalGuidelinesRepository disposalGuidelines;

    @Autowired
    WasteCategoryRepository categoryRepository;

    public List<DisposalGuideline> getAllGuideLines() {
        return disposalGuidelines.findAll();
    }

    public DisposalGuideline getDisposalGuidelineById(Long id) {
        return disposalGuidelines.findById(id).orElseThrow(() -> new RuntimeException("Could not find disposal guideline with id: " + id));
    }

    public DisposalGuideline createNewDisposalGuideline(DisposalGuideline guideline) {

        Optional<WasteCategory> category = categoryRepository.findById(guideline.getWasteCategoryId().getId());

        if (category.isPresent()) {
            guideline.setWasteCategoryId(category.get());
            return disposalGuidelines.save(guideline);
        }

        throw new RuntimeException("Invalid category id");
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline newGuideline) {
        DisposalGuideline toUpdate = getDisposalGuidelineById(id);
        newGuideline.setId(toUpdate.getId());

        return disposalGuidelines.save(toUpdate);
    }

    public DisposalGuideline deleteDisposalGuideline(Long id) {
        DisposalGuideline toDelete = getDisposalGuidelineById(id);

        disposalGuidelines.delete(toDelete);

        return toDelete;
    }
}
