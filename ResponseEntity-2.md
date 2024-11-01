ResponseEntity<X>
------------------------------------------------
- HTTP 응답을 표현하는 객체다.
- HTTP 응답코드, 요청헤더정보, 응답 바디부정보를 제어할 수 있다.

- T는 응답메세지의 바디부에 포함될 데이터의 타입이다.
  + 우리 프로젝트에서는 언제나 X는 RestResponseDto<T>

- 사용예
```
{
  status: 200,
  message: "성공",
  data: "exists" <------- T는 String
}
```
```java
public ResponseEntity<RestResponseDto<String>> xxx() {
  //
}
```

```
{
  status: 200,
  message: "성공",
  data: {"no": 10, "title":"댓글연습", ...} <------- T는 Comment
}
```
```java
public ResponseEntity<RestResponseDto<Comment>> xxx() {
  //
}
```
