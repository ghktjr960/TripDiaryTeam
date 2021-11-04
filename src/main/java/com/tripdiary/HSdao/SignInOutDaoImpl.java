package com.tripdiary.HSdao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.HSvo.MemberVo;

@Repository
public class SignInOutDaoImpl implements SignInOutDao{

	@Inject
	private SqlSession sqlSession;

	// 세션 확인용 테스트 코드 삭제해야됨
	@Override
	public MemberVo memberLoginTest(String id) throws Exception {
		return sqlSession.selectOne("signInOutMapper.memberloginTest", id);
	}
	
}
