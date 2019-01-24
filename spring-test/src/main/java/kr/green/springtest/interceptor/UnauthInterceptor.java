package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UnauthInterceptor extends HandlerInterceptorAdapter { 
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user"); // 값이 있는지 없는지 확인만 하기 때문에 형변환 하지 않고 Object사용
		//AccoutnVo user = (AccoutnVo)session.getAttribute("user");
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/bbs/list");
		}
		return true;
	}
}
