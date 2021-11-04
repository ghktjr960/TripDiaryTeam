package org.project.regist.service;

import java.util.Date;

import org.project.regist.vo.LoginVo;
import org.project.regist.vo.MemberVo;
import org.project.regist.vo.ResignVo;
import org.springframework.stereotype.Service;


public interface MemberService {
	

	
	MemberVo login(MemberVo memberVo) throws Exception;

	//아이디 중복 확인
	int idChk(MemberVo memberVo) throws Exception;
	
	
	//닉네임 중복 확인 
	int nickChk(MemberVo memberVo) throws Exception;
	
	
	//이메일 중복 확인 
	int emailChk(MemberVo memberVo) throws Exception;

	//회원정보 수정
	public void infoUpdate(MemberVo memberVo) throws Exception;
	
	//암호 수정 
	public void pwUpdate(MemberVo memberVo) throws Exception;
	
	//회원가입
    void regist(MemberVo memberVo) throws Exception;

    public void resign(MemberVo memberVo) throws Exception;
    
    
    //회원 탈퇴 신청 여부 확인
    ResignVo resignChk(MemberVo memberVo) throws Exception;
    
    
    //회원탈퇴 철회 요청
    public void resignCancel(MemberVo memberVo) throws Exception;
    
    //아이디 찾기
    MemberVo findId(MemberVo memberVo) throws Exception;

    
    //비밀번호 찾기
   
    MemberVo findPw(MemberVo memberVo) throws Exception;
    
    
    //회원가입 성공시 추가해주는 테이블
    
    void registAdd() throws Exception;
    
    
    //회원가입 성공시 회원 프로필 이미지에 추가해주는 테이블
    
    void registAddP() throws Exception;
    
    

}
