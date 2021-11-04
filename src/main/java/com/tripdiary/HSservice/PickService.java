package com.tripdiary.HSservice;

import java.util.List;

import com.tripdiary.HScontroller.PickCmd;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

public interface PickService {

	// 게시글 번호와 회원 번호로 pick테이블에 정보가 있는지 확인
	public PickVo pickCheck(PickVo pickVo) throws Exception;
	
	// 회원이 찜하기를 눌렀을 때 찜하기가 안눌려있을 경우 찜하기 추가
	public void pickInsert(PickCmd pickCmd) throws Exception;

	// 회원이 찜하기를 눌렀을 때 찜하기가 눌려있을 경우 찜하기 삭제
	public void pickDelete(PickVo pickVo) throws Exception;
	
	// 찜하기 눌렀을 때 member_act_cnt테이블에 각 회원마다 찜하기 누른 횟수 저장
	public void memberActCntPick(PickCmd pickCmd) throws Exception;

	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	public List<MainBoardListVo> pickPageList(PageVo pageVo) throws Exception;
	
	// 전체 태그 목록 가져오기
	public List<TagVo> pickPageTagList() throws Exception;
	
	// 각 회원마다 프로필 이미지 가져오기
	public ProfileImgVo profileImg(int memberNum) throws Exception;
	
	// 검색된 태그 목록가져오기
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception;

	// 게시글 총 갯수
	public int listCount(PageVo pageVo) throws Exception;




}
