<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	#loginDiv {
		width: 100%;
	}
	
	.col-md-6 {
		margin: 0 auto;
	}
</style>
<script>
	function joinCheck() {
		var id = $("#inputId").val();
		var pw = $("#inputPassword").val();
		var pw_check = $("#inputPasswordCheck").val();
		var name = $("#inputName").val();
		var email = $("#InputEmail").val();
		
		if (pw !== pw_check ) {
			console.log("비밀번호가 다릅니다.");
			return false;
		}
		
		if (pw === "" || pw_check === "") {
			console.log("비밀번호를 입력하세요.");
			return false;
		}
	
		
		var formData = $("#LoginForm").serialize();
		$.ajax({
	        url:"${pageContext.request.contextPath}/user/register",
	        type:'POST',
	        data: formData,
	        success:function(data){

	        	if(data){
	        		alert("회원가입이 완료 되었습니다.");
	        		location.href = "${pageContext.request.contextPath}/user/login";
	        	}else{
	        		
	           		alert("회원가입이 실패 되었습니다.\n입력정보를 다시 확인해주세요.");
	        	}
	        	
	        	
	        	
	        },
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
	            self.close();
	        }
	    });
	}

	$(function(){
		
	})
</script>
<section>
<div id="loginDiv">
	<div class="col-md-6" >
		 <form action="register" method="post" id="LoginForm">
                    <div class="form-group">
                        <label for="inputName">아이디</label>
                        <input type="text" class="form-control" id="inputId" name="id" placeholder="아이디를 입력해 주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="inputPassword"  name="pw" placeholder="비밀번호를 입력해주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="inputPasswordCheck" name="pw_check" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="inputName">성명</label>
                        <input type="text" class="form-control" id="inputName" name="name" placeholder="이름을 입력해 주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="InputEmail">이메일 주소</label>
                        <input type="email" class="form-control" id="InputEmail" name="email" placeholder="이메일 주소를 입력해주세요">
                    </div>
                    
                  	<div class="form-group">
                        <label for="InputEmail">추가 정보</label>
                    </div>
                    
                    <div class="form-group">
                        <label for="InputEmail">나이</label>
                        <input type="text" class="form-control" id="age" name="age" placeholder="만 나이를 입력해주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="InputEmail">키</label>
                        <input type="text" class="form-control" id="height" name="height" placeholder="키를 입력해주세요">
                    </div>
                    
                    <div class="form-group">
                        <label for="InputEmail">몸무게</label>
                        <input type="text" class="form-control" id="weight" name="weight" placeholder="몸무게를 입력해주세요">
                    </div>

                    <div class="form-group text-center">
                        <button type="button" id="join-submit" class="btn btn-primary" onclick="joinCheck();">회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
                        
                        <button type="submit" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i>
                        </button>
                    </div>
                </form>
	</div></div>
</section>
<%@ include file="../include/footer.jsp"%>