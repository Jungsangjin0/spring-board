package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.js.board.model.dto.BoardDTO;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{

	@Override
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("board.selectList");
	}
	
}
