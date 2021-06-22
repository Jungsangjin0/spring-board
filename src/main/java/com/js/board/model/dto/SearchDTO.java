package com.js.board.model.dto;

public class SearchDTO extends PageInfoDTO implements java.io.Serializable{
	
	private String type; /*검색 타입*/
	private String keyword; /*검색어*/
	
	public SearchDTO() {}
	
	public SearchDTO(String type, String keyword) {
		this.type = type;
		this.keyword = keyword;
	}

	public SearchDTO(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage, int endPage,
			int startRow, int endRow) {
		
		super(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchDTO [type=" + type + ", keyword=" + keyword + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
