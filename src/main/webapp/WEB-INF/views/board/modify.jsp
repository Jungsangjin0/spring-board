<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
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

</style>
<body>
	<jsp:include page="../common/sidebar.jsp" />
	<div class="content">
		<div
			style="padding-top: 50px; text-align: center; width: 700px; border: 0px;margin-left : 350px;">
			<div style="border-bottom : 3px solid #999;">
				<span style="font-size :40px; font-weight: bold;">수정하기</span>
			</div>
			
			<form method="POST" action="<c:out value='${pageContext.servletContext.contextPath }'/>/modify">
				<ul class="board-ul">
				
				<!-- hidden으로 추가한 id 값 -->
				 <li>
				 	<input type="hidden" id="board-id" name="board_id" value="<c:out value='${requestScope.board.board_id }'/>">
				 </li> 
					<li>
						<span class="ul-span">제목 : </span>
						<input type="text" placeholder="제목을 입력해 주세요" id="title" name="board_title" value='<c:out value="${requestScope.board.board_title}"/>'></li>
					<li style="margin-top : 30px;">
						<textarea rows="25" cols="88" id="content" name="board_text"><c:out value="${requestScope.board.board_text }"/></textarea>
					</li>
					<li>
						<div style="text-align: right; padding-right:28px; margin-top : 10px;">
							<button type="submit" style="width:70px;" id="submit">수정하기</button>
							<button id="back" type="button">뒤로가기</button>
						</div>
					</li> 
				</ul>
			</form>
		</div>
	</div>
</body>
</html>


