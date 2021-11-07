package com.tripdiary.JCvo;

import java.sql.Timestamp;

public class ReplyVo {
	private int replyNum;
	private int boardNum;
	private int memberNum;
	private String content;
	private Timestamp regdate;

	public ReplyVo() {
		// TODO Auto-generated constructor stub
	}

	public ReplyVo(int replyNum, int boardNum, int memberNum, String content, Timestamp regdate) {
		super();
		this.replyNum = replyNum;
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.content = content;
		this.regdate = regdate;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReplyVo [replyNum=" + replyNum + ", boardNum=" + boardNum + ", memberNum=" + memberNum + ", content="
				+ content + ", regdate=" + regdate + "]";
	}

}
