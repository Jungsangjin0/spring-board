<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>

</head>
<body>
	<jsp:include page="../common/sidebar.jsp"/>
	<div class="content">
		<div style="align-items: center;">
			<table class="table" style="border-collapse: collapse;">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					<tr>
				</thead>
				<tbody class="board-tbody">
				<!-- foreach -->
					<tr>
						<td>1</td>
						<td>이제곧바뀐다..</td>
						<td>정상진</td>
						<td style="padding-left: 20px;">2021.06.15</td>
					</tr>	
					<tr>
						<td>2</td>
						<td>이제곧바뀐다..</td>
						<td>정상진</td>
						<td style="padding-left: 20px;">2021.06.15</td>
					</tr>
				<!-- /foreach -->		
				</tbody>
			</table>
		</div>
	</div>
	
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