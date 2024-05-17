package TriCount.config;

import TriCount.repository.MemberRepository;
import TriCount.repository.MemberRepositoryImpl;
import TriCount.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final DataSource dataSource;

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl(dataSource);
    }

    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
