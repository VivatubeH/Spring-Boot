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
