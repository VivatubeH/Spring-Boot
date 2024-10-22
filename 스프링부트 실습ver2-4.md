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

#### JUnit Test 하기 [ src/test/java 폴더의 패키지에 저장할 자바 코드 ]
#### 실행은 우클릭 -> run as -> JUnit [ 좌측에 초록색 막대가 뜨면 테스트 성공! ]
```java
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
