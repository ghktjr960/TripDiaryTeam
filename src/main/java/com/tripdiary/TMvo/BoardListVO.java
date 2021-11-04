package com.tripdiary.TMvo;

import java.util.List;

public class BoardListVO {
	private int boardNum;
	private String tripdate;
	private int tdLikeCnt;
	private String boardFileName;
	private String nickname;
	private String profileFileName;
	private List<String> tag;
	
	public BoardListVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardListVO(int boardNum, String tripdate, int tdLikeCnt, String boardFileName, String nickname,
			String profileFileName, List<String> tag) {
		super();
		this.boardNum = boardNum;
		this.tripdate = tripdate;
		this.tdLikeCnt = tdLikeCnt;
		this.boardFileName = boardFileName;
		this.nickname = nickname;
		this.profileFileName = profileFileName;
		this.tag = tag;
	}
	
	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getTripdate() {
		return tripdate;
	}

	public void setTripdate(String tripdate) {
		this.tripdate = tripdate;
	}

	public int getTdLikeCnt() {
		return tdLikeCnt;
	}

	public void setTdLikeCnt(int tdLikeCnt) {
		this.tdLikeCnt = tdLikeCnt;
	}

	public String getBoardFileName() {
		return boardFileName;
	}

	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileFileName() {
		return profileFileName;
	}

	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}
	
}
