#### ResponseEntity
 + 요청핸들러 메소드에서 응답을 제공할 때 사용하는 객체다.
 + 주로, 요청핸들러 메소드가 응답 데이터를 반환할 때 사용된다.
   * JSP 페이지로 내부이동시키거나 재요청 URL을 반환할 때는 사용하지 않는다.
   * 주로, REST API를 구현할 때 JSON, XML 데이터를 응답으로 제공할 때 사용한다.
   * <mark>첨부파일을 다운로드할 때 사용한다.</mark>
 + ResponseEntity 객체는 응답메세지의 헤더부, 바디부에 포함될 정보를 설정할 수 있고, HTTP 응답코드를 설정할 수 있다.
 + 사용예
    ```java
    public ResponseEntity<Book> book(int no) {
       Book book = bookService.getBookDetail(no);

       return ResponseEntity.ok(book);
    }
    ```
    * ok() 메소드는 HTTP 응답코드 200을 설정한다.
    * ok(데이터) 메소드의 매개변수로 응답데이터를 지정한다.
    * 데이터는 JSON 혹은 XML로 변환되어 HTTP 응답메세지의 바디부에 포함되어 보내진다.
  
   ```java
   public ResponseEntity<Book> book(int no) {
     Book book = bookService.getBookDetail(no);
     if (book != null) {
       return ResponseEntity.ok(book);
     } else {
       return ResponseEntity.notFound();
     }
   }
   ```
   
   * notFound() 메소드는 HTTP 응답코드 404를 설정한다.
   * notFound() 메소드는 요청한 자원을 찾을 수 없을 때 사용하는 메소드다.

   ``` java
   public ResponseEntity<Resource> download(int boardNo) {
     
   }
   ```
   
