package com.js.board.paging;

import com.js.board.model.dto.PageInfoDTO;
import com.js.board.model.dto.SearchDTO;

public class Pagenation {

	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, PageInfoDTO search) {
		
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		int limit = 10;
		int buttonAmount = 10;
		
		/*총 페이지 수 계산
		 * ex) 123개의 게시물 한 페이지당 10개씩 보여지는 경우 
		 * 짜투리목록이 1페이지 추가로 필요
		 * 1페이지 추가 하기 위해 + 0.9
		 * 뒤에 더하기는 가중치 만큼 더하는 것 10개씩일 때는 하나의 게시물의 가중치는 10% 이니까 0.9
		 * 5개 일때는 게시물 한 개의 가중치는 20% 이니까 0.8
		 * 20개 일때는 게시물 한 개의 가중치는 5% 이니까 0.95
		 * */
//		maxPage = (int) (((double) totalCount / limit) + 0.9);
		maxPage = (int) Math.ceil((double) totalCount / limit); //올림처리
		
		/*현재 페이지에 보여줄 시작페이지 수
		 * 10개씩 보여지게 할 경우
		 * 1, 11, 21, 31...
		 * 5개 씩일 경우
		 * 1, 6, 11, 16,...
		 * 뒤에 덧셈은 버튼 가중치에 대한 덧셈
		 * 앞자리 구해서 + 1
		 * 배수의 + 1
		 * */
//		startPage = (((int) ((double) pageNo / buttonAmount + 0.9)) - 1) * buttonAmount + 1;
		startPage = (int)(Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;
		
		/*
		 * 목록 아래 쪽에 보여질 마지막 페이지 수
		 * */
		endPage = startPage + buttonAmount - 1;
		
		/*maxPage가 더 작은 경우 마지막 페이지가 maxPage가 된다.*/
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		/*마지막 페이지는 0이 될수 없기 때문에 게시물이 아무것도 존재하지 않으면 max 페이지와 endPage를 1로 바꿔준다.*/
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		
		/*조회를 시작할 행의 번호 수와 마지막 행 번호를 계산한다.*/
		startRow = (pageNo - 1) * limit + 1;
		endRow = startRow + limit - 1;
		
		search.setPageNo(pageNo);
		search.setTotalCount(totalCount);
		search.setLimit(limit);
		search.setButtonAmount(buttonAmount);
		search.setMaxPage(maxPage);
		search.setStartPage(startPage);
		search.setEndPage(endPage);
		search.setStartRow(startRow);
		search.setEndRow(endRow);
		
		return search; 
	}
}
