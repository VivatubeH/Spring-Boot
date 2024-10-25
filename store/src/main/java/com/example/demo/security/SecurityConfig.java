package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			// 사이트간 요청변조를 방지하는 csrf토큰 사용을 비활성화한다.
			.csrf(csrf -> csrf
					.disable())
			// 접근 인가정책을 설정한다.
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/my/**").hasAnyRole("USER", "MANAGER", "ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					// 위에서 나열한 경로를 제외한 나머지는 전부 접근 허용
					.anyRequest().permitAll())
			// 폼로그인 정책을 설정한다.
			.formLogin(formLogin -> formLogin
						// 로그인 폼을 요청하는 URL을 지정한다.
						.loginPage("/login")
						.usernameParameter("email")
						.passwordParameter("pwd")
						// 로그인 요청을 처리하는 URL을 지정한다.
						.loginProcessingUrl("/login")
						// 로그인 성공시 이동할 URL을 지정한다.
						.defaultSuccessUrl("/home")
						// 로그인 실패시 이동할 URL을 지정한다.
						.failureUrl("/login?error"))
			// 로그아웃 정책을 설정한다.
			.logout(logout -> logout
						// 로그아웃 요청 URL을 지정한다.
						.logoutUrl("/logout")
						// 로그아웃 성공시 이동할 URL을 지정한다.
						.logoutSuccessUrl("/home")
						// 세션객체를 무효화시킨다.
						.invalidateHttpSession(true));
		
		return http.build();
	}
	
	// 비밀번호를 암호화하는 비밀번호 인코더를 스프링의 빈으로 등록시킨다.
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}













