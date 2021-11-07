package com.tripdiary.JCvo;

public class TdLikeVo {
	private int tdLikeNum;
	private int memberNum;
	private int boardNum;

	public TdLikeVo() {
		// TODO Auto-generated constructor stub
	}

	public TdLikeVo(int memberNum, int boardNum) {
		super();
		this.memberNum = memberNum;
		this.boardNum = boardNum;
	}

	public int getTdLikeNum() {
		return tdLikeNum;
	}

	public void setTdLikeNum(int tdLikeNum) {
		this.tdLikeNum = tdLikeNum;
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

	@Override
	public String toString() {
		return "TdLikeVo [tdLikeNum=" + tdLikeNum + ", memberNum=" + memberNum + ", boardNum=" + boardNum + "]";
	}
	
	
	

	

}
