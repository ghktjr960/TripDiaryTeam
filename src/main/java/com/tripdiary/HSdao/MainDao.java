package com.tripdiary.HSdao;

import java.util.List;

import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

public interface MainDao {
	
	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	public List<MainBoardListVo> mainBoardList(PageVo pageVo) throws Exception;
	
	// 전체 태그 목록 가져오기
	public List<TagVo> mainTagList() throws Exception;
	
	// 세션에 저장된 회원번호로 찜하기 눌렀는지 여부 확인
	public List<PickVo> mainPickList(int memberNum) throws Exception;
	
	// 각 회원마다 프로필 이미지 가져오기
	public ProfileImgVo profileImg(int memberNum) throws Exception;
	
	// 검색된 태그 목록가져오기
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception;

	// 게시글 총 갯수
	public int listCount(PageVo pageVo) throws Exception;
	
}
