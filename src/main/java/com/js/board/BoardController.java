package com.js.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value ="/board", method = RequestMethod.GET)
	public String board() {
		
		return "board/board";
	}
	
	@RequestMapping(value = "/board/{number}", method = RequestMethod.GET)
	public String detailBoard(@PathVariable int number, Model model) {
		model.addAttribute("number", number);
		return "board/detail";
	}
}
