package com.flow.payment.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(AbstractHttpConfigurer::disable)  // CSRF 비활성화
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))  // CORS 설정 추가
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().permitAll()  // 모든 요청에 대해 인증 없이 접근 허용
			);

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("http://localhost:3000"); // 허용할 도메인
		configuration.addAllowedHeader("*"); // 모든 헤더 허용
		configuration.addAllowedMethod("*"); // 모든 HTTP 메소드 허용
		configuration.setAllowCredentials(true); // 자격 증명(쿠키 등) 허용

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}

