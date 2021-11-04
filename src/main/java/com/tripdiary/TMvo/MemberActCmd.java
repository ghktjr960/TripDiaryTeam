package com.tripdiary.TMvo;

public class MemberActCmd {
	private int tdLikePressCnt;
	private int pickPressCnt;
	private int boardWriteCnt;
	private int replyWriteCnt;
	private int tdLikeReceiveCnt;
	
	public MemberActCmd() {
		// TODO Auto-generated constructor stub
	}

	public MemberActCmd(int tdLikePressCnt, int pickPressCnt, int boardWriteCnt, int replyWriteCnt,
			int tdLikeReceiveCnt) {
		super();
		this.tdLikePressCnt = tdLikePressCnt;
		this.pickPressCnt = pickPressCnt;
		this.boardWriteCnt = boardWriteCnt;
		this.replyWriteCnt = replyWriteCnt;
		this.tdLikeReceiveCnt = tdLikeReceiveCnt;
	}

	public int getTdLikePressCnt() {
		return tdLikePressCnt;
	}

	public void setTdLikePressCnt(int tdLikePressCnt) {
		this.tdLikePressCnt = tdLikePressCnt;
	}

	public int getPickPressCnt() {
		return pickPressCnt;
	}

	public void setPickPressCnt(int pickPressCnt) {
		this.pickPressCnt = pickPressCnt;
	}

	public int getBoardWriteCnt() {
		return boardWriteCnt;
	}

	public void setBoardWriteCnt(int boardWriteCnt) {
		this.boardWriteCnt = boardWriteCnt;
	}

	public int getReplyWriteCnt() {
		return replyWriteCnt;
	}

	public void setReplyWriteCnt(int replyWriteCnt) {
		this.replyWriteCnt = replyWriteCnt;
	}

	public int getTdLikeReceiveCnt() {
		return tdLikeReceiveCnt;
	}

	public void setTdLikeReceiveCnt(int tdLikeReceiveCnt) {
		this.tdLikeReceiveCnt = tdLikeReceiveCnt;
	}
	
	
}
