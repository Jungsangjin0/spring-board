package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.js.board.model.dto.BoardDTO;

public interface BoardRepository {

	/*select Board*/
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession);
	
}
