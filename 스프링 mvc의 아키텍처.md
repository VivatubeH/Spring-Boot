![스프링MVC 아키텍처](https://github.com/user-attachments/assets/047b4255-c160-42fb-8183-499db1f4d716)

### 참고 : 아키텍처는 '서비스의 동작 원리' 정도로 이해하는 게 좋다.

#### DispatcherServlet : 스프링 프로젝트의 단일 진입점이 된다. 
#### HandlerMapping : 요청 정보들에 대해 어떤 컨트롤러를 실행해야 할 지 정보를 돌려준다.
#### HandlerAdapter : 요청 핸들러 메소드의 매개변수를 분석해서 주입해준다. 컨트롤러의 요청 핸들러 메소드를 직접 실행시켜준다.
#### viewResolver : "home"이라는 뷰 이름을 분석해서 실제 경로에 있는 View 객체를 제공해준다.

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
    
- HandleAdapter

- Controller

- View

- ViewResolver
