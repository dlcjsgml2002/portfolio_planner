<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style>
	header {
		width: 100%;
		height: 20%;
		background-color: blue;
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
</style>
</head>
<body>
	<header>
		<h3>당신과 함께하는 든든한 운동 파트너</h3>
		<h1>작심삼일</h1>
		<div>
			<p>
				<a href="#">내 일정관리</a>
				<a href="#">내 정보관리</a>
				<a href="#">자유 게시판</a>
				<a href="#">챌린지</a>
			</p>
		</div>
	</header>
	<section>
		<div>
			<button>로그인 / 회원가입</button>
		</div>
	</section>
	<footer>
		<p>이 사이트의 저작권은 나에게 있습니다. 저작권은 힘을 만듭니다. 그리고 난 힘찬 기분이 듭니다.</p>
	</footer>
</body>
</html>
