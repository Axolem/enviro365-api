package com.enviro.assessment.grad001.axolemaranjana.controller;

import com.enviro.assessment.grad001.axolemaranjana.exception.NotFoundException;
import com.enviro.assessment.grad001.axolemaranjana.model.DisposalGuideline;
import com.enviro.assessment.grad001.axolemaranjana.service.DisposalGuidelinesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelinesController {

    @Autowired
    DisposalGuidelinesService guidelinesService;

    @GetMapping("/")
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        return new ResponseEntity<>(guidelinesService.getAllGuideLines(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DisposalGuideline getGuideline(@PathVariable Long id) {
        return guidelinesService.getDisposalGuidelineById(id);
    }

    @PostMapping("/")
    public DisposalGuideline createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return guidelinesService.createNewDisposalGuideline(guideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        return new ResponseEntity<>(guidelinesService.updateDisposalGuideline(id, guideline), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public DisposalGuideline deleteDisposalGuideline(@PathVariable Long id) {
        return guidelinesService.deleteDisposalGuideline(id);
    }
}
