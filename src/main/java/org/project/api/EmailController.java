package org.project.api;

import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mail/*")
public class EmailController {
		
		@Autowired
		private EmailSend emailSend;
		@Autowired
		private MemberService memberService;
		
		//암호화기능
		@Inject
		BCryptPasswordEncoder pwEncoder;
		
		
		
		private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
		  
		
		
		//인증번호 생성
		 private String getRandomCode() {
		        Random random = new Random();
		        int num = random.nextInt(4589362) + 49311;
		        String key = Integer.toString(num);
		   
		        return key;
		    }
		
		 //인증번호 발송절차 
		@ResponseBody
		@RequestMapping(value="/mailsend",method=RequestMethod.POST)
		public String mailsend(MemberVo memberVo, HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws Exception{
			String key = getRandomCode(); //발송된 랜덤 번호;
			
			emailSend.sendEmail(memberVo, key);
			
			
			Cookie chkcookie = new Cookie("key", key);
			chkcookie.setMaxAge(60*3); //3분짜리 인증번호를 발송
			
			resp.addCookie(chkcookie);
			//인증번호를 세션대신 쿠키에 저장하기
			//session.setAttribute("key", key);
			chkcookie.getValue();
			logger.info(chkcookie.getValue() + "이게바로 쿠키에 저장된 인증번호값");
			return key;
		

		}
		
		
		
		//인증번호 확인절차 
		@ResponseBody
		@RequestMapping(value="/mailsendChk",method=RequestMethod.POST)
		public int mailsendChk(String emailchk,HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws Exception{
			
		
			String key = "";
			Cookie[] cookies = req.getCookies();

			if(cookies != null && cookies.length > 0 ){
				for(int i=0; i<cookies.length; i++){
					if(cookies[i].getName().equals("key")){
						
						key = cookies[i].getValue();
								
					}
				}
				
				
				
			}

			


			//String key = (String)req.getAttribute("key");//발송된 랜덤 번호;
		
			if(key.equals(emailchk)) {
				//System.out.println("인증번호 동일하네요 : " + emailchk);
				return 0;
			}else
				return 1;
			}

		
		
		 //임시 비밀번호 발송절차 
		@ResponseBody
		@RequestMapping(value="/tmpPwsend",method=RequestMethod.POST)
		public String tmpPwsend(MemberVo memberVo, HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws Exception{
			
		   	// 입력한 이메일, ID가 일치하는 memberVo를 호출하여 저장해줌;
	    	MemberVo findPw = memberService.findId(memberVo);
	    	
    	
	    	String tmpPw =" ";
	    	
	    	//입력한 값과 동일한 데이터가 없을 때;
	    	if(findPw == null) {
	    		
	    		tmpPw = "none";
	 
	    	}else {
	    	
	    	//입력값과 일치하는 값이 존재할 때;
	    	tmpPw = (String)findPw.getPassword();
	    	
	    	//가져온 Pw를 랜덤 문자 + 숫자 형태로 바꾸어서 메일로 보내주기
	    	
	    	Random rnd =new Random();

	    	StringBuffer buf =new StringBuffer();

	    	for(int i=0;i<10;i++){

	    	    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.

	    	    if(rnd.nextBoolean()){

	    	        buf.append((char)((int)(rnd.nextInt(26))+97));

	    	    }else{

	    	        buf.append((rnd.nextInt(10)));

	    	    }

	    	}
	    	
	    	tmpPw = "" + buf;
	    	
	    	String encodedPw = pwEncoder.encode(tmpPw);
	    	
	    	logger.info("변경된 비밀번호"  +  tmpPw);  	
	    	logger.info("암호화된 변경 비밀번호"  + encodedPw);  	
	    	
	    	
	    	
	    	logger.info(encodedPw + "이게 바로 임시번호 발송직전");
	    	memberVo.setPassword(encodedPw);
	    	logger.info((String)memberVo.getPassword() + "비밀번호가 바뀌었나??");
	    	memberService.pwUpdate(memberVo);
	    	emailSend.sendtmpPw(memberVo, tmpPw);

	    	
	    	}
	    	

	    	return tmpPw;
	    	


		}
}

		
		
		
