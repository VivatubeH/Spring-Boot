![스프링MVC 아키텍처](https://github.com/user-attachments/assets/047b4255-c160-42fb-8183-499db1f4d716)

### 참고 : 아키텍처는 '서비스의 동작 원리' 정도로 이해하는 게 좋다.

#### DispatcherServlet : 스프링 프로젝트의 단일 진입점이 된다. 
#### HandlerMapping : 요청 정보들에 대해 어떤 컨트롤러를 실행해야 할 지 정보를 돌려준다.
#### HandlerAdapter : 요청 핸들러 메소드의 매개변수를 분석해서 주입해준다. 컨트롤러의 요청 핸들러 메소드를 직접 실행시켜준다.
#### ViewResolver : "home"이라는 뷰 이름을 분석해서 실제 경로에 있는 View 객체를 제공해준다.

Spring mvc의 구성요소
----------------------------------------------------
- DispatcherServlet
    + spring mvc가 제공하는 **프론트 컨트롤러**다.
    + 클라이언트가 HTTP 요청을 보낼때마다 항상 DispatcherServlet이 그 요청을 접수받는다.
    + 프론트 컨트롤러, 즉 모든 HTTP 요청의 **단일 진입점**이 된다.
    + 스프링 mvc가 HTTP 요청을 처리할 때 사령부 역할을 수행한다.
    + 어떤 컨트롤러를 실행할 지? -> HandlerMapping에게 질의해서 알아낸다.
    + 컨트롤러 실행은? -> HandlerAdapter를 이용해서 Controller를 실행한다.
    + 어떤 응답을 보낼 지? -? ViewResolver에게 질의한다.
    
- HandlerMapping
    + URL 매핑정보를 분석한다. ( HTTP 요청을 처리할 요청 핸들러 메소드가 무엇인지를 분석해낸다. )
    + ***@Controller, @RestController*** 어노테이션이 부착된 모든 객체의 매핑정보를 분석한다.
    + 매핑 정보는 @RequestMapping, @PostMapping, @GetMapping, @PutMapping, @DeleteMapping 어노테이션으로 정의된 정보다.
    + DispatcherServlet이 요청을 접수받으면 HandlerMapping에게 이 요청을 처리할 컨트롤러 혹은 요청핸들러 정보를 요구한다.
    + HandlerMapping은 HandlerExceptionChain 객체에 핸들러(컨트롤러)와 인터셉터를 담아서 반환한다.
    + HandlerMapping의 구현체중에서 RequestMappingHandlerMapping의 기본 핸들러매핑으로 사용한다.
      
- HandleAdapter
    + HTTP 요청을 실질적으로 처리하는 컨트롤러의 요청핸들러 메소드 실행을 담당한다.
    + DispatcherServlet은 HandlerAdapter에게 컨트롤러의 요청핸들러 메소드 실행을 위임한다.
    + HandlerAdapter가 수행하는 일
        * 요청핸들러 메소드의 매개변수를 분석한다.
        * 매개변수를 분석해서 요청객체에서 요청파라미터값을 추출하고, 매개변수의 인자값을 전달할 준비를 한다.
        * 매개변수를 분석해서 이미 약속된 타입의 매개변수가 정의되어 있으면, 해당 객체를 획득/생성해서 매개변수의 인자값으로 전달할
          준비를 한다. [ 예약된 매개변수가 아니면 요청 파라미터로 간주한다. ]
        * 요청핸들러 메소드를 호출한다. ( 위에서 미리 준비한 값을 메소드 호출시 전달한다. )
        * 요청핸들러 메소드의 반환값을 분석한다.

    ```java
    register(User user, Model model) {
       // 예약된 이름이 아니면 핸들러는 요청 파라미터로 간주하기 때문에 User는 요청 파라미터로 간주한다.
       // 핸들러 어댑터는 User를 분석해서 필드들의 타입과 이름을 알아낸다.
    }
    ```
    
- Controller
    + HTTP 요청을 처리한다.
    + 하나의 컨트롤러는 여러 개의 요청 핸들러 메소드를 가진다.
    + 각각의 요청핸들러 메소드는 HTTP 요청 하나와 매핑된다.
    + 요청핸들러 메소드의 역할
        * 클라이언트가 서버로 보낸 요청파라미터값을 전달받을 매개변수를 정의한다.
        * 뷰페이지에 전달한 값을 담는 Model 객체를 매개변수로 정의한다.
        * 매개변수로 전달받은 요청파라미터값의 유효성 검증을 수행한다.
        * 유효성 검증이 완료된 값을 서비스에 전달해서 업무로직을 실행시킨다.
        * 업무로직 수행결과 획득된 정보를 Model 객체에 담아서 뷰에 전달되게 한다.
        * 정보를 표현할 뷰이름(JSP 페이지의 경로 및 파일명)을 반환한다.
- View

- ViewResolver
