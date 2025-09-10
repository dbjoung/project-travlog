package com.back.domain.trip.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TripImage extends BaseEntity {
    @NotBlank
    private String url;

    @NotBlank
    private boolean isRepresent;
}
