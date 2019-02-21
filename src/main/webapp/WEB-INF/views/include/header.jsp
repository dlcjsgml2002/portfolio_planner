<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/include.css?m=3">
</head>
<body>
	<header>
		<div id="banner">
			<h3>당신과 함께하는 든든한 운동 파트너</h3>
			<h1>작심삼일</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
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
			<li><a href="${pageContext.request.contextPath}/calendar/calendar">내 일정 확인</a>
			</li>
			<li><a href="#">내 정보 확인</a>
				<ul class="submenu">
					<li><a href="${pageContext.request.contextPath}/board/list">내 정보 변경</a></li>
					<li><a href="${pageContext.request.contextPath}/board/list">내 건강 정보</a></li>
				</ul>
			</li>
			<li><a href="#">커뮤니티</a>
				<ul class="submenu">
					<li><a href="${pageContext.request.contextPath}/board/list">공지사항</a></li>
					<li><a href="${pageContext.request.contextPath}/board/list">자유 게시판</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	
	<section>