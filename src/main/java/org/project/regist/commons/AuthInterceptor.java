package org.project.regist.commons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


//로그인이 필요한 각각의 페이지마다, 접근할때 해당 사용자가 로그인을 한 상태인지 확인하기 위한 인터

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
    	HttpServletResponse response,
        Object handler) throws Exception {
        
        HttpSession session = request.getSession();
        
        
       // MemberVo memberVo = (MemberVo) session.getAttribute("authInfo");
        logger.info("로그인 확인 인터셉터(로그인 회원 memberVo) : " + session.getAttribute("authInfo"));
        
        if(session.getAttribute("authInfo") == null) {
        
            logger.info("로그인 되지 않았음");
            
            // 로그인하지 않은 사용자일 경우 로그인 페이지로 이동
            response.sendRedirect("../login/");
            return false;
            
        }
        
        
        logger.info("로그인 확인 완료 ");
        // 로그인한 사용자일 경우 Controller 호출
        return true;
    }
}