package com.js.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value ="/board", method = RequestMethod.GET)
	public String board(Model model) {
		
		List<BoardDTO> list = boardService.selectBoardList();
		
		return "board/board";
	}
	
	@RequestMapping(value = "/board/{number}", method = RequestMethod.GET)
	public String detailBoard(@PathVariable int number, Model model) {
		model.addAttribute("number", number);
		return "board/detail";
	}
}
