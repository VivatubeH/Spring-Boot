package kr.co.jhta.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.mapper.BoardMapper;
import kr.co.jhta.vo.Board;

public class BoardApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("context/context.xml");
		
		BoardMapper boardMapper = ctx.getBean(BoardMapper.class);
		
		Board board = boardMapper.getBoardByNo(1);
		System.out.println(board);
	}
}
