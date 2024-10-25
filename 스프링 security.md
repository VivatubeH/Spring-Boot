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

### 기본적인 로그인 절차
1. 로그인 화면 요청
2. 로그인 요청 처리 ( 아이디/ 비밀번호 체크, 세션에 사용자 정보 저장 ) -> 이 단계를 스프링 시큐리티가 대신 해준다.

#### SecurityConfig 클래스에 비밀번호 암호화하는 인코더 추가
```java
// 비밀번호를 암호화하는 비밀번호 인코더를 스프링의 빈으로 등록시킨다.
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
```

#### UserService에 인코더 조립시키기
```java
	@Autowired
	private PasswordEncoder passwordEncoder;
```

#### UserService의 addNewUser 메소드에 암호화 추가시키기
```java
// 비밀번호를 암호화한다.
String encodedPassword = passwordEncoder.encode(user.getPassword());
user.setPassword(encodedPassword);		
```

#### HomeController 로그인에 redirect 추가하기
```java
@PostMapping("/register")
public String register(@Valid @ModelAttribute("registerForm") UserRegisterForm form, BindingResult errors) {
	
	// 유효성 검증을 통과하지 못하면 register-form.jsp로 내부이동시킨다.
	if (errors.hasErrors()) {
		return "register-form";
	}
	
	// 추가적인 유효성 검증 실시하기
	if (!form.getPassword().equals(form.getPasswordConfirm())) {
		errors.rejectValue("passwordConfirm", null, "비밀번호가 일치하지 않습니다.");
		return "register-form";
	}
	
	try {
		// 업무로직 메소드를 호출한다.
		userService.addNewUser(form);
		
	} catch (AlreadyUserEmailException ex) { 
		// 아주 특별한 예외는 컨트롤러에서 처리한다. ( 되돌아가야 하므로 )
		// 구체적인 예외를 구분하려면 개별 예외가 달라야함.
		// 이메일 중복으로 폼 입력값이 유효하지 않는 경우
		errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
		return "register-form";
	}
	
	return "redirect:/home";
```

#### login-form 커스터마이징
```jsp
<div class="mb-3">
<label class="form-label">이메일</label>
<input type="text" class="form-control" id="user-email" name="email" />
</div>
<div class="mb-3">
<label class="form-label">비밀번호</label>
<input type="password" class="form-control" id="user-password" name="pwd" />
</div>
```

#### 스프링에 커스터마이징 알려주기
```java
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
			.failureUrl("/login?error"));	
```
