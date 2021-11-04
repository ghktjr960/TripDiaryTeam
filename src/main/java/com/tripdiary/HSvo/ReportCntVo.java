package com.tripdiary.HSvo;

public class ReportCntVo {
	
	private String id;
	private int memberNum;
	private int reportComCnt;
	private int reportCnt;
	private int warningCnt;
	
	public ReportCntVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ReportCntVo(String id, int memberNum, int reportComCnt, int reportCnt, int warningCnt) {
		super();
		this.id = id;
		this.memberNum = memberNum;
		this.reportComCnt = reportComCnt;
		this.reportCnt = reportCnt;
		this.warningCnt = warningCnt;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getReportComCnt() {
		return reportComCnt;
	}
	public void setReportComCnt(int reportComCnt) {
		this.reportComCnt = reportComCnt;
	}
	public int getReportCnt() {
		return reportCnt;
	}
	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}
	public int getWarningCnt() {
		return warningCnt;
	}
	public void setWarningCnt(int warningCnt) {
		this.warningCnt = warningCnt;
	}
	
	@Override
	public String toString() {
		return "AdminMemberReportCntVo [id=" + id + ", memberNum=" + memberNum + ", reportComCnt=" + reportComCnt
				+ ", reportCnt=" + reportCnt + ", warningCnt=" + warningCnt + "]";
	}

	
}
