package com.enviro.assessment.grad001.axolemaranjana.repository;

import com.enviro.assessment.grad001.axolemaranjana.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuideline, Long> {
}
