package com.enviro.assessment.grad001.axolemaranjana.controller;

import com.enviro.assessment.grad001.axolemaranjana.model.RecyclingTip;
import com.enviro.assessment.grad001.axolemaranjana.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tip")
public class RecyclingTipController {
    @Autowired
    RecyclingTipService recyclingTipService;

    @GetMapping("/")
    public List<com.enviro.assessment.grad001.axolemaranjana.model.RecyclingTip> getAllRecyclingTips() {
        return recyclingTipService.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public RecyclingTip getRecyclingTipById(@PathVariable Long id) {
        return recyclingTipService.getRecyclingTipById(id);
    }

    @PostMapping("/")
    public RecyclingTip createNewRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        return recyclingTipService.createNewRecyclingTip(recyclingTip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
        return recyclingTipService.updateRecyclingTip(id, recyclingTip);
    }

    @DeleteMapping("/{id}")
    public RecyclingTip deleteRecyclingTip(@PathVariable Long id) {
        return recyclingTipService.deleteRecyclingTip(id);
    }
}
