package com.back.domain.member.entity;

import com.back.domain.post.entity.Post;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseEntity {
    @Column(unique = true)
    private String email;
    private String nickname;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private final List<Post> myPosts = new ArrayList<>();


    public Member(String email, String nickname, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
