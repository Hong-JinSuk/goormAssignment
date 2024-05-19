package TriCount.interceptor;

import TriCount.MemberContext;
import TriCount.advice.ForbiddenAccessException;
import TriCount.domain.Member;
import TriCount.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static TriCount.TriCountApiConst.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor{

    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new ForbiddenAccessException("[[ 로그인이 필요합니다!! ]]");
        }

        Map<String, Cookie> cookieMap = Arrays.stream(cookies).collect(Collectors.toMap(Cookie::getName, Function.identity()));
        Cookie loginCookie = cookieMap.get(LOGIN_MEMBER_COOKIE);

        if (loginCookie == null) {
            throw new ForbiddenAccessException("[[ 로그인이 필요합니다!! ]]");
        }

        try {
            Member member = memberService.findById(Long.valueOf(loginCookie.getValue()));
            MemberContext.setMember(member);
        } catch (Exception e) {
            throw new ForbiddenAccessException("[[ 회원 정보를 찾을 수 없습니다!! ]]");
        }

        return true;
    }
}
