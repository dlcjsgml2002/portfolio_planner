package com.yi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yi.controller.UserController;
import com.yi.domain.Login;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("------- preHandle");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("------- postHandle");
		
		Login vo = (Login) modelAndView.getModel().get("member");
		
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute(LOGIN, vo);
			Object dest = session.getAttribute("dest");
			String path = dest != null ? (String) dest : request.getContextPath() + "/board/list";
			response.sendRedirect(path);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("------- afterCompletion");
	}

}
