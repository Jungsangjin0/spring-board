package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;

public interface BoardRepository {

	/*select Board List*/
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession, PageInfoDTO pageInfo);
	
	/*select Board*/
	public BoardDTO selectById(int number, SqlSessionTemplate sqlSession);

	/*update Board*/
	public int updateById(BoardDTO board, SqlSessionTemplate sqlSession);

	/*count board*/
	public int totalCount(SqlSessionTemplate sqlSession);
	
}
