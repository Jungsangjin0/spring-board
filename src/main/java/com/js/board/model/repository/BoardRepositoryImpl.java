package com.js.board.model.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{

	/*
	 * board List 조회 Repository method
	 * @param sqlSession    service에서 전달받은 sqlSessionTemplate 쿼리문 실행할 객체
	 * @param pageInfo 페이징 객체
	 * @return db에서 조회한 board List정보
	 * */
	@Override
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession, PageInfoDTO pageInfo) {
		
		return sqlSession.selectList("board.selectList", pageInfo);
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

	/*
	 * board update Repository method
	 * @param board 수정할 보드정보 객체
	 * @param sqlSession 쿼리문 실행할 객체
	 * */
	@Override
	public int updateById(BoardDTO board, SqlSessionTemplate sqlSession) {
		
		
		return sqlSession.update("board.updateById", board);
	}
	
	/*count board list Repository
	 * @param sqlSession 쿼리문 실행할 객체
	 * @return 보드리스트 갯수
	 * */
	@Override
	public int totalCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("board.totalCount");
	}

	/*
	 * board sequence nextval 조회
	 * param sqlSession 쿼리문 실행할 객체
	 * return 시퀀스 nextval 값
	 * */
	@Override
	public int selectNextVal(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("board.boardNextval");
	}

	/*
	 * board 정보 db에 입력(insert)
	 * param sqlSession 쿼리문 실행할 객체
	 * param board 입력한 board정보
	 * */
	@Override
	public void insertBoard(SqlSessionTemplate sqlSession, BoardDTO board) {
		sqlSession.insert("board.insertBoard", board);
	}
	
}
