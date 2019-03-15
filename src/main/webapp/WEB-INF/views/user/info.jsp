<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	form {
		margin: 0 auto;
		width: 800px;
	}
	
	form button {
		text-align: center;
	}
	
	button {
		widht: 200px;
	}
</style>
<section>
	<form action="info" method="get">
		<div class="form-group">
	    	<label>아이디</label>
			<input type="text" class="form-control" name="id" placeholder="${member.id }" readonly>
	  	</div>
	  	
	 	<div class="form-group">
	    	<label>이름</label>
			<input type="text" class="form-control" name="name" placeholder="${member.name }" readonly>
	  	</div>
	  	
	  	<div class="form-group">
	   		<label>이메일</label>
			<input type="text" class="form-control" name="email" placeholder="${member.email }" readonly>
	  	</div>
	  	
	  	<div class="form-group">
	   		<label>몸무게</label>
			<input type="text" class="form-control" name="weight" placeholder="${member.weight }" readonly>
	  	</div>
	  	
	  	<div class="form-group">
	   		<label>키</label>
			<input type="text" class="form-control" name="height" placeholder="${member.height}" readonly>
	  	</div>
	  	
	  	<button type="submit" class="btn btn-primary">수정</button>
	</form>
	
</section>
<%@ include file="../include/footer.jsp"%>