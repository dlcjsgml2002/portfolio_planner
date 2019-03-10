<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	정보 페이지
	<form action="" method="get">
		<label>아이디</label>
		<input type="text" name="id">
		<label>비밀번호</label>
		<label>이름</label>
		<input type="text" name="name">
		<label>이메일</label>
		<input type="text" name="email">
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
<%@ include file="../include/footer.jsp"%>