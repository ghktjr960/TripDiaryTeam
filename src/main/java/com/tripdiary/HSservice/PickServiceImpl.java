package com.tripdiary.HSservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.HScontroller.PickCmd;
import com.tripdiary.HSdao.PickDao;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Service
public class PickServiceImpl implements PickService{

	@Inject
	private PickDao pickDao;
	
	// 게시글 번호와 회원 번호로 pick테이블에 정보가 있는지 확인
	@Override
	public PickVo pickCheck(PickVo pickVo) throws Exception {
		return pickDao.pickCheck(pickVo);
	}
	
	// 회원이 찜하기를 눌렀을 때 찜하기가 안눌려있을 경우 찜하기 추가
	@Override
	public void pickInsert(PickCmd pickCmd) throws Exception {
		pickDao.pickInsert(pickCmd);
	}
	
	// 회원이 찜하기를 눌렀을 때 찜하기가 눌려있을 경우 찜하기 삭제
	@Override
	public void pickDelete(PickVo pickVo) throws Exception {
		pickDao.pickDelete(pickVo);
	}
	
	// 찜하기 눌렀을 때 member_act_cnt테이블에 각 회원마다 찜하기 누른 횟수 저장
	@Override
	public void memberActCntPick(PickCmd pickCmd) throws Exception {
		pickDao.memberActCntPick(pickCmd);
	}	
	
	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	@Override
	public List<MainBoardListVo> pickPageList(PageVo pageVo) throws Exception {
		return pickDao.pickPageList(pageVo);
	}
	
	// 전체 태그 목록 가져오기
	@Override
	public List<TagVo> pickPageTagList() throws Exception {
		return pickDao.pickPageTagList();
	}
	
	// 각 회원마다 프로필 이미지 가져오기
	@Override
	public ProfileImgVo profileImg(int memberNum) throws Exception {
		return pickDao.profileImg(memberNum);
	}
	
	// 검색된 태그 목록가져오기
	@Override
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception {
		return pickDao.tagSearch(pageVo);
	}
	
	// 게시글 총 갯수
	@Override
	public int listCount(PageVo pageVo) throws Exception {
		return pickDao.listCount(pageVo);
	}

	
	
}
