<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/include.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</head>
<script>
	$(function() {
		
	})
</script>
<body>
	<header>
		<div id="banner">
			<h3>당신과 함께하는 든든한 운동 파트너</h3>
			<h1>작심삼일</h1>
		</div>
		<div id="menu">
			<ul>
				<c:if test="${login == null}">
					<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
				</c:if>
				<c:if test="${login != null}">
					<li>${login.name }(${login.id })님 환영합니다.</li>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				</c:if>
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
			<c:if test="${login == null }">
				<li><a href="${pageContext.request.contextPath}/calendar/day">내 일정확인</a>
				</li>
				<li><a href="#">내 정보 확인</a>
					<ul class="submenu">
						<li><a href="${pageContext.request.contextPath}/user/login">내 정보관리</a></li>
						<li><a href="${pageContext.request.contextPath}/user/login">내 운동관리</a></li>
					</ul>
				</li>
				<li><a href="#">커뮤니티</a>
					<ul class="submenu">
						<li><a href="${pageContext.request.contextPath}/user/login">공지사항</a></li>
						<li><a href="${pageContext.request.contextPath}/user/login">자유 게시판</a></li>
					</ul>
				</li>
			</c:if>
			<c:if test="${login != null }">
				<li><a href="${pageContext.request.contextPath}/calendar/day">내 일정확인</a>
				</li>
				<li><a href="#">내 정보 확인</a>
					<ul class="submenu">
						<li><a href="${pageContext.request.contextPath}/user/info">내 정보관리</a></li>
						<li><a href="${pageContext.request.contextPath}/user/health">내 운동관리</a></li>
					</ul>
				</li>
				<li><a href="#">커뮤니티</a>
					<ul class="submenu">
						<li><a href="${pageContext.request.contextPath}/board/list">공지사항</a></li>
						<li><a href="${pageContext.request.contextPath}/board/list">자유 게시판</a></li>
					</ul>
				</li>
			</c:if>
		</ul>
	</nav>