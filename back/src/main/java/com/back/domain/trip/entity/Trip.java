package com.back.domain.trip.entity;

import com.back.domain.tag.entity.Tag;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Trip extends BaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private LocalDateTime startDateTime;
    @NotBlank
    private LocalDateTime endDateTime;
    @NotBlank
    private int price;

    @NotBlank
    @Setter
    @Getter
    private boolean isRepresent; // 대표 여행인 지 확인

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripImage> images = new ArrayList<>();


}
