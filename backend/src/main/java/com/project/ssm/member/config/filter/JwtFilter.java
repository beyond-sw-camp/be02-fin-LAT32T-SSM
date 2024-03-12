package com.project.ssm.member.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.ErrorResponse;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.exception.MemberAccountException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JwtFilter extends OncePerRequestFilter {
    private MemberRepository memberRepository;

    @Value("${jwt.secret-key}")
    private String secretKey;

    public JwtFilter(String secretKey, MemberRepository memberRepository) {
        this.secretKey = secretKey;
        this.memberRepository = memberRepository;
    }

    // 필터에서 예외를 다루기 위한 처리
    private void handleJwtException(HttpServletResponse response, MemberAccountException exception) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
        response.setContentType("application/json");

        // ErrorResponse 생성 및 반환
        ErrorCode errorCode;
        if (exception.getErrorCode() != null) {
            errorCode = exception.getErrorCode();
        } else {
            errorCode = ErrorCode.UNAUTHORIZED;
        }

        ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(), exception.getMessage());
        String jsonErrorResponse = new ObjectMapper().writeValueAsString(errorResponse);

        response.getWriter().write(jsonErrorResponse);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String header = request.getHeader(HttpHeaders.AUTHORIZATION);

            String token;
            if (header != null && header.startsWith("Bearer ")) {
                token = header.split(" ")[1];
            } else {
                filterChain.doFilter(request, response);
                return;
            }

           String authority = JwtUtils.getAuthority(token, secretKey);

            if(authority.equals("ROLE_USER")){
                String memberId = JwtUtils.getUserMemberId(token, secretKey);
                if (memberId != null) {
                    Optional<Member> result = memberRepository.findByMemberId(memberId);

                    if (result.isPresent()) {
                        Member member = result.get();

                        // 인가하는 코드
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                member, null,
                                member.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    }
                }
            }


        } catch (MemberAccountException e) {
            // JwtUtils에서 던진 UserAccountException 처리
            handleJwtException(response, e);
        } catch (ServletException e) {
            // Spring Security 예외 처리
            handleJwtException(response, new MemberAccountException(ErrorCode.UNAUTHORIZED, e.getMessage()));
        }
    }
}
