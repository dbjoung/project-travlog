package com.back.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/members")
@RequiredArgsConstructor
public class MemberController {
    @PostMapping
    public void login() {

    }
}
