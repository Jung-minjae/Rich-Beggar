
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Style.css">
<title><s:message code="common.tilte" /></title>
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

#container {
	width: calc(100%/ 3);
}

.three>li {
	width: calc(100%/ 3)
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
	height: 117px;
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
img{
width:400px;
height:400px;
}
</style>
</head>

<body>
	<header class="header">
		<div class="inner">
			<a href="#">
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

				</ul></li>
		</ul>

		<div></div>
	</div>
	<hr>


	<div class="inner .board">

		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="https://code.highcharts.com/stock/highstock.js"></script>
		<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>




		<div>
			<ul class="three">

				<li style="float: left">
					<div><h1>코스닥 </h1><br>
					<h2>${list_0.get(0)}</h2></div>
					<div>
						<img
							src="https://ssl.pstatic.net/imgfinance/chart/main/KOSPI.png?sidcode=1616486820605">
							
					</div>
				<div style="overflow: scroll; width: 350px; height: 700px">
					<table border=1>
						<tr>
							<td><s:message code="common.number" /></td>
							<td><s:message code="common.name" /></td>
							<td><s:message code="common.price" /></td>
							<td><s:message code="common.perprice" /></td>
							<td><s:message code="common.per" /></td>
						</tr>




						<c:forEach var="l" items="${list}">

							<tr>
								<td>${l.up}</td>
								<td><a href="boardRead?code=${l.code}" target="_blank">${l.name}</a></td>
								<td>${l.price}</td>
								<td>${l.upPrice }</td>
								<td>${l.per }</td>
							</tr>



						</c:forEach>


					</table>
					</div>
				</li>


				<li style="float: left">
					<div><h1>코스피</h1><br>
					<h2> ${list_0.get(1)}</h2></div>
				
						<img
							src="https://ssl.pstatic.net/imgfinance/chart/main/KOSDAQ.png?sidcode=1616486820607"
							 alt="코스닥지수 상세보기">
				<div style="overflow: scroll; width: 350px; height: 700px">
						<table border=1>
							<tr>
								<td><s:message code="common.number" /></td>
								<td><s:message code="common.name" /></td>
								<td><s:message code="common.price" /></td>
								<td><s:message code="common.per" /></td>
								<td><s:message code="common.perprice" /></td>
							</tr>
							<c:forEach var="l_1" items="${list_1}">
								<tr>
									<td>${l_1.up}</td>
									<td><a href="boardRead?code=${l_1.code2}" target="_blank">${l_1.name }</a></td>
									<td>${l_1.price}</td>
									<td>${l_1.upPrice }</td>
									<td>${l_1.per }</td>
								</tr>

							</c:forEach>

						</table>
					</div>


				</li>


				<li style="float: left">
				<div><h1>코인</h1><br>
					<h2> 비트코인가격</h2></div>
					
					<div id="container" style="height: 400px; min-width: 310px"></div>



					<div class="Kp">
						<div style="overflow: scroll; width: 350px; height: 700px">
					
							<table border=1>
								<tr>
									<td>이름</td>
									<td>코인이름</td>
									<td>가격</td>
									<td>등락률</td>
								</tr>


								<c:forEach var="coin" items="${Coin_list}">
									<tr>
										<td>${coin.kr_name }</td>
										<td>${coin.name}</td>
										<td>${coin.last}</td>
										<td>${coin.persent}%</td>
								</c:forEach>
							</table>
						</div>
					</div>
				</li>

			</ul>

		</div>

		<!-- #content > div.article > div.section2 > div.section_stock_market > div.section_stock > div.kosdaq_area.group_quot.quot_opn > div.chart_area > a > img -->



		<script>
			function draw3() {
				var chartdata = [];
				$
						.getJSON(
								'https://poloniex.com/public?command=returnChartData&currencyPair=BTC_ETH&start=1455699200&end=9999999999&period=14400',
								function(data) {
									$.each(data, function(i, item) {
										chartdata.push([ item.date * 1000,
												item.open, item.high, item.low,
												item.close ]);
									});
								}).done(function() {
							Highcharts.stockChart('container', {
								title : {
									text : 'ETH/BTC'
								},
								rangeSelector : {
									buttons : [ {
										type : 'hour',
										count : 1,
										text : '1h'
									}, {
										type : 'day',
										count : 1,
										text : '1d'
									}, {
										type : 'all',
										count : 1,
										text : 'All'
									} ],
									selected : 2,
									inputEnabled : true
								},
								plotOptions : {
									candlestick : {
										downColor : 'blue',
										upColor : 'red'
									}
								},
								series : [ {
									name : 'ETH/BTC',
									type : 'candlestick',
									data : chartdata,
									tooltip : {
										valueDecimals : 8
									}
								} ]
							});
						});
			}
			draw3();
		</script>


	</div>
	<hr>

	<footer>
		<div class="cl">
			<p>만든이 : 정민재</p>
			<p>문의:010-abcd-efgh</p>
		</div>
	</footer>

</body>

</html>