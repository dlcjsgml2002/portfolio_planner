<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	정보 페이지
	<form action="info" method="get">
		${member }
		<label>아이디</label>
		<input type="text" name="id" placeholder="${member.id }">
		<label>비밀번호</label>
		<label>이름</label>
		<input type="text" name="name" placeholder="${member.name }">
		<label>이메일</label>
		<input type="text" name="email" placeholder="${member.email }">
		<label>이메일</label>
		<input type="text" name="weight" placeholder="${member.weight }">
		<label>이메일</label>
		<input type="text" name="height" placeholder="${member }">
		<label>이메일</label>
		<input type="text" name="email" placeholder="${member }">
		<input type="submit" value="수정하기" >
		<input type="reset" value="취소">
	</form>
<%@ include file="../include/footer.jsp"%>