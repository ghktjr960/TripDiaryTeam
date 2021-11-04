package com.tripdiary.HSvo;

import java.sql.Timestamp;

public class PickVo {
	private int pickNum;
	private int memberNum;
	private int boardNum;
	private Timestamp pickRegdate;
	
	public PickVo() {

	}
	
	public int getPickNum() {
		return pickNum;
	}
	public void setPickNum(int pickNum) {
		this.pickNum = pickNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public Timestamp getPickRegdate() {
		return pickRegdate;
	}
	public void setPickRegdate(Timestamp pickRegdate) {
		this.pickRegdate = pickRegdate;
	}
	
	@Override
	public String toString() {
		return "PickVo [pickNum=" + pickNum + ", memberNum=" + memberNum + ", boardNum=" + boardNum + ", pickRegdate="
				+ pickRegdate + "]";
	}
	
	
}
