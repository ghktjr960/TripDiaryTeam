package com.tripdiary.HSdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.HSvo.MainBoardListVo;
import com.tripdiary.HSvo.PageVo;
import com.tripdiary.HSvo.PickVo;
import com.tripdiary.HSvo.ProfileImgVo;
import com.tripdiary.HSvo.TagVo;

@Repository
public class MainDaoImpl implements MainDao{
	
	@Inject
	private SqlSession sqlSession;
	
	// 메인 페이지에서 보이는 게시글 목록 : 검색(지역, 태그) 정렬
	@Override
	public List<MainBoardListVo> mainBoardList(PageVo pageVo) throws Exception {
		return sqlSession.selectList("mainMapper.mainBoardList", pageVo);
	}
	
	// 전체 태그 목록 가져오기
	@Override
	public List<TagVo> mainTagList() throws Exception {
		return sqlSession.selectList("mainMapper.mainTagList");
	}
	
	// 세션에 저장된 회원번호로 찜하기 눌렀는지 여부 확인
	@Override
	public List<PickVo> mainPickList(int memberNum) throws Exception {
		return sqlSession.selectList("mainMapper.mainPickList", memberNum);
	}
	
	// 각 회원마다 프로필 이미지 가져오기
	@Override
	public ProfileImgVo profileImg(int memberNum) throws Exception {
		return sqlSession.selectOne("mainMapper.profileImg", memberNum);
	}
	
	// 검색된 태그 목록가져오기
	@Override
	public List<TagVo> tagSearch(PageVo pageVo) throws Exception {
		return sqlSession.selectList("mainMapper.tagSearch", pageVo);
	}
	
	// 게시글 총 갯수
	@Override
	public int listCount(PageVo pageVo) throws Exception {
		return sqlSession.selectOne("mainMapper.listCount", pageVo);
	}
	
}
