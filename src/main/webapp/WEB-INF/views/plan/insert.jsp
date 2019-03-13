<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template1" type="text/x-handlebars-template">
	{{#each.}}
		<option value="{{eno}}">{{name}}</option>
	{{/each}}
</script>
<script>
	function getExerciseList() {
		var part = $("#part").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/plan/exercise_ajax",
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

	$(function(){
		$("#plus").on("click", function(){
			console.log($("#exercise").val());
			
			var choose = $("<div>").attr("class","choose");
			var info = "<p>" + $("#exercise option:selected").text() + " " +  $("#setcnt").val() + "분/회  " + $("#setcnt").val() + "세트";
			info += "<button type='button' class='remove'>빼기</button></p>";
			var eno = "<input type='hidden' name='eno' value='" + $("#exercise").val() + "'>";
			var execnt = "<input type='hidden' name='execnt' value='" + $("#execnt").val() + "'>";
			var setcnt = "<input type='hidden' name='setcnt' value='" + $("#setcnt").val() + "'>";
			
			choose.append(info);
			choose.append(eno);
			choose.append(execnt);
			choose.append(setcnt);
			
			$("#choose").append(choose);
			
			$("#execnt").val("");
			$("#setcnt").val("");
		})
		
		$("#part").on("change", function(){
			getExerciseList();
		})
		
		$(document).on("click", ".remove", function(){
			$(this).parent().parent().remove();                               
		})
		
		getExerciseList();
	})
</script>

<section>
	<form action="insert" method="post">
			<input type="hidden" name="mno" value="${login.mno }">
			<input type="hidden" name="date" id="t">
			
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">플랜 추가하기</h4>
				</div>
				<div class="modal-body">
					<p>
						<label>플랜 이름</label>
						<input type="text" name="title" placeholder="운동 계획의 이름을 입력해주세요.">
					</p>
					<select id="part">
						<c:forEach var="list" items="${map.list }">
							<option value="${list }">${list }</option>
						</c:forEach>
					</select>
					<select id="exercise">
					</select>
					<input type="text" id="execnt">분/회 
					<input type="text" id="setcnt">세트
					<button type="button" id="plus">추가하기</button>
				</div>
					<div id="choose">
					</div>
					<input type="submit" class="btn btn-primary" value="등록하기">
					<input type="reset" class="btn btn-primary" data-dismiss="modal" value="취소하기">
				</div>
				<div class="modal-footer">
			</div>
		</form>
</section>
<%@ include file="../include/footer.jsp"%>