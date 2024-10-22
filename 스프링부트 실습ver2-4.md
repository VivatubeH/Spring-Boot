### 아래 그림은 참고용이고, 실제 데이터와는 다름.

![image](https://github.com/user-attachments/assets/791bb5d1-15b5-48f1-8272-76f0f7a0e6e1)

### 페이지 네이션에 기본적으로 들어갈 데이터

![image](https://github.com/user-attachments/assets/a5a97191-2ba9-4fea-9023-53a443b030cc)

### 어떻게 보낼지, 자바스크립트 함수를 어떻게 짤 지, 어떻게 받을지 로직을 잘 기억하기

![image](https://github.com/user-attachments/assets/597baa7e-c8d1-4540-aabb-059ac6ce6912)

### 참고할 페이지, 로직 따라가는 연습하기

- preferences-Content Assist- insert parameter types

## VO와 DTO의 차이
- VO: 값을 표현하는 객체
  
![image](https://github.com/user-attachments/assets/6ffdf719-f320-4728-aa4c-b68e1bbee5b2)

#### Boolean 타입은 get 대신 is가 접두사로 붙는다. 고로 isFirst가 아닌 first로 쓰면 된다.

애플리케이션 테스트하기
-----------------------------------------------------------
+ 테스트의 종류
    - 단위테스트 [ JUnit - 자바에 대한 단위 테스트 ] [ 개발자가 수시로 수행한다 ]
      * 애플리케이션의 개별 기능을 검증하기 위해서 수행하는 테스트다.
      * 단위테스트의 목적은 보통 하나의 기능 혹은 하나의 메소드가 의도하는 대로 동작하는지 테스트한다.
      * 주로 개발자가 자신이 개발하는 코드를 테스트하기 위해 실시한다.
      * JUnit, TestNG 등의 단위테스트 프레임워크를 이용해서 테스트 케이스를 작성하고, 테스트한다.

    - 통합테스트 
      * 애플리케이션의 여러 모듈들이 잘 통합되어 작동하는지 검증하기 위해서 수행하는 테스트다.
      * 통합테스트의 목적은 여러 모듈강의 상호작용이 정상적으로 동작하는 테스트한다.
      * 애플리케이션 개발 단계에서 각 모듈의 구현이 완료되고, 단위객체가 완료된 모듈간의 상호작용을 검증하기 위해 수행한다.

    - 부하테스트
      * 애플리케이션에 예상되는 최대 부하를 가해서, 시스템이 얼마나 잘 견디는지 테스트하는 것이다.
      * 실제 트래픽과 유사한 조건을 만들어서 측정을 수행하며, 주로 응답시간과 시스템의 안정성을 측정한다.
      * JMeter 등의 부하테스트 도구를 이용해서 테스트 한다.
     
## 단위 테스트하기
 - 단위테스트는 애플리케이션의 개별적인 기능을 검증하는 테스트다.
 - 단위테스트용 테스트 케이스를 작성할 때  JUnit 프레임워크를 사용한다.
 - JUnit5
   	* 자바 애플리케이션 테스트에 가장 많이 사용되는 단위테스트 프레임워크다.
   	* JUnit4를 더 발전시켜서 다양한 테스트 기능과 확장성을 제공한다.
   	* 기본 구조 그림은 참고용이고, 실제 데이터와는 다름.

![image](https://github.com/user-attachments/assets/791bb5d1-15b5-48f1-8272-76f0f7a0e6e1)

### 페이지 네이션에 기본적으로 들어갈 데이터

![image](https://github.com/user-attachments/assets/a5a97191-2ba9-4fea-9023-53a443b030cc)

### 어떻게 보낼지, 자바스크립트 함수를 어떻게 짤 지, 어떻게 받을지 로직을 잘 기억하기

![image](https://github.com/user-attachments/assets/597baa7e-c8d1-4540-aabb-059ac6ce6912)

### 참고할 페이지, 로직 따라가는 연습하기

- preferences-Content Assist- insert parameter types

## VO와 DTO의 차이
- VO: 값을 표현하는 객체
  
![image](https://github.com/user-attachments/assets/6ffdf719-f320-4728-aa4c-b68e1bbee5b2)

#### Boolean 타입은 get 대신 is가 접두사로 붙는다. 고로 isFirst가 아닌 first로 쓰면 된다.

애플리케이션 테스트하기
-----------------------------------------------------------
+ 테스트의 종류
    - 단위테스트 [ JUnit - 자바에 대한 단위 테스트 ] [ 개발자가 수시로 수행한다 ]
      * 애플리케이션의 개별 기능을 검증하기 위해서 수행하는 테스트다.
      * 단위테스트의 목적은 보통 하나의 기능 혹은 하나의 메소드가 의도하는 대로 동작하는지 테스트한다.
      * 주로 개발자가 자신이 개발하는 코드를 테스트하기 위해 실시한다.
      * JUnit, TestNG 등의 단위테스트 프레임워크를 이용해서 테스트 케이스를 작성하고, 테스트한다.

    - 통합테스트 
      * 애플리케이션의 여러 모듈들이 잘 통합되어 작동하는지 검증하기 위해서 수행하는 테스트다.
      * 통합테스트의 목적은 여러 모듈강의 상호작용이 정상적으로 동작하는 테스트한다.
      * 애플리케이션 개발 단계에서 각 모듈의 구현이 완료되고, 단위객체가 완료된 모듈간의 상호작용을 검증하기 위해 수행한다.

    - 부하테스트
      * 애플리케이션에 예상되는 최대 부하를 가해서, 시스템이 얼마나 잘 견디는지 테스트하는 것이다.
      * 실제 트래픽과 유사한 조건을 만들어서 측정을 수행하며, 주로 응답시간과 시스템의 안정성을 측정한다.
      * JMeter 등의 부하테스트 도구를 이용해서 테스트 한다.
     
## 단위 테스트하기
 - 단위테스트는 애플리케이션의 개별적인 기능을 검증하는 테스트다.
 - 단위테스트용 테스트 케이스를 작성할 때  JUnit 프레임워크를 사용한다.
 - JUnit5
   	* 자바 애플리케이션 테스트에 가장 많이 사용되는 단위테스트 프레임워크다.
   	* JUnit4를 더 발전시켜서 다양한 테스트 기능과 확장성을 제공한다.
   	* JUnit5는 아래 3가지 모듈로 구성된다.
   	* 기본 구조
   	  	+ JUnit Platform : JUnit5 기반으로 테스트를 실행하고 결과를 제공하는 실행환경이다.
   	  	+ JUnit Jupiter : JUnit5에서 테스트를 작성하고 확장하기 위한 새로운 프로그래밍 모델을 제공한다.
   	  	+ JUnit Vintage : 하위 호환성을 위해 JUnit3와 JUnit4를 기반으로 작성된 테스트 케이스를
   	  	  JUnit5에서 실행할 수 있도록 지원하는 모듈이다.
   	* JUnit5의 주요 어노테이션
   	  - @Test : 테스트 메소드임을 나타내는 어노테이션이다. 테스트 메소드를 정의할 때 사용된다.
   	  - @BeforeEach
   	    + 각 테스트 메소드가 실행되기 전에 매번 실행되는 메소드임을 나타내는 어노테이션이다.
   	    + 각 테스트 메소드 실행전에 공통으로 수행한 사전작업을 정의할 때 사용한다.
   	    + 예) 주로 테스트 실행에 필요한 Dummy 데이터를 미리 세팅하기 위해 사용한다.
   	  - @AfterEach
   	    + 각 테스트 메소드가 종료된 후에 매번 실행되는 메소드임을 나타내는 어노테이션이다.
   	    + 각 테스트 메소드 실행 후에 공통으로 수행하는 사후 작업을 정의할 때 사용한다.
   	    + 예) 주로 테스트에 실행과정에서 변경된 데이터를 초기화하거나 삭제하는 작업을 실행하기 위해서 사용한다.
   	  - @BeforeAll
   	    + 모든 테스트 메소드가 실행되기 전에 딱 한 번 실행되는 메소드임을 나타내는 어노테이션이다.
   	    + 반드시 static 메소드로 정의한다.
   	  - @AfterAll
   	    + 모든 테스트 메소드가 실행된 후에 딱 한 번 실행되는 메소드임을 나타내는 어노테이션이다.
   	    + 반드시 static 메소드로 정의한다.
   	  - @Disabled
   	    + 해당 테스트 메소드의 테스트를 비활성화한다.
   	  - @DisplayName
	    + 테스트 메소드에 적절한 이름을 부여한다.
   	    + 테스트 결과를 출력할 때 테스트 메소드 이름 대신 DisplayName에서 작성한 내용이 출력된다.
   	  - @Timeout
   	    + 지정된 시간내에 테스트가 완료되지 않으면 실패로 판정한다.

* JUnit5의 주요 Assertions
  + JUnit5는 테스트 결과를 검증하기 위한 다양한 메소드를 제공한다.
  + 아래의 메소드는 전부 Assertions의 정적 메소드다.
    - assertEquals(expected, actual) : 두 값이 일치하는 지 확인한다.
    - assertNotEquals(expected, actual) : 두 값이 일치하지 않는지 확인한다.
    - assertTrue(condition) : 조건이 참인지 확인한다.
    - assertFalse(condition) : 조건이 거짓인지 확인한다.
    - assertNull(object) : 객체가 null인지 확인한다.
    - assertNotNull(object) : 객체가 null이 아닌지 확인한다.
    - assertThrows(expectedType, executable) : 특정 실행에서 예상했던 예외가 발생하는지 확인한다.

 - 스프링부트의 단위테스트
   + spring boot는 JUnit5, Mockito 등의 도구(프레임워크)를 통해서 쉽게 단위테스트를 작성할 수 있도록 지원한다.
   + spring boot에서는 컨트롤러, 서비스, 데이터베이스, 영속화와 같은 각 계층에 맞는 단위테스트 케이스를 작성하고 테스트할 수 있다.
   + spring boot의 테스트 starter 의존성
```spring
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```
* 이 의존성은 spring boot 애플리케이션에 기본으로 포함되는 의존성이다.
* 이 의존성은 JUnit5, Mockito, AssertJ등 다양한 테스트 라이브러리를 제공한다.

+ spring boot 애플리케이션에서 단위테스트 작성하기
  * spring boot 애플리케이션에서는 단위테스트를 2가지로 구분해서 작성할 수 있다.
  * spring 컨테이너가 필요없는 단위테스트와 spring 컨테이너에 의존적인 단위테스트가 있다.

  * spring 컨테이너가 필요없는 단위 테스트
  ```java
    public class SampleTest {
      @Test
      public void testSomething() {
         ...
      }
    }
  ```
  * spring 컨테이너에 의존적인 단위 테스트
  ```java
  // 전체 애플리케이션의 모든 객체를 생성하고 조립하는 스프링 컨테이너가 생성된다.
  // @Autowired를 사용해서 테스트가 필요한 객체를 주입받을 수 있다.
  @SpringBootTest
  public class SampleTest {
    // 테스트 대상이 되는 기능이 구현된 객체를 주입받는다.
    @Autowired
    SomeService someService;

    @Test
    public void testSomething() {
       ...
    }
  }
  ```
- 테스트 클래스와 메소드 작성하기
  * 테스트 작성하기

```java

public class SampleTest {

	@Test
	public void testPlus() {
		int num1 = 2;
		int num2 = 3;
		int result = num1 + num2;

		// assertEquals(expected, actual)
		assertEquals(5, result);
	}
}

```
#### JUnit Test 하기 [ src/test/java 폴더의 패키지에 저장할 자바 코드 ]
#### 실행은 우클릭 -> run as -> JUnit [ 좌측에 초록색 막대가 뜨면 테스트 성공! ]

##### JUnit 참고 사이트 : https://donghyeon.dev/junit/2021/04/11/JUnit5-%EC%99%84%EB%B2%BD-%EA%B0%80%EC%9D%B4%EB%93%9C/

``` java
package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.util.Pagination;

@SpringBootTest
class PaginationTests {

	@Test
	public void testPagination() {
		Pagination p1 = new Pagination(1, 0);
		assertThat(p1.getTotalPages()).isEqualTo(0);
		
		Pagination p2 = new Pagination(1, 53);
		assertThat(p2.getTotalPages()).isEqualTo(6);
		assertThat(p2.getTotalBlocks()).isEqualTo(2);
		assertThat(p2.getBeginPage()).isEqualTo(1);
		assertThat(p2.getEndPage()).isEqualTo(5);
		
		Pagination p3 = new Pagination(6, 53);
		assertThat(p3.getTotalPages()).isEqualTo(6);
		assertThat(p3.getTotalBlocks()).isEqualTo(2);
		assertThat(p3.getBeginPage()).isEqualTo(6);
		assertThat(p3.getEndPage()).isEqualTo(6);

		Pagination p4 = new Pagination(2, 53, 20);
		assertThat(p4.getTotalPages()).isEqualTo(3);
		assertThat(p4.getTotalBlocks()).isEqualTo(1);
		assertThat(p4.getBeginPage()).isEqualTo(1);
		assertThat(p4.getEndPage()).isEqualTo(3);
	}

}

```

#### JUnit에서 Errors : 실행 시 오류가 발생한 것. [ 테스트가 실행이 안 된 것 ]
#### JUnit에서 Failures : 예상한 결과가 다른 결과가 나온 것. [ 개발자의 코딩 실수나 테스트 케이스 결과에 대한 예측 실패 ] 

