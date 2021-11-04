package org.project.regist.vo;

import java.util.Date;

public class ResignVo {

	private int delMemberNum;
	private int memberNum; //중복값
	private String memberId; //중복값
	private boolean timeOver;
	private Date delDate;

	public int getDelMemberNum() {
		return delMemberNum;
	}

	public void setDelMemberNum(int delMemberNum) {
		this.delMemberNum = delMemberNum;
	}

	public boolean isTimeOver() {
		return timeOver;
	}

	public void setTimeOver(boolean timeOver) {
		this.timeOver = timeOver;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "ResignVo [delMemberNum=" + delMemberNum + ", memberNum=" + memberNum + ", memberId=" + memberId
				+ ", timeOver=" + timeOver + ", delDate=" + delDate + "]";
	}

	
	
	
	
	
}
