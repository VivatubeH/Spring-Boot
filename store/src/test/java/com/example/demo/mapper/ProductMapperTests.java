package com.example.demo.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductMapperTests {

	@Autowired
	ProductMapper productMapper;
	
	@Test
	@DisplayName("ProductMapper인터페이스 구현체를 잘 주입받았는지 테스트")
	public void testBean()	{
		Assertions.assertNotNull(productMapper);
	}
	
	@Test
	@DisplayName("조회조건에 맞게 데이터 갯수를 잘 조회하는지 테스트")
	public void testGetTotalRwos() {
		Map<String,Object> condition = new HashMap<>();
		condition.put("opt", "name");
		condition.put("value", "맥북ㄴㄴ");
		
		int totalRwos =productMapper.getTotalRows(condition);
		assertThat(totalRwos).isGreaterThan(0);

		
		condition.put("opt", "minPrice");
		condition.put("value",1000000);
		totalRwos = productMapper.getTotalRows(condition);
	}
}

