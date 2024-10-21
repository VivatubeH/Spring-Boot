![image](https://github.com/user-attachments/assets/17951490-d671-4fd1-8fe9-37d543790f0a)

spring starter project 생성 -> 위의 6개 라이브러리 의존성 추가

![image](https://github.com/user-attachments/assets/db559bf9-7ab4-4d67-be41-95e92fa97920)

application.properties 이름을 application.wml로 변경하기

YAML 파일
- Configuration 파일을 작성할 때 사용되는 마크업이다.
- 확장자는 .yaml과 .yml 모두 가능하다.
- 기존의 xml, json, propertie 형식으로 설정 정보를 작성했던 것을 yaml로 대체하는 추세다.
- 대표적인 사용예
  + docker composer
  + kubernates
  + spring boot
  
- 작성법
    + 들여쓰기
      * 들여쓰기는 기본적으로 2칸 들여쓰기를 지원한다.
      * 절대!! 탭으로 들여쓰기 하면 안된다.
      * 작성예시
     
```yml
book:
  no: 10
  title: 이것이 자바다 // 2칸 들여쓰기
  author:
    - 홍길동 // 4칸 들여쓰기 ( 2 + 2 칸 )
    - 김유신
```

+ 값의 정의
  * 데이터는 key: value의 형식으로 정의한다.
  * value는 ":"에서 공백 한 칸 다음에 작성한다.
  * value의 값이 숫자, 불린형, 문자열인 경우
    - 숫자: 10, -10, 3.14
    - 불린: true, false
    - 문자열: 안녕하세요, "안녕하세요", 김 유신, '김유신', "경기결과는 1:2입니다." [ 띄어쓰기 있어도 상관없음 ]
    - 단, 문자열값에 ":"이 포함되어 있는 경우는 반드시 따옴표로 감싼다.

+ 콜렉션 값의 정의
  * 값이 하나 이상인 경우 "-"를 적고 작성한다.
  * 단순배열과 객체배열 형식으로 작성할 수 있다.
  * 단순배열은 기본자료형 혹은 문자열값이 여러 개다.
  * 객체배열은 key: value 구조를 이용해서 객체가 포함된 배열을 표현한다.
    
  ```yml
  // 단순배열일 때
  filenames:
    -a.txt
    -b.txt
    -c.txt
  ```

  ```yml
  // 객체배열일 때
  books:
    - no: 10
      title: 이것이 자바다.
      author: 김유신
    - no: 13
      title: 저것이 자바다
      author: 강감찬
  ```
  
  * 작성예
  
  ``` yml
  book:
    no: 10
    title: 이것이 자바다
    authors:
      - 김유신
      - 강감찬
      - 이순신
  ```

  + 주석
    * "#" 다음에 적는 내용은 주석이다.
    * 작성예

  ``` yml
  book:
    no: 10
    title: 이것이 자바다
    authors:  #저자는 여러 명이다
      - 김유신
      - 강감찬
      - 이순신
  ```
