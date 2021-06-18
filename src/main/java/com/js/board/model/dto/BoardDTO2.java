package com.js.board.model.dto;

import java.sql.Date;

/*
 * board 데이터를 가져올 때 사용할 Board class
 * */
public class BoardDTO2 {

	private long id; /*글 아이디(기본 키)*/
	private int category; /*글 카테고리(0이 기본 게시판)*/
	private String writer; /*글 작성자*/
	private String title; /*글 제목*/
	private String text; /*글 내용*/
	private Date date; /*글 작성일*/
	private int reply; /*참조 번호(댓글)*/
	private int level; /*글 레벨(0이 본문 1이 댓글)*/
	private char status; /*글 삭제 여부(Y가 삭제)*/
	
	public BoardDTO2() {}
	
	public BoardDTO2(long id, int category, String writer, String title, String text, Date date, int reply, int level,
			char status) {
		super();
		this.id = id;
		this.category = category;
		this.writer = writer;
		this.title = title;
		this.text = text;
		this.date = date;
		this.reply = reply;
		this.level = level;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoardDTO2 [id=" + id + ", category=" + category + ", writer=" + writer + ", title=" + title + ", text="
				+ text + ", date=" + date + ", reply=" + reply + ", level=" + level + ", status=" + status + "]";
	}
	
	
	
}
