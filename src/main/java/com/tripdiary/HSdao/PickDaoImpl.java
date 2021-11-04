package com.tripdiary.HSdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.HScontroller.PickCmd;
import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Repository
public class PickDaoImpl implements PickDao{
	
	@Inject
	private SqlSession sqlSession;
	
	// 게시글 번호와 회원 번호로 pick테이블에 정보가 있는지 확인
	@Override
	public PickVo pickCheck(PickVo pickVo) throws Exception {
		return sqlSession.selectOne("pickMapper.pickCheck", pickVo);
	}

	// 회원이 찜하기를 눌렀을 때 찜하기가 안눌려있을 경우 찜하기 추가
	@Override
	public void pickInsert(PickCmd pickCmd) throws Exception {
		sqlSession.insert("pickMapper.pickInsert", pickCmd);
	}
	
	// 회원이 찜하기를 눌렀을 때 찜하기가 눌려있을 경우 찜하기 삭제
	@Override
	public void pickDelete(PickVo pickVo) throws Exception {
		sqlSession.insert("pickMapper.pickDelete", pickVo);
	}
	
	// 찜하기 눌렀을 때 member_act_cnt테이블에 각 회원마다 찜하기 누른 횟수 저장
	@Override
	public void memberActCntPick(PickCmd pickCmd) throws Exception {
		sqlSession.update("pickMapper.memberActCntPick", pickCmd);
	}
	
	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	@Override
	public List<MainBoardListVo> pickPageList(PageVo pageVo) throws Exception {
		return sqlSession.selectList("pickMapper.pickPageList", pageVo);
	}
	
	// 전체 태그 목록 가져오기
	@Override
	public List<TagVo> pickPageTagList() throws Exception {
		return sqlSession.selectList("pickMapper.pickPageTagList");
	}

	// 각 회원마다 프로필 이미지 가져오기
	@Override
	public ProfileImgVo profileImg(int memberNum) throws Exception {
		return sqlSession.selectOne("pickMapper.profileImg", memberNum);
	}
	
	// 검색된 태그 목록가져오기
	@Override
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception {
		return sqlSession.selectList("pickMapper.tagSearch", pageVo);
	}
	
	// 게시글 총 갯수
	@Override
	public int listCount(PageVo pageVo) throws Exception {
		return sqlSession.selectOne("pickMapper.listCount", pageVo);
	}	
	
}
