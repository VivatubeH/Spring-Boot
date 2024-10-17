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
      * 매핑되는 요청 방식이다. 지정하지 않으면 요청방식은 상관하지 않는다.
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

      ```java
      // 주로 사용하는 방식
      @Controller
      @RequestMapping("/emp") // 클래스 레벨
      public class EmployeeController {

        @GetMapping("/list") // 메소드 레벨
        public String employees() {

        }

        @GetMapping("/detail")
        public String employee() {

        }

        @PostMapping("/add")
        public String register() {

        }
      }
      ```
      
### @RequestParam
  + 요청파라미터값을 매핑하는 어노테이션이다.
  + @RequestParam 없이 요청파라미터값을 요청핸들러 메소드의 매개변수에 매핑할 수 있지만,
    - 해당 요청파라미터값은 무조건 필수 요청파라미터 값이 된다.
    - 매개변수의 이름과 동일한 이름의 요청파라미터 값이 매핑된다.
  + 주요 속성
      * name
          - 요청 파라미터의 이름을 지정한다.
      * required
          - 필수 요청파라미터인지 여부를 지정한다. 기본값은 true다.
          - 필수 요청파라미터 값이 아닌 경우에는 false로 설정한다.
      * defaultValue
          - 필수 요청파라미터값이 아닌 경우 요청파라미터 값이 없을 때 사용되는 기본값을 지정한다.
          - 문자열 형식으로 지정한다. ( 어차피 문자열 형식으로 지정해도 타입을 적절히 변환해줌. )
  + 사용예

  ```java
  @PostMapping("/login")
  public String login(@RequestParam("id") String id,  // request.getParameter("id")로 조회되는 값을 전달
                      @RequestParam("pwd") String pwd) {// request.getParameter("pwd")로 조회되는 값을 전달
  }

  /*
    요청 URL
      http://localhost/emp/list
      http://localhost/emp/list?page=2
      http://localhost/emp/list?page=2&sort=급여
  */

  
  // 올 수도 안 올수도 있는 값은 RequestParam을 반드시 사용하고, required = false, defaultValue 지정이 필요.
  // null이 들어갈 수 없는 곳에는 defaultValue를 생략할 수 없다.
  @GetMapping("/list")
  public String employees(@RequestParam(name = "page", required = false, defaultValue = "1") int page,  
                          @RequestParam(name = "sort", required = false, defaultValue = "name") String sort) {  

  }
