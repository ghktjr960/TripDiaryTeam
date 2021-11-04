  package org.project.regist.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.project.api.KakaoApi;
import org.project.regist.commons.AuthInterceptor;
import org.project.regist.service.MemberService;
import org.project.regist.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/regist/*")
public class RegistController {

	@Autowired
	private KakaoApi kakao;
	
	@Inject
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	private MemberService memberService;
	

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	  
	
	@Inject
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
    
    ///Regist Part                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
    
	//약관동의 (일반)
	//일반 회원가입을 통해 약관에 들어왔을 때
	@RequestMapping(value = "/termsN", method = RequestMethod.GET)
    public  String registStep1(String agree, HttpSession session) throws Exception {
		
		
		logger.info("일반회원가입 절차 : ");
		//로그인 상태인지 확인
		if(session.getAttribute("authInfo") == null) {
	        
			//로그인 상태가 아니므로 회원가입 페이지로 넘겨줌
			//일반/간편 회원가입 구분을 위한 세션값(type) 저장 (normal : 일반 / api : 간편) 
			session.setAttribute("type", "normal");
			
			System.out.println("약관 type : " + session.getAttribute("type"));
			
			return "/regist/terms";
			
	    	
	    	}else {
	    		
	    		logger.info("로그인 상태이므로 접근 불가");
	    		
	    		return "redirect:../";
	    	}
		
	}
	
	
	//약관동의 (간편)
		@RequestMapping(value = "/termsA", method = RequestMethod.GET)
	    public  String registStep1_1(String agree, HttpSession session ) throws Exception {
			
			
			if(session.getAttribute("authInfo") == null) {
		        
				
				//로그인 상태가 아니므로 회원가입 페이지로 넘겨줌
				//일반/간편 회원가입 구분을 위한 세션값(type) 저장 (normal : 일반 / api : 간편) 
				session.setAttribute("type", "api");
				
				System.out.println("약관 type : " + session.getAttribute("type"));
				
				return "/regist/terms";
			
			
		    	
		    	}else {
		    		return "redirect:../";
		    	}
			

			
		}
	
	
    
		//약관동의
    
    @RequestMapping(value = "/terms", method = RequestMethod.POST)
    public  String registStep2(String agree, HttpSession session) throws Exception {
    	//체크박스 value인 agree 선택여부
    	if(agree == null) {
    		System.out.println("약관동의 안누른상태 ");
    	return "/regist/terms";
    	
    	}else {
    		
    		session.setAttribute("agree", agree);
    		System.out.println("약관동의 등록됨 " + agree);
    		
    		
    		return "/regist/registPage";
    	}
    }
    
    
    
    //회원가입 페이지 
    @RequestMapping(value = "/registPage", method = RequestMethod.GET)
    public String registget(HttpSession session) throws Exception {
    
    	
    	if(session.getAttribute("AuthInfo") == null && session.getAttribute("agree") == "true" ) {
        
    	return "/regist/registPage";
    	
    	}else {
    		return "redirect:../";
    	}
    	
    	
    	}
  
    //최종 회원가입 처리 
    @RequestMapping(value = "/registPage", method = RequestMethod.POST)
    public String registpost(@Valid MemberVo memberVo, HttpSession session, Model model, BindingResult bindingResult) throws Exception {
    	
    	
    if(bindingResult.hasErrors()) {
    	
    	return "/regist/registPage";
    	
    }else {
    	
    	if(session.getAttribute("AuthInfo") == null) {
    	
    	
    	int idchk = memberService.idChk(memberVo);
    	int nickchk = memberService.nickChk(memberVo);
    	int emailchk = memberService.emailChk(memberVo);
    	
    
    		if(idchk == 1 || nickchk == 1 || emailchk == 1) {
    			//아이디 중복이 검출되어 리다이렉트 
    			System.out.println("중복 존재합니다. ");
    			return "/regist/registPage";
    			
    		}else if(idchk == 0 && nickchk == 0 && emailchk == 0) {
    			//아이디 중복이 없으므로 DB진행 
    			System.out.println("데이터 입력중 ");
    			
    			
    			//암호화 하는 과정
    			String encodePw = pwEncoder.encode(memberVo.getPassword());
    			memberVo.setPassword(encodePw);
    			
    		
    			memberService.regist(memberVo);
    			
    			logger.info("멤버번호 : " + memberVo.getMemberNum());
    			
    			session.setAttribute("registInfo", memberVo);
    			
    			logger.info("회원가입 ??" + session.getAttribute("registInfo"));
    			
    			memberService.registAdd();
    			memberService.registAddP();
    			
    			session.removeAttribute("registInfo");
    			
    			System.out.println("데이터 입력 완료 ");
    			System.out.println(memberVo.getEmail());
    		}
    	
    	
    	return "redirect:/login/";
    	}else {
    	
    	return "redirect:../";
    	}
    }
    
    }
    
    
    //여기여기 
    @RequestMapping(value="/kakaologout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        String access_Token = (String)session.getAttribute("access_Token");
    
        
        if(access_Token != null && !"".equals(access_Token)){
            kakao.kakaoLogout(access_Token);
            session.removeAttribute("access_Token");
            session.removeAttribute("userId");
        }else{
        	kakao.kakaoLogout(access_Token);
            System.out.println("access_Token is null");
            session.removeAttribute("access_Token");
            session.removeAttribute("userId");
            session.removeAttribute("email");
            session.removeAttribute("nickname");
            session.removeAttribute("gender");
            session.removeAttribute("birth");
            
            
            //return "redirect:/";
        }
        //return "index";
        return "redirect:/";
    }
    
    //여기여기 
    
    
    
    //카카오 API 간편 회원가입
    @RequestMapping(value="/registKakao")
    public String login(@RequestParam("code") String code, HttpSession session) throws Exception{
        String access_Token = kakao.getAccessToken(code);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);
      
        session.setAttribute("email", userInfo.get("email"));
        session.setAttribute("nickname", userInfo.get("nickname"));
        session.setAttribute("gender", userInfo.get("gender"));
        session.setAttribute("birth", userInfo.get("birthday"));
        	
        
     
        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
           
        }
        
        
        kakao.kakaoLogout((String)session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        
        System.out.println("필요한 정보만 가져온 후, 로그아웃처리하기 " + session.getAttribute("access_Token"));
        
        session.setAttribute("type", "api");
        
        System.out.println("현재 저장된 type : " + session.getAttribute("type"));
        
        return "regist/terms";
    }
    
    
    //아이디 중복확인
    // 중복값을 조회하여 결과값이 0 : 중복없음, 그외 : 중복 확인;
    @ResponseBody
    @RequestMapping(value="/idChk", method = RequestMethod.POST)
    public int idChk(MemberVo memberVo) throws Exception{
    	
    	int idchk = memberService.idChk(memberVo);
 
    	System.out.println("아이디 중복체크" + idchk);
    	return idchk;
    }
    

  //닉네임 중복확인
    // 중복값을 조회하여 결과값이 0 : 중복없음, 그외 : 중복 확인;
    @ResponseBody
    @RequestMapping(value="/nickChk", method = RequestMethod.POST)
    public int nickChk(MemberVo memberVo) throws Exception{
    	
    	int nickchk = memberService.nickChk(memberVo);
 
    	System.out.println("닉네임중복확인 " + nickchk);
    	System.out.println(memberVo.getNickname());
    	return nickchk;
    	
    }
    
    
  //이메일 중복확인
    // 중복값을 조회하여 결과값이 0 : 중복없음, 그외 : 중복 확인;
    @ResponseBody
    @RequestMapping(value="/emailChk", method = RequestMethod.POST)
    public int emailChk(MemberVo memberVo, Model model) throws Exception{
    	
    	int emailchk = memberService.emailChk(memberVo);
 
    	System.out.println("닉네임중복확인 " + emailchk);
    	System.out.println(memberVo.getEmail());
    	//model.addAttribute("findMyID", memberService.findId(memberVo).getId());
    	return emailchk;
    	
    }
    
    	
}
