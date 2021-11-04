package com.tripdiary.HScontroller;

public class PickCmd {
	private int memberNum;
	private int boardNum;
	private String updateType;
	
	
	public PickCmd() {

	}

	public PickCmd(int memberNum, int boardNum, String updateType) {
		this.memberNum = memberNum;
		this.boardNum = boardNum;
		this.updateType = updateType;
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

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	@Override
	public String toString() {
		return "PickCmd [memberNum=" + memberNum + ", boardNum=" + boardNum + ", updateType=" + updateType + "]";
	}

}
