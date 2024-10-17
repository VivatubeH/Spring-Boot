Spring MVC의 주요 어노테이션
--------------------------------------

### @Controller
  + 해당 클래스가 HTTP 요청을 처리하는 컨트롤러 클래스임을 나타낸다.
  + 해당 컨트롤러의 요청핸들러 메소드는 HTML 페이지를 응답으로 제공한다.
    * 요청핸들러 메소드의 반환값은 String(뷰이름, JSP페이지의 경로 및 파일명)이다.
  + JSP(HTML) 기반의 웹 애플리케이션을 구현할 때 사용하는 어노테이션이다.
    
### @RestController
  + 해당 클래스가 HTTP 요청을 처리하는 컨트롤러 클래스임을 나타낸다.
  + 해당 컨트롤러의 요청핸들러 메소드는 JSON 혹은 XML 응답 데이터를 제공한다.
    * 요청핸들러 메소드의 반환값은 객체(JSON 혹은 XML로 변환할 정보를 담고 있는 객체)다.
  + REST API 애플리케이션을 구현할 때 사용하는 어노테이션이다.
  + 필수적으로 사용자와 상호작용하는 별도의 프론트엔드 애플리케이션 개발이 필요하다. ( 이쁘게 뿌려줘야 하니깐 )
      * 프론트엔드 애플리케이션은 react, vue,js 등을 이용해서 개발할 수 있다.
   
### @RequestMapping
  + 요청URL과 컨트롤러, 요청URL과 요청핸들러 메소드를 매핑한다.
  + 주로 @RequestMapping은 클래스 레벨의 매핑정보를 정의할 때 사용한다.
      요청핸들러 메소드 레벨의 매핑정보는 @GetMapping, @PostMapping, @PutMapping, @DeleteMApping을 사용한다.
  + 주요 속성
    - path
      * 매핑되는 요청 URL이다.
      * @RequestMapping(path = "/")    혹은 @RequestMapping("/")
      * @RequestMapping(path = {"/info", "/detail"})    혹은 @RequestMapping({"/info", "/detail"})
    - method
      * 매핑되는 요청 방식이다.
      * @RequestMapping(method = RequestMethod.GET)
      * GET, POST, PUT, DELETE 등을 지정할 수 있다.  
  + 사용예)
      ```java
      @Controller
      @RequestMapping("/emp")
      public class EmployeeController {

        @RequestMapping("/list")  <-- /emp/list 요청에 매핑된다.
        public String employees() {

        }
        @RequestMapping("/detail") <-- /emp/detail 요청에 매핑된다.
        public String employee() {
          
        }
      }
      ```
