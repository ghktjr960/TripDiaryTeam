package org.project.regist.service;

import org.project.regist.dao.MemberDao;
import org.project.regist.vo.MemberVo;
import org.project.regist.vo.ResignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemberServiceImpl implements MemberService {

	
		private  MemberDao memberDao;

		@Autowired
	    public MemberServiceImpl(MemberDao memberDao) {
	        this.memberDao = memberDao;
	    }
		
		
	    @Override
	    public void regist(MemberVo memberVo) throws Exception {
	        memberDao.regist(memberVo);
	        
	        System.out.println("맴버 번호 확인"+memberVo.getMemberNum());
	    }
	    
	    @Override
	    public int idChk(MemberVo memberVo) throws Exception{
	
	    	int idchk = memberDao.idChk(memberVo);
	    	return idchk;
	    	
	    }
	    
	    @Override
	    public int nickChk(MemberVo memberVo) throws Exception{
	
	    	int nickchk = memberDao.nickChk(memberVo);
	    	return nickchk;
	    	
	    }
	    @Override
	    public int emailChk(MemberVo memberVo) throws Exception{
	    	
	    	int emailchk = memberDao.emailChk(memberVo);
	    	return emailchk;
	    	
	    }
	    
	    
	    @Override
	    public MemberVo login(MemberVo memberVo) throws Exception {
	        return memberDao.login(memberVo);
	    }

	    //회원정보 수정
	    @Override
	    public void infoUpdate(MemberVo memberVo) throws Exception {
	    	
	    	memberDao.infoUpdate(memberVo);
	    	
	    }
	    
	    //비밀번호 변경
	    @Override
	    public void pwUpdate(MemberVo memberVo) throws Exception{
	    	
	    	memberDao.pwUpdate(memberVo);
	    	
	    }
	    
	    // 회원 탈퇴 신청
	    @Override
	    public void resign(MemberVo memberVo) throws Exception{
	    	
	    	memberDao.resign(memberVo);
	    	
	    }
	
	    
	    //회원 탈퇴 신청 여부 확인
	    @Override
	    public ResignVo resignChk(MemberVo memberVo) throws Exception {
	    	
	    	return memberDao.resignChk(memberVo);
	    
	    }

	    //회원탈퇴 철회기능
	    @Override
	    public void resignCancel(MemberVo memberVo) throws Exception{
	    	
	    	memberDao.resignCancel(memberVo);
	    	
	    }
	    
	    //아이디 찾기
	    @Override
	    public MemberVo findId(MemberVo memberVo) throws Exception{
	    	
	    	return memberDao.findId(memberVo);
	    	
	    }
	    
	    
	    
	    //비밀번호 찾기
	    @Override
	    public MemberVo findPw(MemberVo memberVo) throws Exception{
	    	
	    	return memberDao.findPw(memberVo);
	    	
	    }
	    
	    
	    //회원가입 성공시 추가해주는 테이블 쿼리
	    @Override
	    public void registAdd(MemberVo memberVo) throws Exception{
	    	
	    	memberDao.registAdd(memberVo);
	    	
	    }
	    //회원가입 성공시 회원 프로필 이미지 테이블에 데이터를 추가해주는 쿼리
	    @Override
	    public void registAddP(MemberVo memberVo) throws Exception{
	    	
	    	memberDao.registAddP(memberVo);
	    }
	    
	    
	    @Override
	    public void registAddPf(MemberVo memberVo) throws Exception{

	    	memberDao.registAddPf(memberVo);
	    }


	   public String profile(int memberNum) throws Exception{
		   String ProfileName = memberDao.findProfile(memberNum);

		   return ProfileName;
	   };
	    
	   
	    //회원신고횟수 추가
		   @Override
		   public void reportAdd(MemberVo memberVo) throws Exception{
			   
			   memberDao.reportAdd(memberVo);
		   }
		    
	   
}
