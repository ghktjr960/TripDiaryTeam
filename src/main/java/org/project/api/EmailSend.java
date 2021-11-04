package org.project.api;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.project.regist.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSend {
	
		@Autowired
		private JavaMailSender mailSender;
		
		MemberVo memberVo;
		
	
		//회원가입 메일 인증 번호 발송
		public void sendEmail(MemberVo memberVo, String key) throws Exception{
			//메일 발송 기능 제공
			MimeMessage msg = mailSender.createMimeMessage();		
 
			msg.setSubject("안녕하세요 회원가입 인증메일 입니다. ");
			//msg.setSubject(emailFomr.getSubject()); //메일 제목
			msg.setText("인증번호는 : " + key + "입니다.");
			msg.setRecipient(RecipientType.TO, new InternetAddress(memberVo.getEmail()));
			mailSender.send(msg);
		}
	



	//임시 비밀번호 발송
	public void sendtmpPw(MemberVo memberVo, String tmpPw) throws Exception{
	//메일 발송 기능 제공
	MimeMessage msg = mailSender.createMimeMessage();		
	String id = memberVo.getId();
	
	msg.setSubject("안녕하세요" + id + "회원님 ");
	//msg.setSubject(emailFomr.getSubject()); //메일 제목
	msg.setText("요청하신 임시 비밀번호는 " + tmpPw + "입니다.");
	msg.setRecipient(RecipientType.TO, new InternetAddress(memberVo.getEmail()));
	mailSender.send(msg);
}
}