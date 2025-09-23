package com.back.global.runner;

import com.back.domain.member.MemberRepository;
import com.back.domain.member.entity.Member;
import com.back.domain.post.PostRepository;
import com.back.domain.post.entity.Post;
import com.back.domain.tag.TagRepository;
import com.back.domain.tag.entity.Tag;
import com.back.domain.trip.TripRepository;
import com.back.domain.trip.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Configuration
public class BaseInitData {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final TripRepository tripRepository;

    @Lazy
    @Autowired
    private BaseInitData self;

    @Bean
    ApplicationRunner initApplicationRunner() {
        return args -> {
            if (memberRepository.count() == 0) self.work1();
            if (tagRepository.count()==0) self.work2();
        };
    }

    @Transactional
    public void work1() {
        Member member1 = new Member("이메일1","유저1", "패스워드1");
        Member member2 = new Member("이메일2","유저2", "패스워드2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        Post post1 = new Post("제목1", "내용1", member1);
        Post post2 = new Post("제목2", "내용2", member2);
        Post post3 = new Post("제목3", "내용3", member2);
        Post post4 = new Post("제목4", "내용4", member1);
        Post post5 = new Post("제목5", "내용5", member1);

        Trip trip1 = new Trip("여행1", "내용1", LocalDateTime.now(), LocalDateTime.now(), 3000);
        trip1.setRepresent(true);
        Trip trip2 = new Trip("여행2", "내용2", LocalDateTime.now(), LocalDateTime.now(), 4000);
        Trip trip3 = new Trip("여행3", "내용3", LocalDateTime.now(), LocalDateTime.now(), 5000);
        Trip trip4 = new Trip("여행4", "내용4", LocalDateTime.now(), LocalDateTime.now(), 6000);

        post1.addTrip(trip1);
        post1.addTrip(trip2);
        post1.addTrip(trip3);
        post1.addTrip(trip4);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
    }

    @Transactional
    public void work2() {
        tagRepository.save(new Tag("휴식"));
        tagRepository.save(new Tag("여행"));
        tagRepository.save(new Tag("맛집"));
        tagRepository.save(new Tag("모험"));

        Trip trip = tripRepository.findById(1L).get();
        Trip trip2 = tripRepository.findById(2L).get();
        trip.addTag(tagRepository.findById(1L).get());
        trip.addTag(tagRepository.findById(2L).get());
        trip2.addTag(tagRepository.findById(1L).get());
    }
}
