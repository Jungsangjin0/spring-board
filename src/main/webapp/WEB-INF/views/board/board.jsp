<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- taglib 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징 게시판</title>
<style type="text/css">
.table>tbody tr:hover {
	background: rgb(200, 200, 200);
	cursor: pointer;
}

.table tr {
	border-bottom: 1px solid #999;
}

.table {
	padding: 30px;
	margin: 0px auto;
	font-size: 20px;
	font-weight: normal;
}

.table thead {
	border-top: 2px solid #666;
}
</style>

</head>
<body>
	<jsp:include page="../common/sidebar.jsp" />
	<div class="content">
		<div style="padding-top: 100px;">
			<div style="margin-bottom : 13px; padding-left : 161px;">
				<button type="button" id="all-button">전체글</button>
			</div>
			<table class="table"
				style="border-collapse: collapse; width: 1200px; text-align: center;">
				<colgroup>
					<col width="15%">
					<col width="20%">
					<col width="40%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					<tr>
				</thead>
				<tbody class="board-tbody">
					<!-- forEach로 변경된 body부분 -->
					<c:forEach items="${requestScope.list}" var="board">
						<tr>
							<td>${board.board_id}</td>
							<td>${board.board_title}</td>
							<td>${board.board_writer}</td>
							<td>${board.board_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 글쓰기 버튼 -->
			<div style="text-align: right; padding-right: 10%; margin-top: 20px;">
				<button id="write">글쓰기</button>
			</div>

			<!-- 페이징 -->
			<div style="text-align: center; margin-top: 30px;">
				<c:choose>
					<c:when test="${empty requestScope.pageInfo.keyword and 
					                empty requestScope.pageInfo.type}">             <!-- 1 -->

						<button id="startPage"><<</button>    <!-- 2 -->

						<c:if test="${requestScope.pageInfo.pageNo <= 1}">    <!-- 3 -->
							<button disabled><</button>
						</c:if>

						<c:if test="${requestScope.pageInfo.pageNo > 1}">    <!-- 4 -->
							<button id="prevPage"><</button>
						</c:if>

						<c:forEach var="p" begin="${requestScope.pageInfo.startPage}" 
							end="${requestScope.pageInfo.endPage}" step="1">               <!-- 5 -->

							<c:if test="${requestScope.pageInfo.pageNo eq p}">       <!-- 6 -->
								<button disabled>
									<c:out value="${p}"></c:out>
								</button>
							</c:if>

							<c:if test="${requestScope.pageInfo.pageNo ne p}">
								<!-- 7 -->
								<button class="paging-button">
									<c:out value="${p}"></c:out>
								</button>
							</c:if>

						</c:forEach>

						<c:if test="${requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage}"> <!-- 8 -->
							<button disabled>></button>
						</c:if>

						<c:if test="${requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage}"> <!-- 9 -->
							<button id="nextPage">></button>
						</c:if>

						<button id="maxPage">>></button> <!-- 10 -->

					</c:when>

					<c:otherwise>										<!-- 검색시 페이징 -->
						<button id="searchStartPage"><<</button>             <!--  11 -->
						
						<c:if test="${requestScope.pageInfo.pageNo <= 1}">    <!--  12 -->
							<button disabled><</button>
						</c:if>
						
						<c:if test="${requestScope.pageInfo.pageNo > 1}">       <!-- 13 -->
							<button id="searchPrevPage"><</button>
						</c:if>

						<c:forEach var="p" begin="${requestScope.pageInfo.startPage}"
							end="${requestScope.pageInfo.endPage}" step="1">        <!--  14 -->
							
							<c:if test="${requestScope.pageInfo.pageNo eq p}">       <!-- 15 -->
								<button disabled>
									<c:out value="${p}"></c:out>
								</button>
							</c:if>
							
							<c:if test="${requestScope.pageInfo.pageNo ne p}">        <!-- 16 -->
								<button class="search-paging-button">
									<c:out value="${p}"></c:out>
								</button>
							</c:if>
							
						</c:forEach>

						<c:if
							test="${requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage}">  <!-- 17 -->
							<button disabled>></button>
						</c:if>
						
						<c:if
							test="${requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage}">   <!-- 18 -->
							<button id="searchNextPage">></button>
						</c:if>
						
						<button id="searchMaxPage">>></button>                 <!-- 19 -->
					</c:otherwise>
				</c:choose>
			</div>

			<!-- 검색 폼 -->
			<form id="searchForm">
				<div class="search-area" align="center">                         <!-- 20 -->
					<select id="searchCondition" name="type">                
						<option value="writer"<c:if test="${requestScope.pageInfo.type eq 'writer' }">selected</c:if>>작성자</option>
						<option value="title" <c:if test="${requestScope.pageInfo.type eq 'title' }">selected</c:if>>제목</option>
						<option value="text" <c:if test="${requestScope.pageInfo.type eq 'text' }">selected</c:if>>내용</option>
					</select>
					 <input type="search" id="searchValue" name="keyword" value="${requestScope.pageInfo.keyword }">
					<button type="button" id="search">검색하기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- detail 페이지 이동 js -->
	<script type="text/javascript">
	const PAGING_PATH = "${pageContext.servletContext.contextPath}/board";
	$(function(){
		
		/*list에서 게시물 클릭 시 해당 게시물 상세 페이지로 이동*/
		$(".board-tbody > tr").on("click", function(){
			let number = $(this).children().eq(0).text(); /*board number*/
			location.href = "${pageContext.servletContext.contextPath}/board/" + number;
		})
		
		// << 버튼 처음 페이지로 이동
		$("#startPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=1";
		})
		
		// < 버튼 이전 페이지로 이동
		$("#prevPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=${reqeustScope.pageInfo.pageNo - 1}";
		})													
		
		// > 이 후 페이지로 이동
		$("#nextPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=${requestScope.pageInfo.pageNo + 1}";
		})
		
		// >> 끝 페이지로 이동
		$("#maxPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=${requestScope.pageInfo.maxPage}";
		})
		
		// 페이징 버튼 클릭(1,2,3,4,5...) 해당 페이지로 이동
		$(".paging-button").on("click", function(){
			let pageNumber = $(this).text();
			location.href = PAGING_PATH +"?currentPage="+pageNumber;
		})
		
		//작성 버튼 클릭 시 페이지 이동
		$("#write").on("click", function(){
			
			location.href = "${pageContext.servletContext.contextPath}/write";
		})
		
		// 검색 버튼 클릭 시 
		$("#search").on("click", function(){
			
			let $type = $("#searchCondition").children(":selected");
			let $keyword = $("#searchValue").val();
			
			if($keyword == "") {
				alert("검색어를 입력해 주세요")
			}else{
				$("#searchForm").attr("action", PAGING_PATH);
				$("#searchForm").attr("method", "get");
				$("#searchForm").submit();
			}
		})
		
		
		// 검색 페이징 << 버튼 처음 페이지로 이동
		$("#searchStartPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=1&type=${requestScope.pageInfo.type}&keyword=${requestScope.pageInfo.keyword}";
		})
		
		// 검색 페이징 < 버튼 이전 페이지로 이동
		$("#searchPrevPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=${requestScope.pageInfo.pageNo - 1}&type=${requestScope.pageInfo.type}&keyword=${requestScope.pageInfo.keyword}";
		})
		
		//검색 페이징 페이지(1,2,3,4,5) 클릭 시 해당 페이지 이동
		$(".search-paging-button").on("click", function(){
			
			let pageNumber = $(this).text();
			location.href = PAGING_PATH + "?currentPage=" + pageNumber +"&type=${requestScope.pageInfo.type}&keyword=${requestScope.pageInfo.keyword}";
		})
		
		//검색 페이징 > 버튼 이 후 페이지로 이동
		$("#searchNextPage").on("click", function(){
			
			location.href= PAGING_PATH + "?currentPage=${requestScope.pageInfo.pageNo + 1}&type=${requestScope.pageInfo.type}&keyword=${requestScope.pageInfo.keyword}";
		})
		
		//검색 페이징 >> 버튼 끝 페이지로 이동
		$("#searchMaxPage").on("click", function(){
			
			location.href = PAGING_PATH + "?currentPage=${requestScope.pageInfo.maxPage}&type=${requestScope.pageInfo.type}&keyword=${requestScope.pageInfo.keyword}";
		})
		
		//전체페이지
		$("#all-button").on("click", function(){
			
			location.href = PAGING_PATH
		})
	})
</script>
</body>
</html>