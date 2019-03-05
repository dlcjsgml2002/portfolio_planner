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
	
	#calendar_table tbody tr:first-child td {
		
	}
	
	#calendar_table tbody tr td {
		padding: 10px;
		border: 1px solid #ddd;
	}
	
	#calendar_menu {
		float: right;
	}
	
	#calendar_menu a {
		border: 1px solid black;
	}
	
	.plan_item_div {
		color: #424242;
		position: relative;
		display: block;
		padding: 10px 15px;
		margin-bottom: -1px;
		background-color: #fff;
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
		getExerciseList();
		
		$("#part").on("change", function(){
			getExerciseList();
		})
	})

	function getExerciseList() {
		var part = $("#part").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/dayajax",
			type : "get",
			data : {"part": part},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				$("#exercise").empty();
				
				var source = $("#template1").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				
				$("#exercise").append(result);
				}
			})
		}
	
	function add_plan() {
		$("#list").modal("show");
	}
	
	function insert_plan() {
		$("#insert").modal("show");
	}

	function get_plan_info(pno) {
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/modal/list",
			type : "get",
			data : {"pno": pno},
			success : function(json) {
				console.log(json);
				}
			})
		}
</script>
<section>
	<div id="calendar_menu">
		<a href="${pageContext.request.contextPath}/calendar/day?mno=${login.mno }">Day</a>
		<a href="${pageContext.request.contextPath}/calendar/week?mno=${login.mno }">Week</a>
		<a href="${pageContext.request.contextPath}/calendar/month?mno=${login.mno }">Month</a>
	</div>
	
	<table class="table" id="calendar_table">
		<colgroup>
			<col width="25%">
			<col width="5%">
		</colgroup>
	
		<thead>
			<tr>
				<th style="text-align: center; font-size: 25px"><fmt:formatDate value="${map.today }" pattern="yyyy-MM-dd"/></th>
				<th><button class="btn btn-primary" onclick="insert_plan()">계획 추가하기</button></th>
				<th><button class="btn btn-primary" onclick="add_plan()">계획 불러오기</button></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="plan" items="${map.plan }">
				<tr>
					<td>
						<a href="javascript:void(0)" onclick="get_plan_info(${plan.pno })">${plan.title }</a>
					</td>
	
					<td>
						<c:forEach var="list" items="${map.planList }">
							<p><a href="${list.exercise.link }">${list.exercise.name }</a>${list.setcnt }개 ${list.exec }</p>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>                         
<%@ include file="../calendar/modal/list.jsp"%>
<%@ include file="../calendar/modal/insert.jsp"%>
<%@ include file="../calendar/modal/update.jsp"%>
<%@ include file="../include/footer.jsp"%>