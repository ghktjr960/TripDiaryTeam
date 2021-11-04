package com.tripdiary.TMvo;

import java.sql.Timestamp;
import java.util.Date;

public class BoardVo {
	private int boardNum;
	private int memberNum;
	private String place;
	private String content;
	private Timestamp regdate;
	private Date tripdate;
	private int tdLikeCnt;
	
	public BoardVo() {

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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public Date getTripdate() {
		return tripdate;
	}
	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}
	public int getTdLikeCnt() {
		return tdLikeCnt;
	}
	public void setTdLikeCnt(int tdLikeCnt) {
		this.tdLikeCnt = tdLikeCnt;
	}

	@Override
	public String toString() {
		return "BoardVo [boardNum=" + boardNum + ", memberNum=" + memberNum + ", place=" + place + ", content="
				+ content + ", regdate=" + regdate + ", tripdate=" + tripdate + ", tdLikeCnt=" + tdLikeCnt + "]";
	}
	
	

	
	
}
