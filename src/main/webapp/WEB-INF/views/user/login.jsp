<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
	#login-box {
		width: 100%;
	}
	
	.col-md-6 {
		margin: 0 auto;
	}
</style>

<section>
	<div id="login-box">
	<div class="col-md-6" >
		 <form action="loginPost" method="post" id="LoginForm">
                    <div class="form-group">
                        <label for="inputName">아이디</label>
                      	<input type="text" class="form-control"  name="id" placeholder="아이디를 입력해주세요"> <span></span>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" name="pw" class="form-control"  placeholder="비밀번호를 입력해주세요"> <span></span>
                    </div>
                    

                    <div class="form-group text-center">
                    <button type="submit">로그인</button>
                    
                    
                     	<a href="${pageContext.request.contextPath}/user/search" class="btn btn-primary">아이디&비밀번호 찾기</a><br> 
				
				<a
				href="${pageContext.request.contextPath}/user/register"
				class="btn btn-primary">회원가입</a>
                    </div>
                </form>
	</div></div>
	
</section>
<%@ include file="../include/footer.jsp"%>