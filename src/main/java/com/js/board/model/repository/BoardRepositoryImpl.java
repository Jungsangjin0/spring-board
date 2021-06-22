package com.js.board.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;
import com.js.board.model.dto.SearchDTO;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{

	/*
	 * board List 조회 Repository method
	 * @param sqlSession    service에서 전달받은 sqlSessionTemplate 쿼리문 실행할 객체
	 * @param pageInfo 페이징 객체
	 * @return db에서 조회한 board List정보
	 * */
	@Override
	public List<BoardDTO> selectBoardList(SqlSessionTemplate sqlSession, PageInfoDTO search) {
		
		return sqlSession.selectList("board.selectList", search);
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
	public int totalCount(SqlSessionTemplate sqlSession, SearchDTO search) {
		
		return sqlSession.selectOne("board.totalCount", search);
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
	 * @param sqlSession 쿼리문 실행할 객체
	 * @param board 입력한 board정보
	 * */
	@Override
	public void insertBoard(SqlSessionTemplate sqlSession, BoardDTO board) {
		sqlSession.insert("board.insertBoard", board);
	}

	/*
	 * 조건 검색 게시물 count 
	 * @param sqlSession 쿼리문 실행할 객체
	 * @param search 검색 정보가 담겨있는 객체
	 * */
	@Override
	public int keywordCount(SqlSessionTemplate sqlSession, SearchDTO search) {
		
		return sqlSession.selectOne("board.keywordCount", search);
	}

	/*
	 * 게시물 삭제
	 * @param sqlSession 쿼리문 실행할 객체
	 * @param boardId 게시물 번호
	 * */
	@Override
	public void deleteBoard(SqlSessionTemplate sqlSession, int boardId) {
		
		sqlSession.delete("board.deleteBoard", boardId);
	}
	
}
