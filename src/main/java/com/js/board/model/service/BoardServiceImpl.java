package com.js.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;
import com.js.board.model.repository.BoardRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public BoardServiceImpl(BoardRepository boardRepository, SqlSessionTemplate sqlSession) {
		this.boardRepository = boardRepository;
		this.sqlSession = sqlSession;
	}
	
	/*board list를 조회할 때 사용하는 service method
	 * @param pageInfo 페이징 객체
	 * @return board List 정보 
	 * */
	@Override
	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo) {
		
		return boardRepository.selectBoardList(sqlSession, pageInfo);
	}

	/*
	 * board를 조회할 때 사용하는 service method
	 * @param number 게시판 번호
	 * @return board 정보
	 * */
	@Override
	public BoardDTO selectById(int number) {
		
		return boardRepository.selectById(number, sqlSession);
	}

	/*
	 * board를 수정할 때 사용하는 service method
	 * @param board 게시물 수정정보가 담긴 객체
	 * @return 
	 * */
	@Override
	public void updateById(BoardDTO board) {
		
		boardRepository.updateById(board, sqlSession);
	}

	/*
	 *count board list method
	 *@return count board list  
	 * */
	@Override
	public int totalCount() {
		
		return boardRepository.totalCount(sqlSession);
	}

}
