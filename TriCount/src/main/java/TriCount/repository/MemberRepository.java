package TriCount.repository;

import TriCount.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {

    public Member save(Member member);

    public Optional<Member> findByLoginId(String loginId);

    public Optional<Member> findById(Long id);
}
