package com.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.Domian.User;

public class Interceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) arg0.getSession().getAttribute("user");
		if (user == null) {
			arg0.setAttribute("msgs", "����ϵͳ����ǰ���ȵ�¼��");
			arg0.getRequestDispatcher("index").forward(arg0, arg1);
			return false;
		} else {
			return true;
		}

	}

}
