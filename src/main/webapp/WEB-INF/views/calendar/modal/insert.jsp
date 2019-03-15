<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.modal-dialog {
	    max-width: 1200px;
	    margin: 1.75rem auto;
	}
	
	.modal-body{
		min-height: 500px;
	}
	
	#choose {
		height: 300px;
	}
	
	#btn {
		margin: 0 auto;
		width: 600px;
	}
	
	#btn input {
		width: 200px;
	}
	
	#exercise {
		width: 600px;
	}
	
	#setcnt, #execnt {
		width: 50px;
	}
	
	#title {
		width: 250px;
	}
</style>
<script>
	$(function(){
		$("#plus").on("click", function(){
			console.log($("#exercise").val());
			var choose = $("<div>").attr("class","choose");
			var info = "<p>" + $("#exercise option:selected").text() + " " +  $("#setcnt").val() + "분/회 " + $("#setcnt").val() + "세트";
			info += "<button type='button' class='remove btn btn-danger'>빼기</button></p>";
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
			
			getPlanList();
		})
		
		$(document).on("click", ".remove", function(){
			$(this).parent().parent().remove();                               
		})
	})
</script>
<div id="insert" class="modal fade" role="dialog">
	<div class="modal-dialog">
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
						<input type="text" name="title" id="title" placeholder="운동 계획의 이름을 입력해주세요.">
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
					<button type="button" id="plus" class="btn btn-primary">추가하기</button>
					<div id="choose">
					
					</div>
					<div id="btn">
						<input type="submit" class="btn btn-primary" value="등록하기">
						<input type="reset" class="btn btn-danger" data-dismiss="modal" value="취소하기">
					</div>
				</div>
			</div>
			<div class="modal-footer">
			</div>
		</form>
	</div>
</div>
