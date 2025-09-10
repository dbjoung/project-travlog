package com.back.domain.post.entity;

import com.back.domain.member.entity.Member;
import com.back.domain.trip.entity.Trip;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Post extends BaseEntity {
    @NotBlank
    private String title;
    @NotBlank
    private String description;

    // 속한 여행거리 들
    @OneToMany(fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    // 대표 여행
    @OneToOne(fetch = FetchType.LAZY)
    @NotBlank
    private Trip representTrip;

    // 참여한 사람들
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();
}
