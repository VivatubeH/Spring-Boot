![image](https://github.com/user-attachments/assets/17951490-d671-4fd1-8fe9-37d543790f0a)

spring starter project 생성 -> 위의 6개 라이브러리 의존성 추가

![image](https://github.com/user-attachments/assets/db559bf9-7ab4-4d67-be41-95e92fa97920)

application.properties 이름을 application.wml로 변경하기

YAML 파일
- Configuration 파일을 작성할 때 사용되는 마크업이다.
- 확장자는 .yaml과 .yml 모두 가능하다.
- 기존의 xml, json, propertie 형식으로 설정 정보를 작성했던 것을 yaml로 대체하는 추세다.
- properties로 쓰거나 yaml로 쓰거나는 자유임. 선택할 수 있다.
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

application.yml 설정파일
-----------------------------------

```yml
### 톰캣서버의 포트번호를 정의한다.
server:
  port: 80

spring:
### 애플리케이션 이름을 정의한다.
  application:
    name: store
### 데이터베이스 연결정보를 정의한다.
  datasource:
    driver-class-name: oracle.jdbc.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:xe
    username: hta
    password: zxcv1234
### spring mvc 설정
  mvc:            # JSP 뷰페이지 경로 및 확장자를 정의한다.
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp

### mybatis 설정
mybatis:
  mapper-locations: # 매퍼파일 저장경로를 정의한다.
    - mybatis/mappers/*.xml
  configuration:    # 기타 설정정보를 정의한다.
    jdbc-type-for-null: NULL
    log-impl: org.apache.ibatis.logging.log4j2.Log4j2Impl
```

pom.xml 설정파일
----------------------------------------------
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>store</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>store</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
        <!--
         객체의 값을 다른 객체에 복사해주는 modelmapper 의존성 추가
      	-->
      	<dependency>
	         <groupId>org.modelmapper</groupId>
	         <artifactId>modelmapper</artifactId>
	         <version>3.2.1</version>
      	</dependency>
		    <!--
         JSP 실행을 지원하는 내장형 톰캣 의존성 추가
      	-->
      	<dependency>
          	<groupId>org.apache.tomcat.embed</groupId>
          	<artifactId>tomcat-embed-jasper</artifactId>
      	</dependency>
      	<!--
         	서블릿 API 의존성 추가
      	-->
      	<dependency>
          <groupId>jakarta.servlet</groupId>
          <artifactId>jakarta.servlet-api</artifactId>
      	</dependency>
      
      	<!--
         JSTL 의존성 추가
      	-->
     	 <dependency>
          <groupId>org.glassfish.web</groupId>
          <artifactId>jakarta.servlet.jsp.jstl</artifactId>
      	</dependency>
      	<dependency>
          <groupId>jakarta.servlet.jsp.jstl</groupId>
          <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
      	</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>3.0.3</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc11</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<!--
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter-test</artifactId>
			<version>3.0.3</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```
