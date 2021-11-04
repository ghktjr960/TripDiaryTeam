package com.tripdiary.HSservice;

import com.tripdiary.HSvo.MemberVo;

public interface SignInOutService {

	// 세션 확인용 테스트 코드 삭제해야됨
	public MemberVo memberLoginTest(String id) throws Exception;
	
}
