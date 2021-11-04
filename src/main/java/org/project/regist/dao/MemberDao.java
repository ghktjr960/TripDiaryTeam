package org.project.regist.dao;

import java.util.Date;

import org.project.regist.vo.LoginVo;
import org.project.regist.vo.MemberVo;
import org.project.regist.vo.ResignVo;



public interface MemberDao {

	// 로그인 처리
    MemberVo login(MemberVo memberVo) throws Exception;

    // 회원가입 처리
    void regist(MemberVo memberVo) throws Exception;

    //이메일 중복 확인 
    int emailChk(MemberVo memberVo) throws Exception;
    
    //아이디 중복 확인 
    int idChk(MemberVo memberVo) throws Exception;
    
    //닉네임 중복 확인 
    int nickChk(MemberVo memberVo) throws Exception;
    
    // 회원정보 수정처리
    void infoUpdate(MemberVo memberVo) throws Exception;
    
    // 회원 비밀번호 수정
    void pwUpdate(MemberVo memberVo) throws Exception;
	
    //회원 탈퇴 신청
    void resign(MemberVo memberVo) throws Exception;
    
    //회원 탈퇴 철회 신청
    void resignCancel(MemberVo memberVo) throws Exception;
    
    
    //아이디 찾기
    MemberVo findId(MemberVo memberVo) throws Exception;
    
    
    //비밀번호 찾기
    MemberVo findPw(MemberVo memberVo) throws Exception;
    
    
    //회원탈퇴 신청 여부
    ResignVo resignChk(MemberVo memberVo) throws Exception;
 
    
    //회원가입시 부수적으로 추가되는 테이블들
    //멤버 활동 테이블 추가
    void registAdd() throws Exception;
    //회원 프로필 이미지 테이블 추가
    void registAddP() throws Exception;
    
    
	
	
}
