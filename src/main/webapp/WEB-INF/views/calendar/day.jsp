<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	section {
		margin: 10px auto;
		width: 80%;
		height: 760px;
	}

	table {
		margin: 10px auto;
		width: 100%;
		border-collapse: collapse;
	}
	
	th:first-child, td:first-child a {
		color: red;
	}
	
	th:last-child, td:last-child a {
		color: blue;
	}
	
	a {
		color: black;
		text-decoration: none;
	}

	th, td {
		width: 100px;
		height: 100px;
		border: 1px solid black;
	}
	
	#calendar_menu {
		float: right;
	}
	
	#calendar_menu a {
		border: 1px solid black;
	}
</style>
<section>
	<div id="calendar_menu">
		<a href="${pageContext.request.contextPath}/calendar/day">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/month">Month</a>
	</div>
	<div id="calendar">
		<img alt="" src="">
		<a><fmt:formatDate value="${map.today }" pattern="yyyy-MM-dd"/></a>
		<img alt="" src="">
		<ul>
			<li>리스트
				<ul>
					<li>팔굽혀펴기 3set <a>체크</a> <a>빼기</a></li>
					<li>브런치 3set <a>체크</a> <a>빼기</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div>
	<h1>일정명</h1>
	<p>카테고리</p>
		<p>${map.list }</p>
		<select>
			<option>--부위--</option>
			<c:forEach items="" var="">
				
			</c:forEach>
		</select>
		<select>
			<option>--운동 이름--</option>
		</select>
		<p></p>
		<input type="date" placeholder="시작일">
		<input type="date" placeholder="종료일">
	</div>
	<div id="info">
	</div>
</section>	
<%@ include file="../include/footer.jsp"%>