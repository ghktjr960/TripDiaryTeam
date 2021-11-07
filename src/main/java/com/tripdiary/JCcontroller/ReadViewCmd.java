package com.tripdiary.JCcontroller;

public class ReadViewCmd {
	private int boardNum;
	private int memberNum;

	public ReadViewCmd() {
		// TODO Auto-generated constructor stub
	}

	public ReadViewCmd(int boardNum, int memberNum) {
		this.boardNum = boardNum;
		this.memberNum = memberNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "ReadViewCmd [boardNum=" + boardNum + ", memberNum=" + memberNum + "]";
	}

}
