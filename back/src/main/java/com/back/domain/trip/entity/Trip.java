package com.back.domain.trip.entity;

import com.back.domain.post.entity.Post;
import com.back.domain.tag.entity.Tag;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Trip extends BaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private int price = 0;

    @Setter
    @Getter
    private boolean isRepresent = false; // 대표 여행인 지 확인

    @ManyToOne
    @Setter
    public Post post;

    @ManyToMany(mappedBy = "trips", fetch = FetchType.LAZY)
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripImage> images = new ArrayList<>();

    public Trip(String name, String description, LocalDateTime  startDateTime, LocalDateTime endDateTime, int price) {
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.price = price;
    }

    public void addImage(TripImage tripImage) {
        images.add(tripImage);
        tripImage.setTrip(this);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.addTrip(this);
    }
}
