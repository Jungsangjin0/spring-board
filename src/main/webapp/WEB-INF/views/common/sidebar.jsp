<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
body{
    margin : 0;
    padding : 0;
}

.sidebar{
    position: fixed;
    left : 0;
    width : 180px;
    height : 100%;
    background: #5530EB;

}
.sidebar ul {
    margin: 0;
    padding: 0;
    list-style:  none;
}
.sidebar ul li a{

    text-decoration: none;
}
.sub-sidebar{
    
    position: fixed;
    left : 180px;
    width : 200px;
    height : 100%;
    background: #FFFFFF;
    
  
}
.sidebar header{
    font-size : 22px;
    color: white;
    text-align: center;
    line-height: 70px;
    user-select: none;
    box-sizing: border-box;
    border-bottom: 1px solid black;
    
}
.sidebar ul {
    height: 800px;
}

.sidebar ul a {
    display: block;
    height: 100%;
    width: 100%;
    line-height:10px;
    font-size: 14px;
    color: white;
    padding-left: 10px;
    transition: .3s;
}
.sidebar ul a img {
    margin-right: 16px;
}
.sidebar ul img{
    width: 20px;
}
.sidebar header img {
    width:  150px;
    margin-top: 30px;
}
.sidebar ul p {
   display: inline; 
}
.sidebar ul li{
    margin-top: 10px;
}
.sidebar .group {
    bottom: 30px;
    border: 1px solid white; 
    width: 70%; 
    font-size:14px; 
    left: 10px; 
    color: white;
    height: 40px;
    line-height: 40px; 
    padding-left:30px;
    margin-left: 8px;
    border-radius: 7px;

}
.sidebar p img {
    width: 20px;
}
.sidebar li  a {
    display: block;
    line-height: 40px;
}
.sidebar ul li {
    width: 150px;
    height: 40px;
    margin-left: 10px;
}
.sidebar li a:hover{
    background : rgba(255, 255, 255, 0.3);
}
.top-menu {
    width:calc(100% - 380px); 
    height: 70px; 
    background: #EEF1F6; 
    position: fixed; 
    left: 380px;
    z-index: 999;
}
.top-menu-icon {
    float:right;
    height: 70px; 
    line-height: 63px;
}
.search-place{
    display: inline-block;
    margin-right: 30px; 
    margin-bottom:20px;
}
.search-place > input:focus{
    outline: none;
}
.search-place > input:hover {
cursor: pointer;
}
.search-place > input[type=text] {
    height: 25px;
    width: 150px;
    line-height: 25px;
}
.search-place > input[type=button] {
    border: none;
    height:25px;
}
.top-alarm {
    width: 20px; 
    margin-right:30px; 
    vertical-align: middle;
}
.user-icon {
    width: 25px; 
    margin-right:50px; 
    vertical-align: middle;
}
.content {
    /* background:yellow; */
    width:calc(100% - 380px);  
    left: 380px;
    height: 1000px;
    position: relative;
    top:75px;
}
.content-body{
    background: white; 
    width: 100%;
    margin: 0 auto; 
    height: 100%;
}

.menuu {
    width: 90px;
    height: 150px; 
    background: rgb(247, 247, 247);
     position: absolute; 
     top:55px; 
     right: 48px; 
     box-shadow:0px 1px 7px rgb(0,0,0,0.2); 
     display: none;
}
.menuu ul li {
    font-size: 13px;
    height: 30px;
    text-align: center;
    line-height: 30px;
    margin: 0;
    padding: 0;
    list-style:  none;
}
.menuu ul {
    margin-top: 15px;
    padding : 0;
}

.menuu ul li:hover {
    background : rgba(172, 167, 167, 0.3);
}
.menuu ul li a {
    text-decoration: none;
}
.menuu ul li a span {
    color:  black;
}
.menu-e {
    display: block;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/side.css">
<body>
    <div class="sidebar">
        <header></header>
         <ul>
            <li><a href="${pageContext.servletContext.contextPath }">
                    <p>홈</p>
                </a></li>
            <li><a href="${pageContext.servletContext.contextPath }/board?currentPage=1">
                    <p>페이징 게시판</p>
                </a></li>
            <li><a href="#"><p>더보기 게시판</p>
                </a></li>
            <li><a href="#"><p>사진 게시판</p>
                </a></li>
            <li><a href="#"><p>엑셀게시판</p>
                </a></li>
            <li><a href="#"><p>이메일</p>
                </a></li>
            <li><a href="#"><p>메신저</p>
                </a></li>
            <li><a href="#"><p>근태관리</p>
                </a></li>
        </ul>
    </div>

    <div class="top-menu">
        <div class="top-menu-icon">
            <div class="search-place">
                <input type="search" placeholder="통합검색">
                <input type="button" value="검색">
            </div>
            <a href="#"><img src="${pageContext.request.contextPath }/resources/images/sidebarLogo/상단 우측 알람 표시.png" class="top-alarm"></a>
            <a href="#"><img src="" alt=""><img src="${pageContext.request.contextPath }/resources/images/sidebarLogo/상단 우측 검색바.png" class="user-icon"></a>
            <div class="menuu">
                <ul>
                    <li><a href="#"><span>기본정보</span></a></li>
                    <li><a href="#"><span>알림설정</span></a></li>
                    <li><a href="#"><span>관리자 페이지</span></a></li>
                    <li><a href="#"><span>로그아웃</span></a></li>
                </ul>
            </div>

        </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(".user-icon").click(function() {
       $(".menuu").toggleClass("menu-e");
    })
</script>
