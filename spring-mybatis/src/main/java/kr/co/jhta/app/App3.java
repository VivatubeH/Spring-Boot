package kr.co.jhta.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.mapper.BoardMapper;
import kr.co.jhta.vo.Board;

public class App3 {

	public static void main(String[] args) {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/context.xml");
		
		BoardMapper boardMapper = ctx.getBean(BoardMapper.class);
		
//		List<Board> boardList1 
//			= boardMapper.searchBoards1("writer", "자바");
		
//		String title = null;
//		int cnt = 10;
//		List<String> tags = List.of("자바", "java", "스프링");
//		List<Board> boardList = boardMapper.searchBoard(title, cnt, tags);
//		System.out.println(boardList);
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("opt", "제목");
//		map.put("keyword", "공부");
//		map.put("begin", 1);
//		map.put("end", 10);
//		map.put("sort", "리뷰순");
//		
//		List<Board> boardList = boardMapper.searchBoards2(map);
		
		Map<String, Object> map = boardMapper.getBoardByNo2(1);
		System.out.println(map);
	}
}
