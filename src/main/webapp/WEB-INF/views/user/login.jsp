<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>영남인재교육원</b> Project</a>
		</div>
		<div>
			<p>Sign in to start your session</p>
			
			<form action="loginPost" method="post">
				<div>
					<input type="text" name="id" placeholder="user id">
					<span></span>
				</div>
				<div>
					<input type="text" name="pw"placeholder="user passward">
					<span></span>
				</div>
				<div>
					<div>
						<button type="submit">Sign In</button>
					</div>
				</div>
			</form>
			
			<a href="${pageContext.request.contextPath}/user/search">I forgot my Password</a><br>
			<a href="${pageContext.request.contextPath}/user/register" class="text-center">Register a new membership</a>
		</div>
		
		
	</div>
</body>
</html>