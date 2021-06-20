package com.js.board.model.service;

import java.util.List;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.PageInfoDTO;

public interface BoardService {
	
	/*select board list*/
	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo);

	/*select board*/
	public BoardDTO selectById(int number);

	/*update board*/
	public void updateById(BoardDTO board);

	/*count board*/
	public int totalCount();

}
