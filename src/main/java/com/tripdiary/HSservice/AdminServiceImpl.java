package com.tripdiary.HSservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.HSdao.AdminDao;
import com.tripdiary.HSvo.DelMemberVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.ReportBoardVo;
import com.tripdiary.HSvo.ReportCntVo;
import com.tripdiary.HSvo.ReportReplyVo;

@Service
public class AdminServiceImpl implements AdminService{

	@Inject
	private AdminDao adminDao;
	
	// 회원관리 : 각 회원마다 신고와 관련된 횟수 불러오기
	@Override
	public List<ReportCntVo> reportCntVo(ReportCntVo reportCntVo) {
		return adminDao.reportCntVo(reportCntVo);
	}

	// 선택한 회원삭제
	@Override
	public int memberManageDelte(int memberNum) {
		return adminDao.memberManageDelte(memberNum);
	}
	
	// 회원 탈퇴 테이블 조회 : List
	@Override
	public List<DelMemberVo> delMemberSelectList() {
		return adminDao.delMemberSelectList();
	}

	// 회원 탈퇴 테이블 조회 : One
	@Override
	public DelMemberVo delMemberSelectOne(int memberNum) {
		return adminDao.delMemberSelectOne(memberNum);
	}
	
	// 회원 삭제 후 회원 탈퇴테이블 추가
	@Override
	public int delMemberInsert(MemberVo delMember) {
		return adminDao.delMemberInsert(delMember);
	}
	
	// 회원 삭제 후 timeover변경
	@Override
	public int delmemberUpdate(int memberNum) {
		return adminDao.delmemberUpdate(memberNum);
	}
	
	// del_member테이블에 넣어줄 회원 정보 가져오기
	@Override
	public MemberVo getMemberVo(int memberNum) {
		return adminDao.getMemberVo(memberNum);
	}

	// 게시글 신고 내역
	@Override
	public List<ReportBoardVo> reportBoardList() {
		return adminDao.reportBoardList();
	}

	// 게시글 신고 내역 게시글 하나
	@Override
	public ReportBoardVo reportBoardOne(int reportBoardNum) {
		return adminDao.reportBoardOne(reportBoardNum);
	}
	
	// report_board 테이블에서 삭제
	@Override
	public void reportBoardDelete(ReportBoardVo reportBoardVo) {
		adminDao.reportBoardDelete(reportBoardVo);
	}
	
	// board 테이블에서 삭제
	@Override
	public void mainBoardDelete(ReportBoardVo reportBoardVo) {
		adminDao.mainBoardDelete(reportBoardVo);
	}
	
	// report_member 테이블에 추가 (회원, 사유)
	@Override
	public void reportMemberInsert(ReportBoardVo reportBoardVo) {
		adminDao.reportMemberInsert(reportBoardVo);
	}
	
	// report_cnt 테이블에 update 신고 완료 처리
	@Override
	public void reportCntSend(int memberNumSend) {
		adminDao.reportCntSend(memberNumSend);
	}
	
	// report_cnt 테이블에 update 경고 완료 처리
	@Override
	public void reportCntReceive(int memberNumReceive) {
		adminDao.reportCntReceive(memberNumReceive);
	}
	
	// 댓글 신고 내역
	@Override
	public List<ReportReplyVo> reportReplyList() {
		return adminDao.reportReplyList();
	}
	
	// 댓글 신고 내역 게시글 하나
	@Override
	public ReportReplyVo reportReplyOne(int reportReplyNum) {
		return adminDao.reportReplyOne(reportReplyNum);
	}
	
	// report_reply 테이블에서 삭제
	@Override
	public void reportReplyDelete(ReportReplyVo reportReplyVo) {
		adminDao.reportReplyDelete(reportReplyVo);
	}
	
	// reply 테이블에서 삭제
	@Override
	public void mainReplyDelete(ReportReplyVo reportReplyVo) {
		adminDao.mainReplyDelete(reportReplyVo);
	}	
	
	// report_member 테이블에 추가 (회원, 사유)
	@Override
	public void reportMemberInsertReply(ReportReplyVo reportReplyVo) {
		adminDao.reportMemberInsertReply(reportReplyVo);
	}
}
