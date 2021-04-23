<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- root 경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">

<style>
* {
	margin: 0 auto
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
</style>
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<div class="inner">
			<a href="#">
				<h2>메인화면</h2>

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
	<c:forEach var="bv" items="${bv}" varStatus="t">
		<table border="1">

			<tr>
				<td>${bv.contentID}</td>
				<td>${bv.title}</td>
				<td>${bv.userID}</td>
				<td>${bv.content}</td>
				<td>${bv.date}</td>
			</tr>

		</table>
		<!-- 	<br> -->
		<!-- 	<br> -->
		<a href="boardList">목록</a>

		<c:if test="${bv.userID == sessionScope.userID}">
			<a href="boardUpdate?contentID=${bv.contentID}">수정</a>
			<a href="boardDelete?contentID=${bv.contentID}">삭제</a>
		</c:if>
	</c:forEach>
</body>
</html>