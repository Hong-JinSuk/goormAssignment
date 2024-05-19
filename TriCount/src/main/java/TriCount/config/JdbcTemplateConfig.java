package TriCount.config;

import TriCount.interceptor.LoginCheckInterceptor;
import TriCount.repository.*;
import TriCount.service.ExpenseService;
import TriCount.service.MemberService;
import TriCount.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig implements WebMvcConfigurer{

    private final DataSource dataSource;

    public JdbcTemplateConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl(dataSource);
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public SettlementRepository settlementRepository() {
        return new SettlementRepositoryImpl(dataSource);
    }

    @Bean
    public SettlementService settlementService() {
        return new SettlementService(settlementRepository());
    }

    @Bean
    public ExpenseRepository expenseRepository() {
        return new ExpenseRepositoryImpl(dataSource);
    }

    @Bean
    public ExpenseService expenseService() {
        return new ExpenseService(expenseRepository(), settlementRepository());
    }

    @Bean
    public LoginCheckInterceptor loginCheckInterceptor() {
        return new LoginCheckInterceptor(memberService());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/member/signup", "/member/login", "h2-console/**");
    }
}
