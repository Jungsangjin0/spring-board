package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;
import com.js.board.model.dto.SearchDTO;

public interface BoardRepository {

	/*select Board List*/
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession, PageInfoDTO search);
	
	/*select Board*/
	public BoardDTO selectById(int number, SqlSessionTemplate sqlSession);

	/*update Board*/
	public int updateById(BoardDTO board, SqlSessionTemplate sqlSession);

	/*count board*/
	public int totalCount(SqlSessionTemplate sqlSession, SearchDTO search);

	/*select board nextVal*/
	public int selectNextVal(SqlSessionTemplate sqlSession);

	/*insert board*/
	public void insertBoard(SqlSessionTemplate sqlSession, BoardDTO board);

	/*search count*/
	public int keywordCount(SqlSessionTemplate sqlSession, SearchDTO search);

	/*delete board*/
	public void deleteBoard(SqlSessionTemplate sqlSession, int boardId);
	
}
