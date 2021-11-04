package com.tripdiary.HSdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.HSvo.DelMemberVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.ReportBoardVo;
import com.tripdiary.HSvo.ReportCntVo;
import com.tripdiary.HSvo.ReportReplyVo;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Inject
	private SqlSession sqlSession;
	
	// 회원관리 : 각 회원마다 신고와 관련된 횟수 불러오기
	@Override
	public List<ReportCntVo> reportCntVo(ReportCntVo reportCntVo) {
		return sqlSession.selectList("adminMapper.reportCnt", reportCntVo);
	}
	
	// 선택한 회원삭제
	@Override
	public int memberManageDelte(int memberNum) {
		return sqlSession.delete("adminMapper.adminMemberDelete", memberNum);
	}
	
	// 회원 탈퇴 테이블 조회 : List
	@Override
	public List<DelMemberVo> delMemberSelectList() {
		return sqlSession.selectList("adminMapper.delMemberSelectList");
	}

	// 회원 탈퇴 테이블 조회 : List
	@Override
	public DelMemberVo delMemberSelectOne(int memberNum) {
		return sqlSession.selectOne("adminMapper.delMemberSelectOne", memberNum);
	}
	
	// 회원 삭제 후 회원 탈퇴테이블 추가
	@Override
	public int delMemberInsert(MemberVo delMember) {
		return sqlSession.delete("adminMapper.delMemberInsert", delMember);
	}
	
	// 회원 삭제 후 timeover변경
	@Override
	public int delmemberUpdate(int memberNum) {
		return sqlSession.update("adminMapper.delMemberUpdate", memberNum);
	}

	// del_member테이블에 넣어줄 회원 정보 가져오기
	@Override
	public MemberVo getMemberVo(int memberNum) {
		return sqlSession.selectOne("adminMapper.getMemberVo", memberNum);
	}
	
	// 게시글 신고 내역
	@Override
	public List<ReportBoardVo> reportBoardList() {
		return sqlSession.selectList("adminMapper.reportBoardList");
	}
	
	// 게시글 신고 내역 게시글 하나
	@Override
	public ReportBoardVo reportBoardOne(int reportBoardNum) {
		return sqlSession.selectOne("adminMapper.reportBoardOne", reportBoardNum);
	}
	
	// report_board 테이블에서 삭제
	@Override
	public void reportBoardDelete(ReportBoardVo reportBoardVo) {
		sqlSession.delete("adminMapper.reportBoardDelete", reportBoardVo);
	}
	
	// board 테이블에서 삭제
	@Override
	public void mainBoardDelete(ReportBoardVo reportBoardVo) {
		sqlSession.delete("adminMapper.mainBoardDelete", reportBoardVo);
	}
	
	// report_member 테이블에 추가 (회원, 사유)
	@Override
	public void reportMemberInsert(ReportBoardVo reportBoardVo) {
		sqlSession.insert("adminMapper.reportMemberInsert", reportBoardVo);
	}
	
	// report_cnt 테이블에 update 신고 완료 처리
	@Override
	public void reportCntSend(int memberNumSend) {
		sqlSession.update("adminMapper.reportCntSend", memberNumSend);
	}	
	
	// report_cnt 테이블에 update 경고 완료 처리
	@Override
	public void reportCntReceive(int memberNumReceive) {
		sqlSession.update("adminMapper.reportCntReceive", memberNumReceive);
	}
	
	// 댓글 신고 내역
	@Override
	public List<ReportReplyVo> reportReplyList() {
		return sqlSession.selectList("adminMapper.reportReplyList");
	}
	
	// 댓글 신고 내역 게시글 하나
	@Override
	public ReportReplyVo reportReplyOne(int reportReplyNum) {
		return sqlSession.selectOne("adminMapper.reportReplyOne", reportReplyNum);
	}	
	
	// report_reply 테이블에서 삭제
	@Override
	public void reportReplyDelete(ReportReplyVo reportReplyVo) {
		sqlSession.delete("adminMapper.reportReplyDelete", reportReplyVo);
	}
	
	// reply 테이블에서 삭제
	@Override
	public void mainReplyDelete(ReportReplyVo reportReplyVo) {
		sqlSession.delete("adminMapper.mainReplyDelete", reportReplyVo);
	}	
	
	// report_member 테이블에 추가 (회원, 사유)
	@Override
	public void reportMemberInsertReply(ReportReplyVo reportReplyVo) {
		sqlSession.insert("adminMapper.reportMemberInsertReply", reportReplyVo);
	}
}
