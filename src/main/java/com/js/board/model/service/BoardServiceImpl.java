package com.js.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.board.model.dto.BoardDTO;
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
	
	@Override
	public List<BoardDTO> selectBoardList() {
		
		
		return boardRepository.selectBoardList(sqlSession);
	}

}
