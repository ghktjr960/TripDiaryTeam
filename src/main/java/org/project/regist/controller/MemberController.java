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
	
	
	//留덉씠 �럹�씠吏�
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGet( MemberVo memberVo) throws Exception {
   

    	logger.info("get 留덉씠 �럹�씠吏� 異쒕젰�빀�땲�떎.");
    	return "/MH/myPage";
    }
	
  //留덉씠 �럹�씠吏�
    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage( MemberVo memberVo) throws Exception {
   

    	logger.info("get 留덉씠 �럹�씠吏� 異쒕젰�빀�땲�떎.");
    	return "/myPage";
    }
	
    //�쉶�썝�젙蹂� �닔�젙 �럹�씠吏� 
    @RequestMapping(value = "/infoUpdate", method = RequestMethod.GET)
    public String infoUpdateGET() throws Exception{
    	
    	return "/regist/infoUpdate";
    }
    
    //�쉶�썝�젙蹂� �닔�젙 �슂泥�
    @RequestMapping(value = "/infoUpdate", method = RequestMethod.POST)
    public String infoUpdatePOST(MemberVo memberVo, HttpSession session) throws Exception{
    	
    	
    	memberService.infoUpdate(memberVo);
    	
    	session.invalidate();
    	
    	return "redirect:/";
    }
    
    //鍮꾨�踰덊샇 蹂�寃� �럹�씠吏� 
    @RequestMapping(value = "/pwUpdate", method = RequestMethod.GET)
    public String pwUpdateGET() throws Exception{
    	
    	return "/regist/pwUpdate";
    }
    
    //鍮꾨�踰덊샇 �닔�젙 �슂泥�
    @RequestMapping(value = "/pwUpdate", method = RequestMethod.POST)
    public String pwUpdatePOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession();
    	
    	String loginMemberPw = (String) session.getAttribute("loginMemberPw");
    	String oldpw = req.getParameter("oldpassword"); //湲곗〈 鍮꾨�踰덊샇 �솗�씤媛�
    	String newpw = req.getParameter("password"); //蹂�寃쏀븯�젮�뒗 鍮꾨�踰덊샇
    	String newpwchk = req.getParameter("passwordchk"); //蹂�寃쏀븯�젮�뒗 鍮꾨�踰덊샇 �솗�씤媛�
    	
    	
    	
    	//�븫�샇�솕�맂 鍮꾨�踰덊샇�� �엯�젰 鍮꾨�踰덊샇瑜� �솗�씤�븯�뒗 �옉�뾽(�엯�젰�맂 鍮꾨�踰덊샇, DB鍮꾨�踰덊샇)
    	boolean pwMatch = pwEncoder.matches(oldpw, loginMemberPw);
    	
    	if(pwMatch == true) {
    	//�엯�젰�븳 �깉 鍮꾨�踰덊샇媛� �솗�씤 鍮꾨�踰덊샇�� �씪移섑븯�뒗吏� �솗�씤�옉�뾽;
    	if(newpw.equals(newpwchk)) {
    		
    	
    		logger.info("�꽌濡� �씪移섑빀�땲�떎.");
    		
    		
    		//�븫�샇�솕 �븯�뒗 怨쇱젙
			String encodePw = pwEncoder.encode(newpw);
			memberVo.setPassword(encodePw);
   	
    		memberService.pwUpdate(memberVo);
    	
    	session.invalidate();
    	rttr.addFlashAttribute("msg", true);
    	return "redirect:/";
    	
    		
    		
    	}else {
    	
    		
    	
    	logger.info("鍮꾨�踰덊샇媛� �떎瑜몃뜲?");
		rttr.addFlashAttribute("msg", false);
		return "redirect:/";
    	
    	
    	}
    	
    	}else {
    		
    		logger.info("鍮꾨�踰덊샇媛� �떎瑜몃뜲?");
    		rttr.addFlashAttribute("msg", false);
    		return "redirect:/";
    		
    		
    	}
    	

    	
    }
    
    //�쉶�썝�깉�눜 �슂泥� �럹�씠吏�
    @RequestMapping(value = "/resign", method = RequestMethod.GET)
    public String resignGET() throws Exception{
    	
    	return "/regist/resign";
    }
    
    
  //�쉶�썝�깉�눜 �슂泥� 泥섎━
    @RequestMapping(value = "/resign", method = RequestMethod.POST)
    public String resignPOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession(); 	
    	
    	//濡쒓렇�씤 �떦�떆 ���옣�빐�몦 �꽭�뀡媛�(loginMemberPw)�쓣 媛��졇���꽌 鍮꾧탳�븳�떎. 
    	String pw = (String) session.getAttribute("loginMemberPw");
    	String pwchk = req.getParameter("passwordchk");
    	String chk = req.getParameter("resignchk");
    	
    	
    	//�븫�샇�솕�맂 鍮꾨�踰덊샇�� �엯�젰 鍮꾨�踰덊샇瑜� �솗�씤�븯�뒗 �옉�뾽(�엯�젰�맂 鍮꾨�踰덊샇, DB鍮꾨�踰덊샇)
    	boolean pwMatch = pwEncoder.matches(pwchk, pw);
    	
    	
    	//鍮꾨�踰덊샇媛� �씪移섑븯怨�, null媛믪씠 �븘�땺�븣 
    	if(pwMatch == true &&  chk != null) {
    		
    		logger.info("�쉶�썝�꽭�뀡媛� �샇異� : " + session.getAttribute("authInfo"));
    		logger.info("鍮꾨�踰덊샇 �씪移�");
    		
    		//�븫�샇媛� �씪移섑븯誘�濡�, �쉶�썝�깉�눜瑜� 吏꾪뻾
			memberService.resign((MemberVo)session.getAttribute("authInfo"));
			
    		return "redirect:/login/logout";
    		
    	}else {
    		
   		return "redirect:/member/resign";

    	}
    	
    	
    }
    
  //�쉶�썝�깉�눜 泥좏쉶 �럹�씠吏�
    @RequestMapping(value = "/resigncancel", method = RequestMethod.GET)
    public String resignCancelGET() throws Exception{
    	
    	return "/regist/resigncancel";
    }
    

  //�쉶�썝�깉�눜 泥좏쉶 �슂泥�
    @RequestMapping(value = "/resigncancel", method = RequestMethod.POST)
    public String resignCancelPOST(MemberVo memberVo,HttpServletRequest req, HttpSession session, RedirectAttributes rttr) throws Exception{
    	
    	session = req.getSession(); 	
    	
    	//濡쒓렇�씤 �떦�떆 ���옣�맂 �븫�샇 �꽭�뀡媛믪쓣 �샇異쒗븯�뿬 ��議�
    	String pw = (String) session.getAttribute("loginMemberPw");
    	String pwchk = req.getParameter("passwordchk");
  
    	
    	//�븫�샇�솕�맂 鍮꾨�踰덊샇�� �엯�젰 鍮꾨�踰덊샇瑜� �솗�씤�븯�뒗 �옉�뾽(�엯�젰�맂 鍮꾨�踰덊샇, DB鍮꾨�踰덊샇)
    	boolean pwMatch = pwEncoder.matches(pwchk, pw);
    	
  
    	
    	//�븫�샇媛� �씪移섑븷 寃쎌슦
    	if(pwMatch == true) {
    		
    		logger.info("濡쒓렇�씤 �쉶�썝 �젙蹂� : " + session.getAttribute("authInfo"));
    		logger.info("鍮꾨�踰덊샇 �씪移�");
    		
			memberService.resignCancel((MemberVo)session.getAttribute("authInfo"));
			
			session.removeAttribute("resignchk");
			
    		return "redirect:/login/logout";
    		
    	}else {
    		

    		return "redirect:/member/resigncancel";
    		
    		
    	}
    	
    
    }
    
    
  //�븘�씠�뵒 李얘린
    @RequestMapping(value = "/findId", method = RequestMethod.GET)
    public String findIdGET() throws Exception{
    	
    	return "regist/findId";
    }
    
    
    
    //�븘�씠�뵒 李얘린
    @ResponseBody
    @RequestMapping(value="/findId", method = RequestMethod.POST)
    public String findId(MemberVo memberVo, Model model, HttpServletResponse resp) throws Exception{
    	
   
    	// �엯�젰�븳 �씠硫붿씪怨� �씪移섑븯�뒗 memberVo 媛믪쓣 媛��졇���꽌 findId�뿉 ���옣;
    	MemberVo findId = memberService.findId(memberVo);
    	//�쐞�뿉�꽌 ���옣�븳 findId�뿉�꽌 ID媛믩쭔 異붿텧�빐�삤湲�;
    	//* 李멸퀬�궗�빆 : ID min = 2 / max = 20�엫 
    	String findmyId = "";
    	
    	if(findId == null) {
    		
    		findmyId = "none";
    		
    	}else {
    	
    	findmyId = (String)findId.getId();
    	
    	
    	
    	{
        	//媛��엯 �땳�꽕�엫�씠 5湲��옄 誘몃쭔�씪�븣
        	if(findmyId.length() < 5) {
        	
        	//2踰덉㎏遺��꽣 �빐�떦 �땳�꽕�엫 �걹源뚯� * 留덉뒪�궧	
        	findmyId = findmyId.replaceAll("(?<=.{2})." , "*");
        		
        		//媛��엯 �땳�꽕�엫�씠 10湲��옄 �씠�긽�씪�븣
        	}else{
        		
        		//4踰덉㎏遺��꽣 �빐�떦 �땳�꽕�엫 �걹源뚯� * 留덉뒪�궧
        		findmyId = findmyId.replaceAll("(?<=.{4})." , "*");
        		
        	}
        	
        	}
    	
    	
    	}
    	
    	//memberVo�뿉�꽌 諛쏆� 媛�;
    	System.out.println(findId);
    	
    	//memberVo�뿉�꽌 id媛믩쭔 異붿텧�븳寃�;
    	System.out.println(findmyId);
    	
    	if(findmyId != null) {
    	
    	System.out.println("�땳�꽕�엫以묐났�솗�씤 " + findmyId);
    	System.out.println(memberService.findId(memberVo));
    	}else {
    		
    		System.out.println("�씪移섑빆紐� �뾾�쓬 " + findmyId);
    		
    	}
    	
    	return findmyId;
    	
    }
  
    
    
    
    
    
}
