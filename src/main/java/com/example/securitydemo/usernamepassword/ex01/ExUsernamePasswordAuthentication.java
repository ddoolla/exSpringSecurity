package com.example.securitydemo.usernamepassword.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
 * Username/Password Authentication 예시
 */
@Configuration
@EnableWebSecurity
public class ExUsernamePasswordAuthentication {

    // 기본 AuthenticationManager 에 DaoAuthenticationProvider 등록
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // HTTP Basic 인증 활성화
                .formLogin(Customizer.withDefaults()); // form 로그인 활성화

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails userDetails = User
                .withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        // 메모리 내에 사용자 데이터 저장 (테스트용)
        return new InMemoryUserDetailsManager(userDetails);
    }
}
