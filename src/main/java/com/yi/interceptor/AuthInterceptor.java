package com.yi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yi.domain.Login;

public class AuthInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		
		if (login != null) {
			logger.info("session : " + login);
		}
		
		if (login == null) { // 로그인을 하지 않은 상태
			saveDest(request);
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false; // register controller로 가는 걸 막음
		}
		
		return true;
	}
	
	// login 화면으로 이동 전에 원래 가고자 하는 path를 저장해 뒀다가 로그인이 되면 그 곳으로 이동되도록 한다.
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if (request.getMethod().equalsIgnoreCase("get")) {
			logger.info("dest : " + (uri + query));
			request.getSession().setAttribute("dest", uri + query);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
