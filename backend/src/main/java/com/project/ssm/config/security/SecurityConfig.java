package com.project.ssm.config.security;

import com.project.ssm.config.filter.JwtFilter;
import com.project.ssm.member.exception.security.CustomAccessDeniedHandler;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${jwt.secret-key}")
    private String secretKey;

    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final MemberRepository memberRepository;

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            http.headers().frameOptions().disable()
                    .addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS", "SAME_ORIGIN http://192.168.0.21"))
                    .and()
                    .csrf().disable()
                    .authorizeHttpRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(customAccessDeniedHandler) // 인가에 대한 예외 처리
//                    .authenticationEntryPoint(customAuthenticationEntryPoint) // 인증에 대한 예외 처리
                    .and()
                    .formLogin().disable()
                    .addFilterBefore(new JwtFilter(secretKey, memberRepository), UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            return  http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
