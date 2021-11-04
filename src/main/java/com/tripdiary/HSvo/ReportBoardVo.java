package com.tripdiary.HSvo;

import java.sql.Timestamp;

public class ReportBoardVo {
	private int reportBoardNum;
	private int boardNum;
	private String reportSend;
	private String reportReceive;
	private String reportType;
	private String reportContent;
	private Timestamp reportDate;
	private int memberNumSend;
	private int memberNumReceive;
	
	public ReportBoardVo() {
		// TODO Auto-generated constructor stub
	}

	public ReportBoardVo(int reportBoardNum, int boardNum, String reportSend, String reportReceive, String reportType,
			String reportContent, Timestamp reportDate, int memberNumSend, int memberNumReceive) {
		super();
		this.reportBoardNum = reportBoardNum;
		this.boardNum = boardNum;
		this.reportSend = reportSend;
		this.reportReceive = reportReceive;
		this.reportType = reportType;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.memberNumSend = memberNumSend;
		this.memberNumReceive = memberNumReceive;
	}

	public int getReportBoardNum() {
		return reportBoardNum;
	}

	public void setReportBoardNum(int reportBoardNum) {
		this.reportBoardNum = reportBoardNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getReportSend() {
		return reportSend;
	}

	public void setReportSend(String reportSend) {
		this.reportSend = reportSend;
	}

	public String getReportReceive() {
		return reportReceive;
	}

	public void setReportReceive(String reportReceive) {
		this.reportReceive = reportReceive;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Timestamp getReportDate() {
		return reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public int getMemberNumSend() {
		return memberNumSend;
	}

	public void setMemberNumSend(int memberNumSend) {
		this.memberNumSend = memberNumSend;
	}

	public int getMemberNumReceive() {
		return memberNumReceive;
	}

	public void setMemberNumReceive(int memberNumReceive) {
		this.memberNumReceive = memberNumReceive;
	}

	@Override
	public String toString() {
		return "ReportBoardVo [reportBoardNum=" + reportBoardNum + ", boardNum=" + boardNum + ", reportSend="
				+ reportSend + ", reportReceive=" + reportReceive + ", reportType=" + reportType + ", reportContent="
				+ reportContent + ", reportDate=" + reportDate + ", memberNumSend=" + memberNumSend
				+ ", memberNumReceive=" + memberNumReceive + "]";
	}
	
}
