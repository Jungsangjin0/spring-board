package com.js.board.model.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.js.board.model.dto.BoardDTO;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{

	/*
	 * board List 조회 Repository method
	 * @param sqlSession    service에서 전달받은 sqlSessionTemplate 쿼리문 실행할 객체
	 * @return db에서 조회한 board List정보
	 * */
	@Override
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("board.selectList");
	}

	/*
	 * board 조회 Repository method
	 * @param number  board 번호
	 * @param sqlSession   service에서 전달받은 sqlSessionTemplate 쿼리문 실행할 객체
	 * @return db에서 조회한 board 정보
	 * */
	@Override
	public BoardDTO selectById(int number, SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("board.selectById", number);
	}
	
}
