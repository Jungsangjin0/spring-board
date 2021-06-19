<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.board.board_title }</title>
<style>
table.table2 {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	margin: 20px 10px;
}

table.table2 tr {
	width: 50px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.table2 td {
	width: 100px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
.board-ul {
	list-style : none;
	padding-left : 0px;
}
.board-ul li {
	text-align : center;
	
}
.board-ul li input {
	width : 80%;
	height : 27px;
	
}
.board-ul li input:focus {
	outline : none;
}
.ul-span {
	margin-right :10px; 
	font-size : 20px; 
	font-weight: bold; 
	line-height:40px;
}
.board-ul li textarea:focus {
	outline : none;
}
.board-ul li textarea {
	resize: none;
}

.form-wrap{
	padding-top: 50px;
	text-align: center; 
	width: 700px; 
	border: 0px;
	margin-left : 350px;
}
.top-title{
	border-bottom : 3px solid #999;
}
.top-span {
	font-size :40px; 
	font-weight: bold;
}
.write-div {
	display: inline-block; 
	margin-left: 10px;
}
.date-div{
	display: inline-block; 
	margin-left: 37px;
}
.cnt-div{
	display: inline-block; 
	margin-left:350px;
}

</style>
<body>
	<jsp:include page="../common/sidebar.jsp" />
	<div class="content">
		<div class="form-wrap">
			<div class="top-title">
				<span class="top-span">${requestScope.board.board_id }번 게시물</span>
			</div>
			<form method="POST" action="write">
				<ul class="board-ul">
					<li style="text-align: left; margin-top : 20px;">
						<span class="ul-span">제목 : </span>
						<span class="ul-span board-content">${requestScope.board.board_title }</span>
					</li>
					<li style="text-align: left; margin-top: 30px;">
						<div class="write-div">
							<span>작성자 : </span>
							<span class="board-write">${requestScope.board.board_writer }</span>
						</div>
						<div class="date-div">
							<span>작성일 : </span>
							<span class="edit-date">${requestScope.board.board_date }</span>
						</div>
						<div class="cnt-div">
							<span>조회수</span>
							<span>0</span>
						</div>
					</li>
					<li style="margin-top :40px; border-top : 1px solid #999;">
						<div style="height :200px;">
							<p style="text-align: center;">${requestScope.board.board_text }</p>
						</div>
					</li>
					<li style="border-top : 1px solid #999;">
						<div style="text-align: right;  margin-top : 30px;">
							<button id="modify" type="button">수정하기</button>
							<button id="back" type="button">뒤로가기</button>
						</div>
					</li> 
				</ul>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#back").on("click", function(){
				//location.href = "${pageContext.servletContext.contextPath}/board";
				history.back();
			})
			
		})
	</script>
</body>
</html>


