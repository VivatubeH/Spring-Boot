보통의 회원가입시 
-----------------------
최초 가입시에는 무조건 일반 회원으로만 가입이 가능하고,   
새로운 권한 획득은 최고 관리자나 중간 관리자의 허락을 통해서만 가능함.

#### 정적 컨텐츠의 위치
항상 webapp - resources 폴더를 만들어서 그 하위에 넣어야 함. [ 별도의 설정을 할 필요 없음 ]   
resources로 요청이 오면 컨트롤러 매핑이 아닌, 직접적인 파일을 가져온다. 

#### 입력폼과 일치하는 클래스 생성
입력폼이 있으면, 대부분의 경우 입력폼은 DB와 일치하지 않는다.   
따라서, 입력폼과 일치하는 클래스를 무조건 만든다.   
필드명은 입력폼의 name과 반드시 일치시킨다.

#### 입력폼에서 같은 name으로 전달되는 값이 여러개일때
클래스의 필드를 List로 만들어야 한다.

#### 회원가입 로직
1. 입력폼 화면을 요청한다.
  - 요청방식 : GET
  - url : localhost/register
  ```jsp
  <a href="/register">회원가입</a>
  ```
  ```java
  @GetMapping("/register")
  public String registerform() {
    return "register-form";
  }
  ```  
2. 입력폼에 입력한 값을 등록 요청한다.
  - 요청방식 : POST
  - url : localhost/register
  ```jsp
  <form method="post" action="/register">
  </form>
  ```
  ```java
  @PostMapping("/register")
  public String register(UserRegisterForm form) {
    return "redirect:xxx";
  }
  ```

### 사용자가 입력한 입력값 검증 -> spring의 boot-starter-validation 

### Spring boot 폼 입력값 유효성 검증
- spring boot의 폼 입력값 유효성 검증은 Java Bean Validation API(JSR-303/JSR-380 명세)를 사용한다.
- Java Bean Validation API를 구현한 구현체는 Hibernate Validator를 사용한다.
- 유효성 검증은 Hibernate Validator가 하므로 개발자는 어노테이션을 작성하면 된다.
- 의존성 추가
```xml
<dependency>
  <groupId>org.springframework.boot<groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

- JSR-303의 유효성 검증 어노테이션
  + @NotNull
    * 멤버변수의 값이 null이 아니어야 한다.
    * 대상 : 모든 객체
  + @NotEmpty
    * 멤버변수의 값이 null이 아니고, 길이가 0이 아니어야 한다.
    * 대상 : 문자열, 콜렉션, 배열
    * 사용예
        ```java
        @NotEmpty(message = "이름은 필수 입력값입니다.")
        private String username;
        
        @NotEmpty(message = "경력 사항은 필수입력값입니다.")
        private List<String> careers;
        ```
  + @NotBlank
      * 멤버변수의 값이 공백이 아닌 문자를 포함해야 한다. @NotEmpty보다 더 엄격한 규칙이다.
      * 대상 : 문자열
  + @Size(min, max)
      * 문자열, 콜렉션, 배열, 맵의 길이가 크기가 지정된 범위에 속해야 한다.
      * 대상 : 문자열, 콜렉션, 배열, 맵
      * 사용예
         ```java
         @Size(min = 2, max = 20, message = "닉네임은 2 ~ 20글자 이내만 가능합니다.")
         private String nickname;
         
         @Size(min = 9, message = "비밀번호는 9글자 이상입니다.")
         private String password;
          ```
  + @Min
      * 멤버변수의 값이 지정된 최소값 이상이어야 한다.
      * 대상: 숫자(int, long, double 등)
      * 사용예
          ```java
          @Min(value = 19, message = "이 사이트의 이용가능 연령은 19세 이상입니다.")
          private int age;
          ```
  + @Max
      * 멤버변수의 값이 지정된 최대값 이하여야 한다.
      * 대상: 숫자(int, long, double 등)
      * 사용예
          ```java
          @Min(value = 0, message = "점수는 0 ~ 100 사이 값만 가능합니다.")
          @Max(value = 100, message = "점수는 0 ~ 100 사이 값만 가능합니다.")
          private int score;
          ```
  + @Email
      * 멤버변수의 값이 유효한 이메일 형식이어야 한다.
      * 대상: 문자열
      * 사용예
          ```java
          @Email(message = "유효한 이메일 형식이 아닙니다.")
          private String email;
          ```

  + @Pattern(정규표현식)
      * 멤버변수의 값이 지정된 정규표현식의 패턴과 일치해야 한다.
      * 대상: 문자열
      * 사용예
          ```java
          @Pattern(regexp = "^[가-힣]{2,}$", message = "닉네임은 한글 2글자 이상입니다.")
          private String nickname;
          ```
  + @Past
      * 멤버변수의 날짜값이 현재 시점보다 이전인지 확인한다.
      * 대상: Date, LocalDate, LocalDateTime
      * 사용예
          ```java
          @Past(message = "생일은 오늘보다 이전 날짜만 가능합니다.")
          private Date birthday;
          ```
  + @Future
      * 멤버변수의 날짜값이 현재 시점보다 미래인지 확인한다.
      * 대상: Date, LocalDate, LocalDateTime
      * 사용예
          ```java
          @Future(message = "만료일자는 오늘보다 이후 날짜만 가능합니다.")
          private Date expirationDate;
          ```
  + @Positive/@PositiveOrZero
      * 멤버변수의 값이 양수 혹은 0인지 확인한다.
      * 대상 : 숫자타입
      * 사용예
          ```java
          @Positive(message = "가격은 양수값만 허용합니다.")
          private int price;
          ```
  + @Negative/@NegativeOrZero
      * 멤버변수의 값이 음수 혹은 0인지 확인한다.
      * 대상 : 숫자타입
      * 사용예
          ```java
          @Negative(message = "할인가격은 음수값만 허용합니다.")
          private int discountPrice;
          ```

  #### 스프링 AOP 개념을 알고 있으면 좋지만, 사용할 일은 없음

Spring boot와 validation API를 이용한 유효성 검증
----------------------------------------------------

1. Form 클래스를 정의한다.

```java
   public class UserRegisterForm {
    @NotEmpty(message = "이메일은 필수입력값입니다.")
    @Email(message = "유효한 이메일이 아닙니다.")
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String nickname;

    @NotEmpty
    String tel;
   }
```

2. 입력폼 화면을 요청하는 요청핸들러 메소드를 정의한다.

```java
@GetMapping("/register")
public String form(Model model) {
  // 입력폼에서 UserRegister 객체의 멤버변수에 저장된 값을 표시하기 때문에
  // Model 객체 UserRegisterForm 객체를 생성해서 담는다.
  model.addAttribute("registerForm", new UserRegisterForm());

  return "register-form";
}
```

3. 입력폼 화면을 JSP를 이용해서 작성한다.
```jsp
// 아래의 태그 라이브러리는 곡 필요하다.
<!-- spring 폼 태그 라이브러리 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

// registerForm이라는 이름의 객체에 담긴 값을 이용함.
// path="입력필드명"
<form:form method="post" action="register" modelAttribute="registerForm">
    <div>
          <label>이메일</label>
          <form:input path="email" />
            <!-- 위의 태그는 <input type="text" name="email" id="email" value="${registerForm.email}">과 같이 생성된다. -->
          <form:errors path="email" />
            <!-- 위의 태그는 email 입력값이 유효성을 통과하지 못했을 때 오류 메세지가 표시된다. -->
    </div>
    <div>
          <label>비밀번호</label>
          <form:password path="password" />
          <form:errors path="password" />
    </div>
    <div>
          <label>닉네임</label>
          <form:input path="nickname" />
          <form:errors path="nickname" />
    </div>
    <div>
          <label>전화번호</label>
          <form:input path="tel" />
          <form:errors path="tel" />
    </div>
    <button type="submit">등록</button>
</form:form>
```

4. 신규 회원정보 등록 요청을 처리하는 요청핸들러 메소드를 정의한다.
   + Java Validation API 기반의 유효성 검증을 실행하게 한다.
   + 유효성 검증 통과여부를 체크한다.
   + 개발자가 추가적인 유효성 검증을 실시한다.
   + 유효성 검증을 통과했다면 업무로직 메소드를 호출해서 업무로직을 실행시킨다.
   + 뷰이름(재요청할 URL)을 응답으로 보낸다.
     
```java
/*
  @Valid, @Validated
    + 폼 입력값 유효성 검증 기능을 활성화 시키는 어노테이션이다.
    + @Valid는 Java Validation API의 어노테이션이고, @Validated는 Spring의 어노테이션이다.
  @ModelAttribute
    + 이 어노테이션이 붙으면 해당 값 혹은 객체는 Model 객체에 지정된 이름으로 저장된다.
    + 이름을 생략하거나 이 어노테이션을 생략하면 변수명과 동일한 이름으로 Model 객체에 저장된다.
    + 아래의 코드에서 @ModelAttribute("registerForm")을 사용한 이유는 유효성 검증을 통과하지 못해서 다시 입력폼으로 내부이동했을 때,
      입력폼에 값을 출력해야 하는데,
      2번 항목에서 model.addAttribute("registerForm", new UserRegisterForm()); 수행문을 실행해서 Model 객체에 UserRegisterForm 객체를 저장하고
      3번 항목에서 <form:form modelAttribute="registerForm">으로 적어서 값을 표시할 객체를 "registerForm"이라는 이름으로 찾고 있기 때문이다.
    Model 객체에 저장하는 이름을 "registerForm"으로 지정해야 한다.
*/
@PostMapping("/register")
public String register(@Valid @ModelAttribute("registerForm") UserRegisterForm form, BindingResult errors) {
    // 유효성 검증 통과여부를 체크한다.
    if (errosr.hasErrors()) {
       return "register-form"; // 유효성 검증을 통과하지 못했기 때문에 입력폼 jsp로 내부이동시킨다.
    }

    // 비밀번호와 비밀번호확인 값이 일치하는지 체크한다.
    if(!form.getPassword().equals(form.getPasswordConfirm())){
    // 유효성 검증 실패정보를 BindingResult 객체에 추가한다.
    // BindingResult는 단순히 검증결과 정보만 담는 것이다.
      errors.rejectValue("passwordConfirm", null, "비밀번호가 일치하지 않습니다.");
      return "register-form";
    }

    // 업무로직 메소드를 호출한다.
    userService.addNewUser(form);

    return "redirect:/";
  }
```

### BindingResult 객체
  + @Valid 어노테이션으로 입력값 검증을 수행하고, 검증결과를 BindingResult 객체에 담기 때문에
  + 검증결과를 전달받기 위해서 BindingResult 타입의 객체를 선언하는 것이다.
  + 주요 API
    - boolean hasErrors() : 유효성체크를 통과하지 못한 항목이 하나라도 있으면 true를 반환한다.
    - void rejectValue(String fieldName, String errorCode, String defaultValue)
      : 개발자가 추가적인 유효성 검증을 실시하고, 유효성 검증을 통과하지 못했을 때 위의 메소드를 실행해서 BindingResult에 FieldError를 추가한다.
        - fieldName : 입력필드의 이름
        - errorCode : 오류메세지를 별도의 properties 파일로 정의했을 때 코드=오류메시지와 같은 형식으로 적는다. [목적 국제화 처리]
      ```
      // 에러 코드가 존재하는 이유
      messages.properties
      error.register.email=required email

      messages_en.properties
      error.register.email=required email

      messages_ko.properties
      error.register.email=이메일은 필수입력값입니다.

      messages_ja.properties
      error.register.email=일본어로 ㅌㅌㅌㅌㅌ

      messages_cn.properties
      error.register.email=중국어로 ㅌㅌㅌㅌㅌ 
      ```
        - defaultMessage : 기본 오류 메세지

## 입력값 유효성 검사
1. 어노테이션
2. 사용자가 입력한 입력값을 검증
3. 예외클래스 사용
