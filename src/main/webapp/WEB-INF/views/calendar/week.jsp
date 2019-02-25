<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
<script>
	var today = null;
	
	function week(y, m, d) {
		today = new Date(y, m, d);
		
		var table = "";
		var day = today.getDay();
		
		table += "<table>"
		table += "<caption><a href='#' id='prev'>&lt;</a>" + y + "년 " + (m + 1) + "월 " + d + "<a href='#' id='next'>&gt;</a></caption>";
		table += "<tr>";
		table += "<th>일</th>";
		table += "<th>월</th>";
		table += "<th>화</th>";
		table += "<th>수</th>";
		table += "<th>목</th>";
		table += "<th>금</th>";
		table += "<th>토</th>";
		table += "</tr>";
		table += "<tr>";
		
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
		
	</div>
</section>
<%@ include file="../include/footer.jsp"%>