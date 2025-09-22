package com.back.domain.post.entity;

import com.back.domain.member.entity.Member;
import com.back.domain.trip.entity.Trip;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Post extends BaseEntity {
    // 작성한 사람
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    // 속한 여행거리 들
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Trip> trips = new ArrayList<>();

    // 함께 참여한 사람들
    @Size(min=1)
    @ManyToMany(fetch = FetchType.LAZY)
    private final List<Member> members = new ArrayList<>();

    public Post(String title, String description, Member writer) {
        this.title = title;
        this.description = description;
        this.writer = writer;
    }

    public Post(String title, String description, Member writer, List<Member> members) {
        this(title, description, writer);
        this.members.addAll(members);
    }

    public void addMembers(List<Member> members) {
        this.members.addAll(members);
    }

    public Trip getRepresentTrip() {
        return trips.stream()
                .filter(Trip::isRepresent)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("대표 이미지는 반드시 지정되어야 합니다."));
    }
}
