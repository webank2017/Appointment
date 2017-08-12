/**
 * 
 */
package com.webank.Appointment.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.webank.Appointment.utils.SessionUtil;

/**
 * @author shawphychen
 *
 */
public class UserInterceptor  implements HandlerInterceptor{
	//不用拦截的url请求
		private List<String> unCheckUrls;
		
		/**
		 * @return the unCheckUrls
		 */
		public List<String> getUnCheckUrls() {
			return unCheckUrls;
		}

		/**
		 * @param unCheckUrls the unCheckUrls to set
		 */
		public void setUnCheckUrls(List<String> unCheckUrls) {
			this.unCheckUrls = unCheckUrls;
		}

		@Override
		public boolean preHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler) throws Exception {
			
			String requestUrl = request.getRequestURI(); 
			if(unCheckUrls.contains(requestUrl))
			{
				return true;
			}
			else
			{	
				//从session里面获取第三方session 判断有没有过期 若过期则需要跳转认证
				String thirdSession = request.getParameter("thirdSession");
				
				if(thirdSession!=null && SessionUtil.isExist(request.getSession(), thirdSession))
				{
					return true;
				}
				else
				{
					response.sendRedirect("/user/login");
					return false;
				}
			}
			
			
			
			
		}

		@Override
		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			// TODO Auto-generated method stub

		}
}