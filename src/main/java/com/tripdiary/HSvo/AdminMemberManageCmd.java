package com.tripdiary.HSvo;

public class AdminMemberManageCmd {
	
	private String id;
	private int memberNum;
	private int reportComCnt;
	private int reportCnt;
	private int warningCnt;
	private int manageCheck;
	
	public AdminMemberManageCmd() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminMemberManageCmd(String id, int memberNum, int reportComCnt, int reportCnt, int warningCnt,
			int manageCheck) {
		super();
		this.id = id;
		this.memberNum = memberNum;
		this.reportComCnt = reportComCnt;
		this.reportCnt = reportCnt;
		this.warningCnt = warningCnt;
		this.manageCheck = manageCheck;
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

	public int getManageCheck() {
		return manageCheck;
	}

	public void setManageCheck(int manageCheck) {
		this.manageCheck = manageCheck;
	}

	@Override
	public String toString() {
		return "AdminMemberManageCmd [id=" + id + ", memberNum=" + memberNum + ", reportComCnt=" + reportComCnt
				+ ", reportCnt=" + reportCnt + ", warningCnt=" + warningCnt + ", manageCheck=" + manageCheck + "]";
	}

	
	
}
