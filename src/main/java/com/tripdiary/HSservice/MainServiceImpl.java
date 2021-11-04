package com.tripdiary.HSservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.HSdao.MainDao;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Service
public class MainServiceImpl implements MainService{
	
	@Inject
	private MainDao mainDao;
	
	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	@Override
	public List<MainBoardListVo> mainBoardList(PageVo pageVo) throws Exception {
		return mainDao.mainBoardList(pageVo);
	}
	
	// 전체 태그 목록 가져오기
	@Override
	public List<TagVo> mainTagList() throws Exception {
		return mainDao.mainTagList();
	}
	
	// 세션에 저장된 회원번호로 찜하기 눌렀는지 여부 확인
	@Override
	public List<PickVo> mainPickList(int memberNum) throws Exception {
		return mainDao.mainPickList(memberNum);
	}
	
	// 각 회원마다 프로필 이미지 가져오기
	@Override
	public ProfileImgVo profileImg(int memberNum) throws Exception {
		return mainDao.profileImg(memberNum);
	}
	
	// 검색된 태그 목록가져오기
	@Override
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception {
		return mainDao.tagSearch(pageVo);
	}
	
	// 게시글 총 갯수
	@Override
	public int listCount(PageVo pageVo) throws Exception {
		return mainDao.listCount(pageVo);
	}

}
