package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//권한이 있는 애들(회원)만 들어갈 수 있게 하는 기능
public class AuthInterceptor extends HandlerInterceptorAdapter { 
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user"); // 값이 있는지 없는지 확인만 하기 때문에 형변환 하지 않고 Object사용
		//AccoutnVo user = (AccoutnVo)session.getAttribute("user");
		if(user == null) {
			// 비회원이면 home으로
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true;
	}
}
