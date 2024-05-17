package TriCount.service;

import TriCount.advice.ForbiddenAccessException;
import TriCount.domain.Member;
import TriCount.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member signup(Member member){
        return memberRepository.save(member);
    }

    public Member login(String loginId, String password){
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("[[ 로그인 아이디가 없습니다!! ]]"));

        if (!member.getPassword().equals(password)) {
            throw new RuntimeException("[[ 비밀번호가 일치하지 않습니다!! ]]");
        }

        return member;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }
}
