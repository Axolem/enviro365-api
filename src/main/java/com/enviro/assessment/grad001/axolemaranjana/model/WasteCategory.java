package com.enviro.assessment.grad001.axolemaranjana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "waste_category")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true)
    @NotNull(message = "'name' can not be null")
    @NotBlank(message = "'name' is mandatory")
    @Size(min = 2, max = 100, message = "'name' must be between 2 and 100 characters")
    private String name;

    @Column(length = 500)
    @NotNull(message = "'description' can not be null")
    @NotBlank(message = "'description' is mandatory")
    @Size(min = 2, max = 100, message = "'description' must be between 2 and 500 characters")
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(
            mappedBy = "wasteCategoryId"
    )
    private Set<DisposalGuideline> disposalGuidelines;

    @JsonIgnore
    @OneToMany(
            mappedBy = "category"
    )
    private Set<RecyclingTip> recyclingTips;

    // Need this for the createNewDisposalGuideline to work
    public WasteCategory(Long id){
        this.id = id;
    }
}
