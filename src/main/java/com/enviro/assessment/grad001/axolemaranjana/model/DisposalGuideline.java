package com.enviro.assessment.grad001.axolemaranjana.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "disposal_guidelines")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    @NonNull
    @NotEmpty(message = "'guideLine' is mandatory")
    @NotBlank(message = "'guideLine' is mandatory")
    @Size(min = 5, max = 1000, message = "'guideLine' length must be in the length range of 5 to 1000 characters")
    private String guideline;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = WasteCategory.class)
    @JoinColumn(name = "waste_category_id", referencedColumnName = "id")
    private WasteCategory wasteCategoryId;

    @CurrentTimestamp
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
}
