package org.project.regist.controller;

import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.regist.commons.AuthInterceptor;
import org.project.regist.service.MemberService;
import org.project.regist.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/member/*")
public class MemberController {

	

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	  
	
	@Autowired
	private MemberService memberService;
	
	@Inject
	BCryptPasswordEncoder pwEncoder;
	
	
	//마이 페이지
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGet( MemberVo memberVo) throws Exception {
   

    	logger.info("get 마이 페이지 출력합니다.");
    	return "/MH/myPage";
    }
	
  //마이 페이지
    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage( MemberVo memberVo) throws Exception {
   

    	logger.info("get 마이 페이지 출력합니다.");
    	return "/MH/myPage";
    }
	
    //회원정보 수정 페이지 
    @RequestMapping(value = "/infoUpdate", method = RequestMethod.GET)
    public String infoUpdateGET() throws Exception{
    	
    	return "/regist/infoUpdate";
    }
    
    //회원정보 수정 요청
    @RequestMapping(value = "/infoUpdate", method = RequestMethod.POST)
    public String infoUpdatePOST(MemberVo memberVo, HttpSession session) throws Exception{
    	
    	
    	memberService.infoUpdate(memberVo);
    	
    	session.invalidate();
    	
    	return "redirect:/";
    }
    
    //비밀번호 변경 페이지 
    @RequestMapping(value = "/pwUpdate", method = RequestMethod.GET)
    public String pwUpdateGET() throws Exception{
    	
    	return "/regist/pwUpdate";
    }
    
    //비밀번호 수정 요청
    @RequestMapping(value = "/pwUpdate", method = RequestMethod.POST)
    public String pwUpdatePOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession();
    	
    	String loginMemberPw = (String) session.getAttribute("loginMemberPw");
    	String oldpw = req.getParameter("oldpassword"); //기존 비밀번호 확인값
    	String newpw = req.getParameter("password"); //변경하려는 비밀번호
    	String newpwchk = req.getParameter("passwordchk"); //변경하려는 비밀번호 확인값
    	
    	
    	
    	//암호화된 비밀번호와 입력 비밀번호를 확인하는 작업(입력된 비밀번호, DB비밀번호)
    	boolean pwMatch = pwEncoder.matches(oldpw, loginMemberPw);
    	
    	if(pwMatch == true) {
    	//입력한 새 비밀번호가 확인 비밀번호와 일치하는지 확인작업;
    	if(newpw.equals(newpwchk)) {
    		
    	
    		logger.info("서로 일치합니다.");
    		
    		
    		//암호화 하는 과정
			String encodePw = pwEncoder.encode(newpw);
			memberVo.setPassword(encodePw);
   	
    		memberService.pwUpdate(memberVo);
    	
    	session.invalidate();
    	rttr.addFlashAttribute("msg", true);
    	return "redirect:/";
    	
    		
    		
    	}else {
    	
    		
    	
    	logger.info("비밀번호가 다른데?");
		rttr.addFlashAttribute("msg", false);
		return "redirect:/";
    	
    	
    	}
    	
    	}else {
    		
    		logger.info("비밀번호가 다른데?");
    		rttr.addFlashAttribute("msg", false);
    		return "redirect:/";
    		
    		
    	}
    	

    	
    }
    
    //회원탈퇴 요청 페이지
    @RequestMapping(value = "/resign", method = RequestMethod.GET)
    public String resignGET() throws Exception{
    	
    	return "/regist/resign";
    }
    
    
  //회원탈퇴 요청 처리
    @RequestMapping(value = "/resign", method = RequestMethod.POST)
    public String resignPOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession(); 	
    	
    	//로그인 당시 저장해둔 세션값(loginMemberPw)을 가져와서 비교한다. 
    	String pw = (String) session.getAttribute("loginMemberPw");
    	String pwchk = req.getParameter("passwordchk");
    	String chk = req.getParameter("resignchk");
    	
    	
    	//암호화된 비밀번호와 입력 비밀번호를 확인하는 작업(입력된 비밀번호, DB비밀번호)
    	boolean pwMatch = pwEncoder.matches(pwchk, pw);
    	
    	
    	//비밀번호가 일치하고, null값이 아닐때 
    	if(pwMatch == true &&  chk != null) {
    		
    		logger.info("회원세션값 호출 : " + session.getAttribute("authInfo"));
    		logger.info("비밀번호 일치");
    		
    		//암호가 일치하므로, 회원탈퇴를 진행
			memberService.resign((MemberVo)session.getAttribute("authInfo"));
			
    		return "redirect:/login/logout";
    		
    	}else {
    		
   		return "redirect:/member/resign";

    	}
    	
    	
    }
    
  //회원탈퇴 철회 페이지
    @RequestMapping(value = "/resigncancel", method = RequestMethod.GET)
    public String resignCancelGET() throws Exception{
    	
    	return "/regist/resigncancel";
    }
    

  //회원탈퇴 철회 요청
    @RequestMapping(value = "/resigncancel", method = RequestMethod.POST)
    public String resignCancelPOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession(); 	
    	
    	//로그인 당시 저장된 암호 세션값을 호출하여 대조
    	String pw = (String) session.getAttribute("loginMemberPw");
    	String pwchk = req.getParameter("passwordchk");
  
    	
    	//암호화된 비밀번호와 입력 비밀번호를 확인하는 작업(입력된 비밀번호, DB비밀번호)
    	boolean pwMatch = pwEncoder.matches(pwchk, pw);
    	
  
    	
    	//암호가 일치할 경우
    	if(pwMatch == true) {
    		
    		logger.info("로그인 회원 정보 : " + session.getAttribute("authInfo"));
    		logger.info("비밀번호 일치");
    		
			memberService.resignCancel((MemberVo)session.getAttribute("authInfo"));
			
			session.removeAttribute("resignchk");
			
    		return "redirect:/login/logout";
    		
    	}else {
    		

    		return "redirect:/member/resigncancel";
    		
    		
    	}
    	
    
    }
    
    
  //아이디 찾기
    @RequestMapping(value = "/findId", method = RequestMethod.GET)
    public String findIdGET() throws Exception{
    	
    	return "regist/findId";
    }
    
    
    
    //아이디 찾기
    @ResponseBody
    @RequestMapping(value="/findId", method = RequestMethod.POST)
    public String findId(MemberVo memberVo, Model model, HttpServletResponse resp) throws Exception{
    	
   
    	// 입력한 이메일과 일치하는 memberVo 값을 가져와서 findId에 저장;
    	MemberVo findId = memberService.findId(memberVo);
    	//위에서 저장한 findId에서 ID값만 추출해오기;
    	//* 참고사항 : ID min = 2 / max = 20임 
    	String findmyId = "";
    	
    	if(findId == null) {
    		
    		findmyId = "none";
    		
    	}else {
    	
    	findmyId = (String)findId.getId();
    	
    	
    	
    	{
        	//가입 닉네임이 5글자 미만일때
        	if(findmyId.length() < 5) {
        	
        	//2번째부터 해당 닉네임 끝까지 * 마스킹	
        	findmyId = findmyId.replaceAll("(?<=.{2})." , "*");
        		
        		//가입 닉네임이 10글자 이상일때
        	}else{
        		
        		//4번째부터 해당 닉네임 끝까지 * 마스킹
        		findmyId = findmyId.replaceAll("(?<=.{4})." , "*");
        		
        	}
        	
        	}
    	
    	
    	}
    	
    	//memberVo에서 받은 값;
    	System.out.println(findId);
    	
    	//memberVo에서 id값만 추출한것;
    	System.out.println(findmyId);
    	
    	if(findmyId != null) {
    	
    	System.out.println("닉네임중복확인 " + findmyId);
    	System.out.println(memberService.findId(memberVo));
    	}else {
    		
    		System.out.println("일치항목 없음 " + findmyId);
    		
    	}
    	
    	return findmyId;
    	
    }
  
    
    
    
    
    
}
