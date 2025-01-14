package com.example.securitydemo.usernamepassword.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * AuthenticationManager 사용자 정의
 * 일반적으로 스프링 시큐리티는 Username/Password 인증을 위해
 * DaoAuthenticationProvider 가 내부적으로 구성된 AuthenticationManager 를 빌드한다.
 *
 * 하지만 다른 다른 인스턴스 구성이 필요할 때가 있다.
 * 1. AuthenticationManagerBuilder 사용하여 커스터마이징
 */
@Configuration
@EnableWebSecurity
public class ExCustomizeAuthenticationManager {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER").build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // AuthenticationManagerBuilder 이 빈으로 등록되어 있어 주입받음
    @Autowired
    public void configure(AuthenticationManagerBuilder builder) {
        // 자격 증명을 지우지 않도록 설정 - default true
        builder.eraseCredentials(false);
    }
}
