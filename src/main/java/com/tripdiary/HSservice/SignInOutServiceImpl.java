package com.tripdiary.HSservice;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.HSdao.SignInOutDao;
import com.tripdiary.HSvo.MemberVo;

@Service
public class SignInOutServiceImpl implements SignInOutService{

	@Inject
	private SignInOutDao signInOutDao;
	
	// 세션 확인용 테스트 코드 삭제해야됨
	@Override
	public MemberVo memberLoginTest(String id) throws Exception {
		return signInOutDao.memberLoginTest(id);
	}
	
}
