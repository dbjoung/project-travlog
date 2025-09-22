package com.back.global.config;

import com.back.domain.member.entity.Member;
import com.back.domain.post.PostRepository;
import com.back.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AppConfig {
    private final Member
    private final PostRepository postRepository;


    @Bean
    public ApplicationRunner init() {
        return args -> {
            Member member = new Member("유저1", "이메일", "패스워드");



            Post post1 =  new Post(

            );
        };
    }
}
