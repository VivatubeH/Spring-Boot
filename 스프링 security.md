#### pom.xml에 라이브러리 의존성 추가

```xml
<!-- Spring security 의존성 추가 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<!-- Spring security를 지원하는 JSP 태그라이브러리 의존성 추가-->
<dependency>
     <groupId>org.springframework.security</groupId>
     <artifactId>spring-security-taglibs</artifactId>
</dependency>
```

#### 스프링부트 실행시에 나오는 비밀번호가 시큐리티 비밀번호, 아이디는 user 고정

#### tags.jsp에 라이브러리 추가
```jsp
<!-- spring security 태그 라이브러리 -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
```

#### nav.jsp에 tags.jsp 인클루드하기
```jsp
<%@ include file="tags.jsp" %>
```

#### nav.jsp에서 체크하기 - 1
```jsp
<!-- 인증된 사용자가 아닌 경우 -->
<sec:authorize access="!isAuthenticated()">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link ${menu eq 'login' ? 'active fw-bold' : '' }" href="/login">로그인</a>
    </li>
    <li class="nav-item">
        <a class="nav-link ${menu eq 'register' ? 'active fw-bold' : '' }" href="/register">회원가입</a>
    </li>
  </ul>
</sec:authorize>
<!-- 사용자 인증이 완료된 경우 -->
<sec:authorize access="isAuthenticated()">					
  <span class="navbar-text"><strong>홍길동</strong><small>님 환영합니다.</small></span>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/logout">로그아웃</a>
    </li>
  </ul>
</sec:authorize>
```

#### nav.jsp에서 체크하기 - 2
```
<sec:authorize access="isAuthenticated()">
  <li class="nav-item dropdown ${menu eq 'my' ? 'active fw-bold' : '' }">
    <a class="nav-link dropdown-toggle" href="#" id="my-menu-link" role="button" data-bs-toggle="dropdown" aria-expanded="false">
      마이 메뉴
    </a>
    <ul class="dropdown-menu" aria-labelledby="my-menu-link">
      <li><a class="dropdown-item" href="/my/carts">장바구니</a></li>
      <li><a class="dropdown-item" href="/my/orders">구매내역</a></li>
      <li><a class="dropdown-item" href="/my/reviews">내가 작성한 리뷰</a></li>
      <li><a class="dropdown-item" href="/my/pointhistory">포인트변경 이력</a></li>
      <li><a class="dropdown-item" href="/my/info">내정보 보기</a></li>
    </ul>
  </li>
</sec:authorize>
```

#### SecurityConfig 클래스 작성
```java
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			// 사이트간 요청변조를 방지하는 csrf 토큰 사용을 비활성화한다.
			.csrf(csrf -> csrf
					.disable())
			// 접근 인가정책을 설정한다.
	        .authorizeHttpRequests(auth -> auth
	              // /my/** 요청은 USER, MANAGER, ADMIN 권한을 가지고 있을 때만 접근허용
	              .requestMatchers("/my/**").hasAnyRole("USER", "MANAGER", "ADMIN")
	              // /admin/** 요청은 ADMIN 권한을 가지고 있을때만 접근허용
	              .requestMatchers("/admin/**").hasRole("ADMIN")
                      // 위에서 나열한 경로를 제외한 나머지는 전부 접근 허용
                      .anyRequest().permitAll());
		
		return http.build();
	}
}
```

