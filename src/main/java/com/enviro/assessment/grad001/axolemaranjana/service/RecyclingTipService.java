package com.enviro.assessment.grad001.axolemaranjana.service;

import com.enviro.assessment.grad001.axolemaranjana.model.RecyclingTip;
import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import com.enviro.assessment.grad001.axolemaranjana.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.axolemaranjana.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    @Autowired
    RecyclingTipRepository tipRepository;

    @Autowired
    WasteCategoryRepository categoryRepository;

    public RecyclingTip getRecyclingTipById(Long id) {
        return tipRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find recycling tip with id: " + id));
    }

    public RecyclingTip createNewRecyclingTip(RecyclingTip recyclingTip) {
        WasteCategory category = categoryRepository.findById(recyclingTip.getCategory().getId()).orElseThrow(() -> new RuntimeException("Invalid category id"));
        recyclingTip.setCategory(category);
        return tipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        RecyclingTip tip = getRecyclingTipById(id);

        recyclingTip.setId(tip.getId());

        return tipRepository.save(recyclingTip);
    }

    public RecyclingTip deleteRecyclingTip(Long id) {
        RecyclingTip tip = getRecyclingTipById(id);
        tipRepository.delete(tip);
        return tip;
    }

    public List<RecyclingTip> getAllRecyclingTips() {
        return tipRepository.findAll();
    }
}
