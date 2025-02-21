package com.enviro.assessment.grad001.axolemaranjana.repository;

import com.enviro.assessment.grad001.axolemaranjana.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}
