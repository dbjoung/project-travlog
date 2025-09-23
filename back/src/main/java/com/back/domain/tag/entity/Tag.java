package com.back.domain.tag.entity;

import com.back.domain.trip.entity.Trip;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Tag extends BaseEntity {
    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
