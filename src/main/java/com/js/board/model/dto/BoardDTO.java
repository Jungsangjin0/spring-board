package com.js.board.model.dto;

import java.sql.Date;

/*
 * board 데이터를 가져올 때 사용할 Board class
 * */
public class BoardDTO {

	private long board_id; /*글 아이디(기본 키)*/
	private int board_category; /*글 카테고리(0이 기본 게시판)*/
	private String board_writer; /*글 작성자*/
	private String board_title; /*글 제목*/
	private String board_text; /*글 내용*/
	private Date board_date; /*글 작성일*/
	private int board_reply; /*참조 번호(댓글)*/
	private int board_level; /*글 레벨(0이 본문 1이 댓글)*/
	private char board_status; /*글 삭제 여부(Y가 삭제)*/
	
	public BoardDTO() {}
	
	public BoardDTO(long board_id, int board_category, String board_writer, String board_title, String board_text,
			Date board_date, int board_reply, int board_level, char board_status) {
		super();
		this.board_id = board_id;
		this.board_category = board_category;
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_text = board_text;
		this.board_date = board_date;
		this.board_reply = board_reply;
		this.board_level = board_level;
		this.board_status = board_status;
	}

	public long getBoard_id() {
		return board_id;
	}

	public void setBoard_id(long board_id) {
		this.board_id = board_id;
	}

	public int getBoard_category() {
		return board_category;
	}

	public void setBoard_category(int board_category) {
		this.board_category = board_category;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_text() {
		return board_text;
	}

	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public int getBoard_reply() {
		return board_reply;
	}

	public void setBoard_reply(int board_reply) {
		this.board_reply = board_reply;
	}

	public int getBoard_level() {
		return board_level;
	}

	public void setBoard_level(int board_level) {
		this.board_level = board_level;
	}

	public char getBoard_status() {
		return board_status;
	}

	public void setBoard_status(char board_status) {
		this.board_status = board_status;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_id=" + board_id + ", board_category=" + board_category + ", board_writer="
				+ board_writer + ", board_title=" + board_title + ", board_text=" + board_text + ", board_date="
				+ board_date + ", board_reply=" + board_reply + ", board_level=" + board_level + ", board_status="
				+ board_status + "]";
	}
	
	
	
	
}
