package com.back.domain.trip.entity;

import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class TripImage extends BaseEntity {
    @NotBlank
    private String url;

    @NotNull
    private boolean isRepresent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Trip trip;
}
