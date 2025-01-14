package com.example.securitydemo.usernamepassword.exformlogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 시큐리티 설정 - 폼 로그인
 * 주의사항
 *  - /login 매핑 있어야 함
 *  - 타임리프에서 자동으로 포함하는 CSRF 토큰을 포함해야 함
 *  - username 매개변수에 이름을 지정해야 함
 *  - password 매개변수에 비밀번호를 지정해야 함
 *  - error 라는 http 매개변수가 발견되면 유효한 이름, 비밀번호를 제공하지 못함
 *  - logout 라는 http 매개변수가 발경되면 성공적으로 로그아웃 되었음을 나타냄
 */
@Configuration
@EnableWebSecurity
public class ExFormLogin {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .formLogin(Customizer.withDefaults()); // 기본 로그인 페이지 제공
                .formLogin(form -> form.loginPage("/login").permitAll()); // 로그인 페이지 사용자 정의

        return http.build();
    }
}

