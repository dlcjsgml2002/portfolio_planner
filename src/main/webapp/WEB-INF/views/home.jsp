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
		position: relative;
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
		width: 100%;
		list-style: none;
		margin: 0 auto;
	}
	
	nav > ul > li {
		width: 25%;
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
		width: 100%;
		height: 70%;
		clear: both;
	}
	
	section #banner {
		text-align: center;
	}
	
	footer {
		width: 100%;
		height: 10%;
		text-align: center;
	}
</style>
</head>
<body>
	<header>
		<div id="menu">
			<ul>
				<li><a href="#">로그인</a></li>
				<li><a href="#">회원가입</a></li>
			</ul>
		</div>
	</header>
	
	<nav>
		<ul>
			<li><a href="#">소개</a>
				<ul class="submenu">
					<li><a href="#">작심삼일이란?</a></li>
				</ul>
			</li>
			<li><a href="#">내 일정 확인</a>
			</li>
			<li><a href="#">내 정보 확인</a>
			</li>
			<li><a href="#">커뮤니티</a>
				<ul class="submenu">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">자유 게시판</a></li>
					<li><a href="#">챌린지</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	
	<section>
		<div id="banner">
			<h3>당신과 함께하는 든든한 운동 파트너</h3>
			<h1>작심삼일</h1>
		</div>
	</section>
	
	<footer>
		<p>이 사이트의 저작권은 나에게 있습니다. 저작권은 힘을 만듭니다. 그리고 난 힘찬 기분이 듭니다.</p>
	</footer>
</body>
</html>
