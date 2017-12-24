package com.fw.api.secure;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fw.api.aop.annotation.NoLogin;
import com.fw.api.web.bean.FwBean;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private FwBean fwBean;
	
	// private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
		
		if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {  
            return true;  
        }  
		
		final HandlerMethod handlerMethod = (HandlerMethod) handler;  
        final Method method = handlerMethod.getMethod();  
        final Class<?> clazz = method.getDeclaringClass();  
        
        //无须登录的请求 clazz.isAnnotationPresent(NoLogin.class)
        if (method.isAnnotationPresent(NoLogin.class))  return true;
        if (clazz.isAnnotationPresent(NoLogin.class) || clazz.getAnnotatedSuperclass().isAnnotationPresent(NoLogin.class)) return true;
        
        // 此处做业务逻辑处理
        
        return true;
	}

}