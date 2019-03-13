<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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