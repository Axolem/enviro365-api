package com.enviro.assessment.grad001.axolemaranjana.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "recycling_tips")
@Getter
@Setter
@EntityListeners(AbstractMethodError.class)
@AllArgsConstructor
@NoArgsConstructor
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "'tip' is mandatory")
    @NotEmpty(message = "'tip' is mandatory")
    @NonNull
    private String tip;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = WasteCategory.class)
    @NonNull
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private WasteCategory category;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
