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
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<option value="{{eno}}">{{name}}</option>
	{{/each}}
</script>
<script>
	$(function(){
		getPageList();
		
		$("#part").on("change", function(){
			getPageList();
		})
	})

	function getPageList() {
		var part = $("#part").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/dayajax",
			type : "get",
			data : {"part": part},
			dataType : "json",
			success : function(json) {
				console.log(json);
				$("#exercise").empty();	// 계속되는 추가를 막기위한 초기화
				
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				$("#exercise").append(result);
				}
			})
		}

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
			<c:forEach var="plan" items="${map.plan }">
				<li>${plan.title }</li>
			</c:forEach>  
		</ul>
	</div>
	
	<div>
	<h1>운동 추가하기</h1>
	<p>카테고리</p>
		<select id="part">
			<c:forEach var="list" items="${map.list }">
				<option value="${list }">${list }</option> 
			</c:forEach>      
		</select>
		<select id="exercise">
		</select>
		<input type="date" placeholder="시작일">
		<input type="date" placeholder="종료일">
	</div>
	<div id="info">
	</div>
</section>
<%@ include file="../include/footer.jsp"%>