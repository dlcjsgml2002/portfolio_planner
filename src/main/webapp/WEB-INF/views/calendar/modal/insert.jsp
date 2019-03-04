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
<div id="insert" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">플랜 추가하기</h4>
					<button type="button" class="btn btn-primary" >운동추가</button>
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
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary">등록하기</button>
			<button type="button" class="btn btn-primary" data-dismiss="modal">취소하기</button>
		</div>
	</div>
</div>
