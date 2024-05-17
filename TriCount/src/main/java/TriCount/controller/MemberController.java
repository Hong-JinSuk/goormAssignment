package TriCount.controller;

import TriCount.TriCountApiConst;
import TriCount.domain.Member;
import TriCount.domain.MemberLoginDTO;
import TriCount.domain.MemberSignupDTO;
import TriCount.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static TriCount.TriCountApiConst.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberSignupDTO memberDTO) {
        Member member = Member.builder()
                .loginId(memberDTO.getLoginId())
                .password(memberDTO.getPassword())
                .name(memberDTO.getName())
                .build();
        return new ResponseEntity<>(memberService.signup(member), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Member> login(
            @RequestBody MemberLoginDTO memberDTO,
            HttpServletResponse response
    ) {
        Member member = memberService.login(memberDTO.getLoginId(), memberDTO.getPassword());

        Cookie cookie = new Cookie(LOGIN_MEMBER_COOKIE, String.valueOf(member.getId()));
        response.addCookie(cookie);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(LOGIN_MEMBER_COOKIE, null);
        cookie.setMaxAge(0); // logout
        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
