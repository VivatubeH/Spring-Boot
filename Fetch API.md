Fetch API
----------------------------------------------------------------
- JavaScript에서 서버와 HTTP 통신을 수행할 수 있도록 지원하는 함수다.
- 서버로 HTTP 요청을 보내고, 서버로부터 HTTP 응답을 받아올 수 있다.
- 사용법

```javascript
// 서버로 요청보내기
// 서버로 요청을 보내면 Promise 객체가 반환된다.
// Promise 객체는 후속처리 메소드를 가지고 있다.
// 후속처리 메소드
//  then(콜백함수) : 요청처리가 성공했을 때 실행되는 후속처리 메소드다.
//                   지정된 콜백함수를 실행시킨다.
//                   콜백함수를 실행할 때 HTTP 응답이 포함되어 있는 response를 전달한다.
//  catch(콜백함수) : 요청처리가 실패했을 때 실행되는 후속처리 메소드다.
//  finally(콜백함수) : 요청처리가 완료되었을 때(성공/실패 상관없이) 실행되는 메소드다.

// fetch 메소드를 비동기 방식으로 실행시킨다.
// await 키워드는 요청처리가 완료될 때가 기다린다.
// await 키워드를 사용할 경우 해당 함수에는 async 키워드를 붙여서
// 함수내부에서 비동기 통신을 수행하고 있음을 나타낸다.

// fetch() 함수를 실행시켜 서버로 HTTP 요청을 보낸다.
// fetch() 함수를 실행하면 Response 객체가 획득된다.
// Response 객체는 응답데이터를 의미하는 것이 아니라 HTTP 응답 그자체를 의미하는 객체다.
// 즉, 아직 서버로부터 응답데이터를 받은 것은 아니다.
let response = await fetch(요청 URL);

// Response 객체의 text() 메소드를 실행해서 최종 응답데이터를 획득한다.
// 클라이언트쪽에서 요청을 잘못해서 404 오류가 발생하더라도 Response 객체는 반환되기 때문에
// 응답성공여부를 체크해야 한다.
if (response.ok) {
  let data = await response.text(); // 일반 텍스트 데이터의 획득
  let jsonData = await response.json(); // json 데이터의 획득 [ 자바스크립트 객체 혹은 배열이 획득된다. ]
}
```

case1 
-------------

```java
@GetMapping("/test1")
public String something() {
  return "연습"; // "연습"
}
```

```javascript
let response = awiat fetch("/test1");
let data = await response.text();
console.log(data); // "연습"
```

case2
--------------------

```java
@GetMapping("/test2")
public User something(int no) {
  User user = userService.getUserByNo(no); // {"no":10, "email":"hong@gmail", nickname:"홍길동"}
  return user;
}
```

```javascript
let response = await fetch("/test2");
let data = await response.json(); // 전달받은 json 형식 텍스트를 자바스크립트 객체로 변환한 다음 반환한다.
console.log(data); // 자바스크립트 객체 {no:10, email:"hong@gmail.com", nickname:"홍길동"}
console.log(data.no);
console.log(data.email);
console.log(data.nickname);
```

case3
---------------------------

```java
@GetMapping("/test3")
public Map<String, Object> something(int no) { // '{"id":"hong", "point":10, "deleted":false}'
  Map map = new HashMap<>();
  map.put("id", "hong");
  map.put("point", 100);
  map.put("deleted", false);

  return map;
}

```javascript
let response = await fetch("/test3");
let data = await response.json(); // 전달받은 json 형식 텍스트를 자바스크립트 객체로 변환한 다음 반환한다.
console.log(data); // 자바스크립트 객체 {id: "hong", point: 10, deleted: false}

console.log(data.id);
console.log(data.point);
console.log(data.deleted);
```

case4
----------------------

```java
@GetMapping("/test4")
public List<String> something() { // '["홍길동", "김유신", "강감찬", "이순신"]'
  List<String> usernames = userService.getAllUserNames(); 
  return usernames;
}
```

```javascript
let response = await fetch("/test4");
let data = await response.json(); // 전달받은 son형식 텍스트를 자바스크립트 배열로 변환한 다음 반환한다.
console.log(data); // 자바스크립트 배열 ["홍길동", "김유신", "강감찬", "이순신"]
console.log(data[0]);
console.log(data[1]);
console.log(data[2]);
```

case5
--------------------------------

```java
@GetMapping("/test5")
public List<User> something() { // '[{"no": 10, "name":"홍길동"}, {"no":10, "name":"홍길동"}]'
  List<User> users = userService.getAllUsers();
  return user;
}
```

```javascript
let response = await fetch("/test5");
let data = await response.json(); // 전달받은 json 형식 텍스트를 자바스크립트 배열로 변환한 다음 반환한다.
console.log(data); // 자바스크립트 배열 객체 [ {no:10, name:"홍길동"}, {no:20, name:"김유신"} ]
console.log(data[0].no);
console.log(data[0].name);
console.log(data[1].no);
console.log(data[1].name);
```
