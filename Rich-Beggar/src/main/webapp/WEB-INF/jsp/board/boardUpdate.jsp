<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- 화면 최적화 -->
<meta name="viewport" content="width-device-width" , initial-scale="1">
<!-- 루트 폴더에 부트스트랩을 참조하는 링크 -->
<link rel="stylesheet" href="css/bootstrap.css">
<title>글쓰기 게시판</title>

</head>
<style>
* {
	margin: 0 auto;
	padding: 0;
}

hr {
	border: none;
	clear: both;
}

a {
	text-decoration: none;
}

.inner {
	width: 1200px;
}

li ul {
	list-style-type: none;
}

td {
	height: 45px;
}

tbody>tr {
	border-bottom: 0.01px solid black;
}

.inner {
	width: 1200px;
	max-width: 1200px;
	margin: auto;
}

.header {
	background-color: lightblue;
	height: 50px;
}

.header .inner h2 {
	color: white;
	float: left;
	padding-top: 10px;
}

.header .inner h2:hover {
	color: blue;
}

.header_line {
	display: block;
	float: right;
	padding-top: 10px;
}

.header_line a {
	color: white;
}

.header_line a:hover {
	color: black;
}

.container {
	margin-top: 40px;
}

footer {
	color: white;
	background-color: black;
	width: 100%;
	height: 130px;
	margin-top: 20px;
}

.cl {
	padding-top: 50px;
	float: right;
	margin-right: 20px;
}

.table {
	width: 1200px;
}

.button {
	text-align: center;
	float: right
}

.txt_line {
	width: 100px;
	height: 20px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
</head>
<body>

	<header class="header">
		<div class="inner">
			<a href="index">
				<h2>Rich&Beggar</h2>

			</a>
			<div class="header_line">
				<c:if test="${not empty sessionScope.userID}">
         	
        	${sessionScope.userID}님 반갑습니다
                <a href="logout">로그아웃 </a>

				</c:if>

				<c:if test="${empty sessionScope.userID}">
					<div>
						<a href="join">회원가입 </a> <span style="color: white;">|</span> <a
							href="login">로그인 </a>
					</div>
				</c:if>
			</div>
		</div>
	</header>

	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>



	<nav>
		<div class="inner">
			<h3 style="text-align: center; padding-left: 20px;">글쓰기</h3>
		</div>
	</nav>


	<!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container inner">
		<div class="row">
			<form method="post">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="hidden" value="${sessionScope.userID}"
								name="userID"> <input type="text" class="form-control"
								placeholder="글 제목" name="title" maxlength="50"
								style="width: 1200px; height: 30px"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 내용" name="content" maxlength="2048"
								style="height: 500px; width: 1200px;"></input></td>
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼  -->
				<input type="submit" class="write_btn" style="float: right;"
					value="글쓰기">
			</form>
		</div>
	</div>
	<hr>
	<footer>
		<div class="cl">
			<p>만든이 : 정민재</p>
			<p>문의:010-abcd-efgh</p>
		</div>
	</footer>
	<!-- 게시판 글쓰기 양식 영역 끝 -->

	<!-- 부트스트랩 참조 영역 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html>