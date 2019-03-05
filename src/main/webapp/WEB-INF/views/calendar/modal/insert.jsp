<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.modal-dialog {
	    max-width: 1400px;
	    margin: 1.75rem auto;
	}
	
	.modal-body{
		min-height: 500px;
	}
</style>
<script>
	$(function(){
		$("#plus").on("click", function(){
			console.log($("#exercise").val());
			var info = "<p>" + $("#exercise").text() + "" +  $("#setcnt").val() + "회</p>"
			var eno = "<input type='text' name='eno' value='" + $("#exercise").val() + "' hidden>";
			var setcnt = "<input type='text' name='setcnt' value='" + $("#setcnt").val() + "' hidden>";
			$("#choose").append(info);
			$("#choose").append(eno);
			$("#choose").append(setcnt);
		})
	})
</script>
<div id="insert" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<form action="insert" method="post">
			<input type="text" name="mno" value="${login.mno }">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">플랜 추가하기</h4>
				</div>
				<div class="modal-body">
					<p>
						<label>플랜 이름</label>
						<input type="text" name="title">
					</p>
					<select id="part">
						<c:forEach var="list" items="${map.list }">
							<option value="${list }">${list }</option>
						</c:forEach>
					</select>
					<select id="exercise">
					</select>
					<input type="text" id="setcnt">
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
	</div>
</div>
