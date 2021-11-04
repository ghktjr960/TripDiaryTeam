package org.project.regist.commons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.regist.service.MemberService;
import org.project.regist.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;


//회원탈퇴 신청 여부
public class ResignInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ResignInterceptor.class);
    private MemberService memberService;
    

    //회원탈퇴 진행중인 회원이 로그인하였을때;
    @Override
    public boolean preHandle(HttpServletRequest req,
       HttpServletResponse res, Object obj) throws Exception {
     
     HttpSession session = req.getSession();
     
     logger.info("회원탈퇴 진행 여부 파악중...");

     //로그인 확인;
     //일반 회원이 로그인하였을 때;
     //null이면 일반회원 / null이 아니면 탈퇴진행회원
     if(session.getAttribute("resignchk") == null) {

    	
      
         //탈퇴 테이블 조회하여 중복값이 도출될 경우, 탈퇴 상태로 사용, 무조건 철회페이지만 보여주기
         //회원탈퇴 신청을 한 회원이 로그인하였을 경우, DEL_MEMBER 테이블을 조회하여 중복값을 찾아 리턴해준다;
        
   

         logger.info("일반 회원입니다. ");
         
         return true;
    	// res.sendRedirect("/");
    	 
    	
    	 
     }else if(session.getAttribute("resignchk") != null){
     
     
    	 logger.info("회원탈퇴 진행중인 회원입니다. ");
    	 
         res.sendRedirect("/member/resigncancel");
         return false;
    	 
    	 
   
    }
     
 	 logger.info("로그인 회원이 아닙니다. ");
	 return true;
     
     
    }
    
}



