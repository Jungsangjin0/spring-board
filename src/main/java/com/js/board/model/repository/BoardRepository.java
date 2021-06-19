package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.js.board.model.dto.BoardDTO;

public interface BoardRepository {

	/*select Board List*/
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession);
	
	/*select Board*/
	public BoardDTO selectById(int number, SqlSessionTemplate sqlSession);

	/*update Board*/
	public int updateById(BoardDTO board, SqlSessionTemplate sqlSession);
	
}
