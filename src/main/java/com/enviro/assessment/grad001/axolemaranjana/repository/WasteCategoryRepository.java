package com.enviro.assessment.grad001.axolemaranjana.repository;

import com.enviro.assessment.grad001.axolemaranjana.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    @Query("SELECT wc FROM WasteCategory wc LEFT JOIN FETCH wc.disposalGuidelines WHERE wc.id = :id")
    Optional<WasteCategory> findByIdWithGuidelines(@Param("id") Long id);
}
