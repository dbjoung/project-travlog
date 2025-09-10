package com.back.domain.member.entity;

import com.back.domain.post.entity.Post;
import com.back.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member extends BaseEntity {
    @UniqueElements
    private String nickname;
    @UniqueElements
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    public boolean isWriter(long postId) {
        return posts.stream()
                .anyMatch(post -> postId==post.getId());
    }
}
