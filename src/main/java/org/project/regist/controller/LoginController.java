package org.project.regist.controller;


import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.project.regist.commons.AuthInterceptor;
import org.project.regist.service.MemberService;

import org.project.regist.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	  
	
	@Autowired
	private MemberService memberService;
	
	
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	//암호화기능
	@Inject
	BCryptPasswordEncoder pwEncoder;
	
	
	//로그인 페이지
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGet( MemberVo memberVo, HttpServletRequest req,HttpServletResponse resp, HttpSession session) throws Exception {

    	
    	
    
    	
    	
    	logger.info("로그인 페이지 출력합니다.");
    	return "/MH/signIn";
    }
	
    
 // 로그인 처리
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPOST( MemberVo memberVo, HttpServletRequest req,HttpServletResponse resp, RedirectAttributes rttr, 
String rememberCookie, Model model) throws Exception {


    	
    	//return 주소값을 받아주기위한 field값
    	String url;
    	
    	//로그인 회원의 정보를 세션에 담기 위한 작업;
    	HttpSession session = req.getSession();
    	
    	//member Table 내부에서 아이디와 일치하는 Vo를 가져옴;
    	MemberVo authInfo = memberService.login(memberVo);
    	
    	//아이디기억 체크박스값 
    	String idRemember = (String)req.getParameter("idRemember");
    	
    	logger.info("아이디 기억값 : " + idRemember);
    	
    	//jsp에서 입력한 비밀번호
    	String inputPw = req.getParameter("password");
    	logger.info(inputPw);
    	
    	//입력한 아이디와 일치하는 값이 있을때;
    	if(authInfo != null) {
    		
    		//암호화된 비밀번호와 입력 비밀번호를 확인하는 작업
        	boolean pwMatch = pwEncoder.matches(inputPw, authInfo.getPassword());
        	
        	//입력한 비밀번호가 일치할때;
        	if(pwMatch == true){
        		
        		//로그인이 성공했을경우,loginSession에 입력된 값을 저장
        		session.setAttribute("authInfo", authInfo);
        		//회원탈퇴에 사용할 세션값들
        		session.setAttribute("loginMemberNum", authInfo.getMemberNum());
     
        		session.setAttribute("loginMemberId", authInfo.getId());
        	
        		session.setAttribute("loginMemberPw", authInfo.getPassword());
        		//session.setMaxInactiveInterval(60*60);
        		logger.info("환영합니다. " + authInfo.getId() + "님/");
        	
        		//.resignChk = DEL_MEMBER TABLE을 조회하여 탈퇴 진행회원인지 판단한다.
            	// 1 = 탈퇴 진행중 / 0 = 정상적인 회원 memberService.resignChk(authInfo) 값을 대조
            	
            	//로그인 이전, 세션을 요청하여 탈퇴 진행 회원 여부를 판단;
            	session.setAttribute("resignchk", memberService.resignChk(authInfo));
            	logger.info("null이면 일반회원 / 그외에는 탈퇴진행회원 : " + session.getAttribute("resignchk"));
        		
    			  url = "redirect:/";
        		  
        		  
        		//////
        	    	//아이디 기억하기 체크값이 존재할 때 
        	    	if(req.getParameter("idRemember") != null ) {
        	    	
        	    		logger.info("아이디 기억을 체크 확인 ");
        	    		Cookie myCookieId = new Cookie("myCookieId", authInfo.getId());
        	    		myCookieId.setPath("/");
        	    		logger.info( "쿠키아이디 저장 : " + myCookieId.getValue());
        	    		 int amount =60 *60 *24 *7;
        	                myCookieId.setMaxAge(amount);// 단위는 (초)이며, 7일정도로 유효시간을 설정해 준다.
        	                // 쿠키를 적용해 준다.
        	                resp.addCookie(myCookieId);
        	                //test는 추후 로그인 후 다시 로그인창에 접속했을 때, 로그인/비로그인 회원을 구문해주기 위해 세션에 저장한것 ;
        	                session.setAttribute("test", myCookieId.getValue());
        	                
        	}else {
        		
        		session.removeAttribute("test");
        	logger.info("체크값이 해제된 상태로 로그인한 상태임 ");
        	Cookie cookie = new Cookie("myCookieId", null);
        	cookie.setPath("/");
        	cookie.setMaxAge(0);
        	resp.addCookie(cookie);
        	logger.info("체크값이 해제 되었으니 아이디 쿠키값은 ? : " + cookie.getValue());
        		
        	}
        		  
        		  //이제 인터셉터에서, prehandle 사용하여서 /login에 우선접근할때 idRemeber값을 가지고
        	    	//체크가 되어있을때는 체크박스 값을 체크로 바꿔주고, 아이디 value도 저장된 아이디로 넣어준다.
        		  

        	}else {
        		//입력 암호가 일치하지 않을때;
        		
        		//모종의 이유로 인해 로그인이 실패할 경우, loginSession에 null값을 저장
        		session.setAttribute("authInfo", null);
        		
        		rttr.addFlashAttribute("msg", false);
        		logger.info("로그인이 실패했습니다. ");
        		url = "redirect:/login/";
        		
        	}
    		
    	}
    	else 
    	{
    		//입력한 아이디와 일치하는 값이 없을 때;
    		
    		//모종의 이유로 인해 로그인이 실패할 경우, loginSession에 null값을 저장
    		session.setAttribute("authInfo", null);
    		
    		rttr.addFlashAttribute("msg", false);
    		logger.info("로그인이 실패했습니다. ");
    		url = "redirect:/login/";
    		
    		
    	}
    	
    	return url;

    	
}
    	
    	
    	
    	
    	

    		
    
    
    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp)throws Exception{
    	
    	
    	req.getSession();
    	//로그인 페이지에서의 체크박스값 
    	String idRemember = req.getParameter("idRemember");
    

    	/*
    	//아이디 기억 체크박스가 on되어있으면 로그인된 세션만 삭제해주고, 체크박스 값이 off일 경우, 쿠키와 로그인세션 모두를 삭제해준다.
    	if(session.getAttribute("test") != null) {
    		
    		session.invalidate();
    		
    	}else {
    		//session.removeAttribute("authInfo");
    		//session.removeAttribute("test");
    		session.invalidate();
    		logger.info("저장된 아이디는 없는 상태임 ");
    		Cookie cookie = new Cookie("myCookieId", null);
    		cookie.setPath("/");
    		cookie.setMaxAge(0);
    		resp.addCookie(cookie);
    	}

		*/
    	
    	session.invalidate();

    	return "redirect:/";
    	
    }
    
 	
	
}
