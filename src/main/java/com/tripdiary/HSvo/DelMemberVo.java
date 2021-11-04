package com.tripdiary.HSvo;

import java.sql.Timestamp;

public class DelMemberVo {
	private int delMemberNum;
	private int memberNum;
	private String memberId;
	private int timeover;
	private Timestamp delDate;
	
	public DelMemberVo() {
		// TODO Auto-generated constructor stub
	}

	public DelMemberVo(int memberNum, String memberId) {
		this.memberNum = memberNum;
		this.memberId = memberId;
	}
	
	public DelMemberVo(int delMemberNum, int memberNum, String memberId, int timeover, Timestamp delDate) {
		super();
		this.delMemberNum = delMemberNum;
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.timeover = timeover;
		this.delDate = delDate;
	}

	public int getDelMemberNum() {
		return delMemberNum;
	}

	public void setDelMemberNum(int delMemberNum) {
		this.delMemberNum = delMemberNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getTimeover() {
		return timeover;
	}

	public void setTimeover(int timeover) {
		this.timeover = timeover;
	}

	public Timestamp getDelDate() {
		return delDate;
	}

	public void setDelDate(Timestamp delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "DelMemberVo [delMemberNum=" + delMemberNum + ", memberNum=" + memberNum + ", memberId=" + memberId
				+ ", timeover=" + timeover + ", delDate=" + delDate + "]";
	}
	
}
