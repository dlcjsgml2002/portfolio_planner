<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}

	ul {
		list-style: none;
	}

	header {
		width: 100%;
		height: 20%;
		text-align: center;
	}
	
	header p {
		color: black;
	}

	section {
		width: 100%;
		height: 70%;
	}
	
	footer {
		width: 100%;
		height: 10%;
	}
	
	#menu ul {
		width: 100%;
	}
	
	#menu ul li {
		display: inline;
		float: left;
		width: 25%;
	}
	
	* {
		padding: 0;
		margin: 0;
	}
	
	body {
		background-color: #f2f0f0;
	}
	
	
	/* ---------- header ---------- */
	header {
		width: 960px;
		height: 80px;
		margin: 0 auto;
		position: relative;
	}
	
	header img {
		position: absolute;
		bottom: 10px;
		left: 10px;
	}
	
	header #menu {
		position: absolute;
		bottom: 10px;
		right: 10px;
	}
	
	header #menu ul {
		list-style: none;
	}
	
	header #menu ul li {
		float: left;
		display: inline;
	}
	
	header #menu ul li a {
		color: #000;
		text-decoration: none;
		padding-left: 5px;
		padding-right: 5px;
		border-right: 1px solid #000;
		font-size: 0.8em;
	}
	
	header #menu ul li:LAST-CHILD a {
		border-right: none;
	}
	
	nav {
		width: 100%;
		height: 40px;
		background-color: #000;
		margin-top: 5px;
	}
	
	nav > ul {
		width: 960px;
		list-style: none;
		margin: 0 auto;
	}
	
	nav > ul > li {
		width: 20%;
		float: left;
		display: inline;
		text-align: center;
		position: relative;
	}
	
	nav ul li:HOVER .submenu {
		display: block;
	}
	
	nav ul li .submenu {
		width: 100%;
		background-color: #000;
		list-style: none;
		display: none;
		position: absolute;
		top: 40px;
		left: 0;
	}
	
	nav ul li a {
		color: #fff;
		text-decoration: none;
		line-height: 40px;
	}
	
	nav ul li a:HOVER {
		color: #000;
		background-color: gray;
		display: block;
	}
	
	section {
		width: 960px;
		margin: 0 auto;
		clear: both;
		text-align: center;
		margin-top: 20px;
	}
	
	section img {
		margin-top: 20px;
		width: 100%;
	}
	
</style>
</head>
<body>
	<header>	
		<div>
			<a>홈</a>
			<button>로그인 / 회원가입</button>
		</div>
		
		<div id="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/info/info">소개</a></li>
				<li><a href="${pageContext.request.contextPath}/calendar/cal">내 일정관리</a></li>
				<li><a href="#">내 정보관리</a></li>
				<li>게시판
					<ul>
						<li><a href="${pageContext.request.contextPath}/board/list">공지사항</a></li>
						<li><a href="${pageContext.request.contextPath}/board/pinpoint">자유게시판</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</header>
	
	<section>
		<div id="banner">
			<h3>당신과 함께하는 든든한 운동 파트너</h3>
			<h1>작심삼일</h1>
		</div>
		<img alt="" src="${pageContext.request.contextPath }/resources/images/test.jpg">
	</section>
	
	<footer>
		<div>
			<p>이 사이트의 저작권은 나에게 있습니다. 저작권은 힘을 만듭니다. 그리고 난 힘찬 기분이 듭니다.</p>
		</div>
	</footer>
</body>
</html>
