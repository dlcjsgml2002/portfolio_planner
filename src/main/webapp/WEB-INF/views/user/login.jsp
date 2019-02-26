<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>영남인재교육원</b> Project</a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
			
			<form action="loginPost" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="id" class="form-control" placeholder="user id">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" name="pw" class="form-control" placeholder="user passward">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-4 col-xs-offset-8">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
					</div>
				</div>
			</form>
			
			<a href="#">I forgot my Password</a><br>
			<a href="#" class="text-center">Register a new membership</a>
		</div>
		
		
	</div>
	
	<!-- Bootstrap 3.3.2 JS -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>