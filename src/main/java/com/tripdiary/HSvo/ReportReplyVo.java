package com.tripdiary.HSvo;

import java.sql.Timestamp;

public class ReportReplyVo {
	private int reportReplyNum;
	private int replyNum;
	private String replyContent;
	private String reportSend;
	private String reportReceive;
	private String reportContent;
	private String reportType;
	private Timestamp reportDate;
	private int memberNumSend;
	private int memberNumReceive;
	
	public ReportReplyVo() {
		// TODO Auto-generated constructor stub
	}

	public ReportReplyVo(int reportReplyNum, int replyNum, String replyContent, String reportSend, String reportReceive,
			String reportType, String reportContent, Timestamp reportDate, int memberNumSend, int memberNumReceive) {
		super();
		this.reportReplyNum = reportReplyNum;
		this.replyNum = replyNum;
		this.replyContent = replyContent;
		this.reportSend = reportSend;
		this.reportReceive = reportReceive;
		this.reportType = reportType;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.memberNumSend = memberNumSend;
		this.memberNumReceive = memberNumReceive;
	}

	public int getReportReplyNum() {
		return reportReplyNum;
	}

	public void setReportReplyNum(int reportReplyNum) {
		this.reportReplyNum = reportReplyNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
		return "ReportReplyVo [reportReplyNum=" + reportReplyNum + ", replyNum=" + replyNum + ", replyContent="
				+ replyContent + ", reportSend=" + reportSend + ", reportReceive=" + reportReceive + ", reportType="
				+ reportType + ", reportContent=" + reportContent + ", reportDate=" + reportDate + ", memberNumSend="
				+ memberNumSend + ", memberNumReceive=" + memberNumReceive + "]";
	}

}
