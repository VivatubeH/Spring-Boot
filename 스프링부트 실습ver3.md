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
