package com.back.domain.tag.entity;

import com.back.domain.post.entity.Post;
import com.back.domain.trip.entity.Trip;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Tag extends BaseEntity {
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Trip> trips;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
