<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
* {
	margin: 0 auto;
	padding: 0;
	list-style-type: none;
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
	height: 117px;
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
	<div class="container">
		<div class="inner">
			<table class="table"
				style="text-align: center; border: 1px solid #dddddd; width: 1200px">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">글쓴이</th>
						<th style="background-color: #eeeeee; text-align: center;">내용</th>
						<th style="background-color: #eeeeee; text-align: center;">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="listView" items="${lv}" varStatus="t">
						<tr class="txt_line">
							<td style="width: 100px">${listView.contentID}</td>
							<td style="width: 300px">
								<div class="txt_line">
									<a href="boardView?contentID=${listView.contentID}">${listView.title}</a>
								</div>
							</td>
							<td style="width: 200px">${listView.userID}</td>
							<td><div class="txt_line">${listView.content}</div></td>
							<td style="width: 200px">${listView.date}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>


		<div class="inner" style=text-align:center>
		<div>
			<c:if test="${pageNumber != 1}">
				<a href="boardList?pageNumber=${pageNumber-1}"> 이전 </a>
			</c:if>

			<ul>
				<c:forEach var="i" begin="1" end="5">
					<c:if test="${(i)<= count/10 + 1}">
						<li><a href="boardList?pageNumber=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
			</ul>

			<c:if test="${count > pageNumber * 10}">
				<a href="boardList?pageNumber=${pageNumber+1}" class="inner">다음</a>
			</c:if>

			<!-- 검색 form -->
			<div class="search_form">
				<form action="boardList">
					<select name="f">
						<option ${(param.f=="Title" )?"selected":""} value="Title">제목</option>
						<option ${(param.f=="userID" )?"selected":""} value="userID">글쓴이</option>
					</select> <input type="text" name="q" value="${param.q}" /> <input
						type="submit" value="Search" />
				</form>
			</div>
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script>
				jQuery('select').change(function() {
					let state = jQuery('select option:selected').val();
					console.log(state);
					if (state == 'Title') {
						jQuery('.searchOption').show();

					} else {
						jQuery('.searchOption').hide();
					}
				}).trigger("change");

				function hash() {
					const val = document.querySelector('.tagval');
					alert(val.value);

				}
			</script>
			<!-- 글쓰기 버튼 -->
			<c:if test="${not empty sessionScope.userID}">

				<a href="boardWrite" class="write_ll">글쓰기</a>

			</c:if>

		</div>

		<hr>
		<footer>
			<div class="cl">
				<p>만든이 : 정민재</p>
				<p>문의:010-abcd-efgh</p>
			</div>
		</footer>
	</div>
</body>
</html>
