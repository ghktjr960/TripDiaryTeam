package com.tripdiary.JCvo;

import java.sql.Timestamp;
import java.util.Date;

public class ReadVo {
	private int boardNum;
	private int memberNum;
	private String nickname;
	private String content;
	private Timestamp regdate;
	private Date tripdate;
	private int tdLikeCnt;
	private String profileOrgFileName;
	private String profileStoreFileName;
	private String profileFileType;

	public ReadVo() {
		// TODO Auto-generated constructor stub
	}

	public ReadVo(int boardNum, int memberNum, String nickname, String content, Timestamp regdate, Date tripdate,
			int tdLikeCnt, String profileOrgFileName, String profileStoreFileName, String profileFileType) {
		super();
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.tripdate = tripdate;
		this.tdLikeCnt = tdLikeCnt;
		this.profileOrgFileName = profileOrgFileName;
		this.profileStoreFileName = profileStoreFileName;
		this.profileFileType = profileFileType;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getProfileOrgFileName() {
		return profileOrgFileName;
	}

	public void setProfileOrgFileName(String profileOrgFileName) {
		this.profileOrgFileName = profileOrgFileName;
	}

	public String getProfileStoreFileName() {
		return profileStoreFileName;
	}

	public void setProfileStoreFileName(String profileStoreFileName) {
		this.profileStoreFileName = profileStoreFileName;
	}

	public String getProfileFileType() {
		return profileFileType;
	}

	public void setProfileFileType(String profileFileType) {
		this.profileFileType = profileFileType;
	}

	@Override
	public String toString() {
		return "ReadVo [boardNum=" + boardNum + ", memberNum=" + memberNum + ", nickname=" + nickname + ", content="
				+ content + ", regdate=" + regdate + ", tripdate=" + tripdate + ", tdLikeCnt=" + tdLikeCnt
				+ ", profileOrgFileName=" + profileOrgFileName + ", profileStoreFileName=" + profileStoreFileName
				+ ", profileFileType=" + profileFileType + "]";
	}

}
