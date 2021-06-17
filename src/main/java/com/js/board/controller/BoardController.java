package com.js.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value ="/board", method = RequestMethod.GET)
	public String board(Model model) {
		
		List<BoardDTO> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		log.info("list : {}", list);
		
		return "board/board";
	}
	
	@RequestMapping(value = "/board/{number}", method = RequestMethod.GET)
	public String detailBoard(@PathVariable int number, Model model) {
		model.addAttribute("number", number);
		return "board/detail";
	}
}
