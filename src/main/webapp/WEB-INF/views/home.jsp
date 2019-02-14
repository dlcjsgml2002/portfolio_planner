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
	
	#menu ul {
		width: 100%;
	}
	
	#menu ul li {
		display: inline;
		float: left;
		width: 20%;
	}
</style>
</head>
<body>
	<header>
		<div id="banner">
			<h3>당신과 함께하는 든든한 운동 파트너</h3>
			<h1>작심삼일</h1>
		</div>
		
		<div>
			<button>로그인 / 회원가입</button>
		</div>
		
		<div id="menu">
		<a>홈</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/info/info">소개</a></li>
				<li><a href="${pageContext.request.contextPath}/calendar/cal">내 일정관리</a></li>
				<li><a href="#">내 정보관리</a></li>
				<li>게시판
					<ul>
						<li><a href="${pageContext.request.contextPath}/board/list">자유 게시판</a></li>
						<li><a href="${pageContext.request.contextPath}/board/pinpoint">챌린지 게시판</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</header>
	
	<section>
		섹션 영역
	</section>
	
	<footer>
		<div>
			<p>이 사이트의 저작권은 나에게 있습니다. 저작권은 힘을 만듭니다. 그리고 난 힘찬 기분이 듭니다.</p>
		</div>
	</footer>
</body>
</html>
