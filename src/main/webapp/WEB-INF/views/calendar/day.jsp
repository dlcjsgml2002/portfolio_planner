<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>
	var today = null;
	
	function day(y, m, d) {
		today = new Date(y, m, d);
		
		var plan = "";
		var day = today.getDay();
		
		table += "<table>"
		table += "<caption><a href='#' id='prev'>&lt;</a>" + y + "년 " + (m + 1) + "월 " + d + "<a href='#' id='next'>&gt;</a></caption>";
		
		for (var i = 0; i < day; i++) {
			var date = new Date(today.getFullYear(), today.getMonth(), today.getDate());
			today.setDate(today.getDate() - (day - i));
			table += "<td><a>" + (today.getDate()) + "</a></td>";
			today = date;
		}
		                                     
		for (var i = day; i < 7; i++) {
			var date = new Date(today.getFullYear(), today.getMonth(), today.getDate());
			today.setDate(today.getDate() - (day - i));
			table += "<td><a>" + (today.getDate()) + "</a></td>";
			today = date;
		}
		
		table += "</tr>";
		table += "</table>";
		                                
		$("#calendar").html(table);
	}
	
	
	$(function(){
		var date = new Date(${map.today.time});
		week(date.getFullYear(), date.getMonth(), date.getDate());
		
		$(document).on("click", "#prev", function(){
			today.setDate( today.getDate() - 7 );
			week(today.getFullYear(), today.getMonth(), today.getDate());
		})
		
		$(document).on("click", "#next", function(){
			today.setDate( today.getDate() + 7 );
			week(today.getFullYear(), today.getMonth(), today.getDate());
		})
		
	})
</script>
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
					<li>리스트 안 내용</li>
				</ul>
			</li>
		</ul>
	</div>
	<div>
	<h1>일정명</h1>
	<p>카테고리</p>
		<select>
			<option>--부위--</option>
		</select>
		<select>
			<option>--운동 이름--</option>
		</select>
		<p></p>
		<input type="date" placeholder="시작일">
		<input type="date" placeholder="종료일">
	</div>
	<div id="info">
		<h3>이름</h3>
		<p>바이시클</p>
		<h3>설명</h3>
		<p>바이시크은 부릉부릉</p>
		<h3>동영상</h3>
		<iframe width="560" height="315" src="https://www.youtube.com/embed/kgUndAxMqY8" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		<a href="https://www.youtube.com/embed/kgUndAxMqY8">영상보기</a>
	</div>
</section>	
<%@ include file="../include/footer.jsp"%>