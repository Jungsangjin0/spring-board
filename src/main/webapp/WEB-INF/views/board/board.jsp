<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- taglib 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징 게시판</title>
<style type="text/css">

	.table > tbody tr:hover {
	 background : rgb(200, 200, 200);
	 cursor: pointer;
	}
	
	.table tr {
		border-bottom : 1px solid #999;
	}
	.table {
		padding : 30px;
		margin : 0px auto;
		font-size : 20px;
		font-weight: normal;
	}
	.table thead {
		border-top : 2px solid #666;
	}
</style>

</head>
<body>
	<jsp:include page="../common/sidebar.jsp"/>
	<div class="content">
		<div>
			<table class="table" style="border-collapse: collapse;width:1200px;text-align: center;">
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
		</div>
	</div>
	
<!-- detail 페이지 이동 js -->
<script type="text/javascript">
	$(function(){
		
		$(".board-tbody > tr").on("click", function(){
			let number = $(this).children().eq(0).text(); /*board number*/
			location.href = "${pageContext.servletContext.contextPath}/board/" + number;
		})
	})
</script>
</body>
</html>