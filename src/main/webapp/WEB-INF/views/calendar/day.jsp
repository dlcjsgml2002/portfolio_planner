<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	table {
		margin: 0 auto;
		width: 1000px;
	}
	
	.btn-group {
		float: right;
		margin-bottom: 20px;
	}
	
	button {
		width: 130px;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<option value="{{eno}}">{{name}}</option>
	{{/each}}
</script>
<script id="template2" type="text/x-handlebars-template">
	{{#each.}}
		<tr>
			<td>
				{{plan.title}}
			</td>
			<td><button class="execute_pl btn btn-success" value="{{pdno}}">{{execute}}</button></td>
			<td><button class="del_pl btn btn-danger" value="{{pdno}}">빼기</button></td>
		</tr>
		<tr>
			<td>
				{{#plan.planList}}
					<p>
						<a href="{{exercise.link}}">{{exercise.name}}</a> {{execnt}}회/분 {{setcnt}}세트
					</p>
				{{/plan.planList}}
			</td>
		</tr>
	{{/each}}
</script>
<script>
	var today = null;
	
	function day(y, m, d) {
		today = new Date(y, m, d);
		var cale = "<h3><a href='#' id='prev'>&lt;</a> " + y + "년 " + (m + 1) + "월" + d + "일 <a href='#' id='next'>&gt;</a><h3>";
		
		$("#cale").html(cale);
	}
	
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
	
	function getPlanList() {
		var time = today.getFullYear()  + "-" + (today.getMonth() + 1) + "-" + today.getDate();
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/dateajax",
			type : "get",
			data : {
				"mno" : ${login.mno},
				"time": time
				},
			dataType : "json",
			success : function(json) {
				console.log(json);
				
				$("#cal_tbody").empty();
				
				var source = $("#template2").html();
				var f = Handlebars.compile(source);
				var result = f(json);
				
				$("#cal_tbody").append(result);
				}
			})
		}
	                   
	function add_plan() {
		$("#list").modal("show");
	}
	
	function insert_plan() {
		$("#t").val(today);
		$("#insert").modal("show");
	}

	function get_plan_info(pno) {
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/day",
			type : "get",
			data : {"pno": pno},
			success : function(json) {
				console.log(json);
				}
			})
		}
	
	function execute_plan(pdno) {
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/updateajax",
			type : "get",
			data : {"pdno": pdno},
			success : function(json) {
				console.log(json);

				getPlanList();
			}
		})
	}
	
	function remove_plan(pdno) {
		$.ajax({
			url : "${pageContext.request.contextPath}/calendar/removeajax",
			type : "get",
			data : {"pdno": pdno},
			success : function(json) {
				console.log(json);

				getPlanList();
			}
		})
	}                     
	
	$(function(){
		var date = new Date(${map.today.time});
		day(date.getFullYear(), date.getMonth(), date.getDate() );
		
		$(document).on("click", "#prev", function(){
			today.setDate( today.getDate() - 1 );
			day(today.getFullYear(), today.getMonth(), today.getDate() );
			getPlanList();
		})
		
		$(document).on("click", "#next", function(){
			today.setDate( today.getDate() + 1 );
			day(today.getFullYear(), today.getMonth(), today.getDate() );
			getPlanList();
		})
		
		$("#part").on("change", function(){
			getExerciseList();
		})
		
		$(document).on("click", ".execute_pl", function(){
			var pdno = $(this).val();
			execute_plan(pdno);
		})
		
		$(document).on("click", ".del_pl", function(){
			var pdno = $(this).val();
			remove_plan(pdno);
		})
		
		getExerciseList();
		getPlanList();
	})
	
</script>
<section>
	<input type="hidden" name="today" value="${today }">
	<div class="btn-group" role="group">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/day?mno=${login.mno }'" class="btn btn-secondary">일</button>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/week?mno=${login.mno }'" class="btn btn-secondary">주</button>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/calendar/month?mno=${login.mno }'" class="btn btn-secondary">월</button>
	</div>
	
	<table class="table" id="calendar_table">
		<thead class="thead-dark">
			<tr>
				<th id="cale"  style="width: 60%"></th>
				<th  style="width: 20%"><button class="btn btn-primary" onclick="insert_plan()">계획 추가하기</button></th>
				<th  style="width: 20%"><button class="btn btn-primary" onclick="add_plan()">계획 불러오기</button></th>
			</tr>
		</thead>
		<tbody id="cal_tbody">
		</tbody>
	</table>	
</section>                         
<%@ include file="../calendar/modal/list.jsp"%>
<%@ include file="../calendar/modal/insert.jsp"%>
<%@ include file="../include/footer.jsp"%>