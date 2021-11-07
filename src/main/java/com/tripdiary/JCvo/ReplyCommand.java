package com.tripdiary.JCvo;

import java.sql.Timestamp;

public class ReplyCommand {
	private Integer replyNum;
	private int boardNum;
	private int memberNum;
	private String content;
	private Timestamp regdate;
	private String nickname;

	public ReplyCommand() {
		// TODO Auto-generated constructor stub
	}

	public ReplyCommand(Integer replyNum, int boardNum, int memberNum, String content, Timestamp regdate,
			String nickname) {
		super();
		this.replyNum = replyNum;
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.content = content;
		this.regdate = regdate;
		this.nickname = nickname;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "ReplyCommand [replyNum=" + replyNum + ", boardNum=" + boardNum + ", memberNum=" + memberNum
				+ ", content=" + content + ", regdate=" + regdate + ", nickname=" + nickname + "]";
	}

}