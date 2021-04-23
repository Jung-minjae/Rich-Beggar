<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	width: 100%;
}

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
}

hr {
	border: none;
	margin-bottom: 40px;
	clear: both;
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

.inner .menu .main {
	margin-top: 20px;
	height: 100px;
}

.inner .menu .main>li {
	float: left;
	width: calc(100%/ 4);
	text-align: center;
	font-size: large;
}

.inner .menu .main .sub {
	position: relative;
	display: none;
}

.inner .menu .main .sub>li {
	font-size: medium;
	margin: 5px 0;
}

.inner .menu .main>li:hover>a {
	background-color: wheat;
}

.inner .menu .main>li:hover .sub {
	display: block;
}

.dropmenu {
	border: none;
	border: 0px;
	padding: 0px;
	font: "sans-serif";
	font-size: 18px;
	display: flex;
	justify-content: space-around;
	align-items: center;
	background-color: lightcoral;
}

.dropmenu>ul {
	text-align: center;
	background-color: lightcoral;
	height: 100px;
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: space-around;
	align-items: center;
	padding: 1px 1px;
}

.dropmenu>ul>li {
	float: left;
	padding: 0px;
	position: relative;
}

.dropmenu li a {
	color: #fff;
	display: block;
	line-height: 100px;
	margin: 0px;
	padding: 0px 25px;
	text-align: center;
	text-decoration: none;
}

.dropmenu li a:hover, .dropmenu ul li:hover a {
	background: rgba(248, 168, 248, 0.938);
	color: #FFFFFF;
	text-decoration: none;
}

.dropmenu li ul {
	background: rgba(248, 168, 248, 0.938);
	display: none;
	height: auto;
	border: 0px;
	position: absolute;
	width: 100%;
	z-index: 50;
	/*top:1em;
/*left:0;*/
}

.dropmenu li:hover ul {
	display: block;
}

.dropmenu li li {
	background: rgba(248, 168, 248, 0.938);;
	display: block;
	float: none;
	margin: 0px;
	padding: 25px;
	/* width:70px; */
}

.dropmenu li:hover li a {
	background: none;
}

.dropmenu li ul a {
	display: block;
	height: 80px;
	font-size: 14px;
	margin: 0px;
	padding: 0px 0px 0px 0px;
	text-align: center;
	line-height: 80px;
}

.dropmenu li ul a:hover, .dropmenu li ul li:hover a {
	background-color: rgb(241, 68, 68);
	border: 0px;
	color: #ffffff;
	text-decoration: none;
}

.dropmenu p {
	clear: left;
}

.board {
	width: 100%;
}

.left {
	float: left;
	width: 500px;
	border: 1px solid black;
	height: 600px;
}

.right {
	float: right;
	width: 500px;
	border: 1px solid black;
	height: 600px;
}

footer {
	color: white;
	background-color: black;
	width: 100%;
	height: 170px;
}

.cl {
	padding-top: 50px;
	float: right;
	margin-right: 20px;
}

.bliud {
	width: 500px;
	height: 500px;
	overflow: scroll;
}

.kp {
	float: right;
}

aside {
	width: 100%;
	height: 500px;
	overflow: hidden;
}

.naver {
	width: 100%;
	transform: translate(0, -120px);
	height: 470px;
}

section {
	width: 100%;
	height: 60%;
	margin: auto;
}
board{
text-align: center;}
</style>

</head>
<body>
<body>
	<header class="header">
		<div class="inner">
			<a href="index">
				<h2>
					<s:message code="common.tilte" />
				</h2>

			</a>
			<div class="header_line">
				<c:if test="${not empty sessionScope.userID}">
         	
        	${sessionScope.userID}님 반갑습니다
                <a href="logout"><s:message code="common.logout" />
					</a>

				</c:if>

				<c:if test="${empty sessionScope.userID}">
					<div>
						<a href="join"><s:message code="common.join" /> </a> <span
							style="color: white;">|</span> <a href="login"><s:message
								code="common.login" /></a>
					</div>
				</c:if>
			</div>


		</div>

	</header>


	<div class="dropmenu">
		<div class="drop_1"></div>
		<ul>

			<li><a href="index"><s:message code="common.go" /></a>
				<ul>

					<li><a href="https://finance.naver.com/"><s:message
								code="common.naver" /></a></li>
					<li><a
						href="https://upbit.com/exchange?code=CRIX.UPBIT.KRW-BTC"><s:message
								code="common.upbit" /></a>
				</ul></li>
			<li><a href="index"><s:message code="common.community" /></a>
				<ul>
					<li><a href="boardList"><s:message code="common.board" /></a></li>
					<li><a href="border"><s:message code="common.board" /></a>
					<li><a href="PhotoBoard"><s:message code="common.board" /></a></li>
				</ul></li>
		</ul>

		<div></div>
	</div>
	<hr>



	<aside>
		<div class="naver">
			<c:import url="https://finance.naver.com/item/main.nhn?code=${code}"></c:import>
		</div>
	</aside>

	<section>
			<c:if test="${not empty sessionScope.userID}">
			
		<form method="post" action="boardRead">
			<input type="text" name="comment" > <input type="hidden"
				name="code" value="${code}"> <input type="submit" style="width :100px" value="입력">
		</form>
		</c:if>
<div style="margin-top:30px">

			<table border="1" style="margin: auto;" >

				<tr>
					<td style="width:200px">작성자</td>
					<td style="width:600px">내용</td>
					<td style="width:100px">날짜</td>

				</tr>

		<c:forEach var="cv" items="${cv}" varStatus="st" >

				<tr class="board">
					<td>${cv.userID}</td>
					<td>${cv.comment}</td>
					<td>${cv.date}</td>

				</tr>

		

		</c:forEach>
			</table>
			</div>
	</section>

	<hr>

	<script>
		window.onload = function() {

		}

		function a() {

			alert('글이 등록 되었씁니다');
		};
	</script>

	<footer>
		<div class="cl">
			<p>만든이 : 정민재</p>
			<p>문의:010-abcd-efgh</p>
		</div>
	</footer>
</body>

</html>