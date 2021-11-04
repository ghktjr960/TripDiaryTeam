package org.project.regist.dao;

import javax.inject.Inject;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.apache.ibatis.session.SqlSession;
import org.project.regist.vo.MemberVo;
import org.project.regist.vo.ResignVo;
import org.springframework.stereotype.Repository;

@Repository 
public class MemberDaoImpl implements MemberDao {

	  private static final String NAMESPACE = "org.project.regist.mappers.member.memberMapper";

	    private SqlSession sqlSession;

	    @Inject
	    public MemberDaoImpl(SqlSession sqlSession) {
	        this.sqlSession = sqlSession;
	    }

	    

	    
	    // 회원가입 처리 
	    @Override
	    public void regist(MemberVo memberVo) throws Exception {
	    	
	        sqlSession.insert(NAMESPACE + ".regist", memberVo);
	    }
	    

	    //아이디 중복 확인 
	    @Override
	    public int idChk(MemberVo memberVo) throws Exception{
	    	int idchk = sqlSession.selectOne(NAMESPACE + ".idchk", memberVo);
	    	return idchk;
	    }
	    
	    //닉네임 중복 확인 
	    @Override
	    public int nickChk(MemberVo memberVo) throws Exception{
	    	int nickchk = sqlSession.selectOne(NAMESPACE + ".nickchk", memberVo);
	    	return nickchk;
	    }
	    
	    
	    //회원 탈퇴 신청 여부 확인
	    @Override
	    public ResignVo resignChk(MemberVo memberVo) throws Exception{
	    	
	    	return sqlSession.selectOne(NAMESPACE + ".resignchk", memberVo); 
	    	
	    	
	    }
	    
	    
	 // 회원 탈퇴 철회 신청
	    @Override
	    public void resignCancel(MemberVo memberVo) throws Exception{
	    	
	    	sqlSession.delete(NAMESPACE + ".resignCancel", memberVo);
	    	
	    };
	    
	    
	    //
	    public int emailChk(MemberVo memberVo) throws Exception{
	    	
	    	int emailchk = sqlSession.selectOne(NAMESPACE + ".emailchk", memberVo);
	    	return emailchk;
	    }
	    
	    

	    // 로그인 처리
	    @Override
	    public MemberVo login(MemberVo memberVo) throws Exception {
	        
		    return sqlSession.selectOne(NAMESPACE + ".login", memberVo);
		  
	    
	    }

	    //회원정보 수정
	    @Override
	    public void infoUpdate(MemberVo memberVo) throws Exception {
	        sqlSession.update(NAMESPACE + ".InfoUpdate", memberVo);
	    }

	    //암호 변경
	    @Override
	    public void pwUpdate(MemberVo memberVo) throws Exception {
	        
	        sqlSession.update(NAMESPACE + ".pwUpdate", memberVo);
	        
	    }
	    
	    
	    // 회원 탈퇴 신청
	    @Override
	    public void resign(MemberVo memberVo) throws Exception{
	    	
	    	sqlSession.insert(NAMESPACE + ".resign", memberVo);
	    	
	    };
	    
	    
	    //아이디 찾기
	    @Override
	    public MemberVo findId(MemberVo memberVo) throws Exception{
	    	
	    	return sqlSession.selectOne(NAMESPACE + ".findId", memberVo);
	    	
	    	
	    };
	    

	    
	  //비밀번호 찾기
	    @Override
	    public MemberVo findPw(MemberVo memberVo) throws Exception{
	    	
	    	return sqlSession.selectOne(NAMESPACE + ".findPw", memberVo);
	    	
	    }
	    
	    
	    
	    @Override
	    public void registAdd() throws Exception{

	  	  //회원가입시 멤버 활동 테이블 추가
	    	sqlSession.insert(NAMESPACE +".registAdd", new MemberVo());

	    	
	    	
	    }
	
	    
	    @Override
	    public void registAddP() throws Exception{
	    	
	  	  //회원가입시 멤버 활동 테이블 추가
	    	sqlSession.insert(NAMESPACE +".registAddP", new MemberVo());

	    	
	    	
	    	
	    }

	    
	
	
	
}
