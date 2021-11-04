package com.tripdiary.HSservice;

import java.util.List;

import com.tripdiary.HSvo.DelMemberVo;
import com.tripdiary.HSvo.MemberVo;
import com.tripdiary.HSvo.ReportBoardVo;
import com.tripdiary.HSvo.ReportCntVo;
import com.tripdiary.HSvo.ReportReplyVo;

public interface AdminService {
	
	// 회원관리 : 각 회원마다 신고와 관련된 횟수 불러오기
	public List<ReportCntVo> reportCntVo(ReportCntVo reportCntVo);
	
	// 선택한 회원삭제
	public int memberManageDelte(int memberNum);

	// 회원 탈퇴 테이블 조회 : List
	public List<DelMemberVo> delMemberSelectList();

	// 회원 탈퇴 테이블 조회 : List
	public DelMemberVo delMemberSelectOne(int memberNum);
	
	// 회원 삭제 후 회원 탈퇴테이블 추가
	public int delMemberInsert(MemberVo delMember);
	
	// 회원 삭제 후 timeover변경
	public int delmemberUpdate(int memberNum);
	
	// del_member테이블에 넣어줄 회원 정보 가져오기
	public MemberVo getMemberVo(int memberNum);

	// 게시글 신고 내역
	public List<ReportBoardVo> reportBoardList();
	
	// 게시글 신고 내역 게시글 하나
	public ReportBoardVo reportBoardOne(int reportBoardNum);

	// report_board 테이블에서 삭제
	public void reportBoardDelete(ReportBoardVo reportBoardVo); 

	// board 테이블에서 삭제
	public void mainBoardDelete (ReportBoardVo reportBoardVo); 

	// report_member 테이블에 추가 (회원, 사유)
	public void reportMemberInsert(ReportBoardVo reportBoardVo);

	// report_cnt 테이블에 update 신고 완료 처리
	public void reportCntSend(int memberNumSend);
	
	// report_cnt 테이블에 update 경고 완료 처리
	public void reportCntReceive(int memberNumReceive);
	
	// 댓글 신고 내역
	public List<ReportReplyVo> reportReplyList();
	
	// 댓글 신고 내역 게시글 하나
	public ReportReplyVo reportReplyOne(int reportReplyNum);

	// report_reply 테이블에서 삭제
	public void reportReplyDelete(ReportReplyVo reportReplyVo); 

	// reply 테이블에서 삭제
	public void mainReplyDelete(ReportReplyVo reportReplyVo); 

	// report_member 테이블에 추가 (회원, 사유)
	public void reportMemberInsertReply(ReportReplyVo reportReplyVo);





}
