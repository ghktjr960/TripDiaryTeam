package com.tripdiary.HSvo;

import java.sql.Timestamp;
import java.util.Date;

public class MainBoardListVo {
	private int boardNum;
	private int memberNum;
	private String place;
	private String content;
	private Timestamp regdate;
	private Date tripdate;
	private int tdLikeCnt;
	private int pickNum;
	private String mainOrgFileName;
	private String mainStoreFileName;
	private String mainFileType;
	private String nickname;
	private String profileOrgFileName;
	private String profileStoreFileName;
	private String profileFileType;
	
	public MainBoardListVo() {

	}

	public MainBoardListVo(int boardNum, int memberNum, String place, String content, Timestamp regdate, Date tripdate,
			int tdLikeCnt, int pickNum, String mainOrgFileName, String mainStoreFileName, String mainFileType,
			String nickname, String profileOrgFileName, String profileStoreFileName, String profileFileType) {
		super();
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.place = place;
		this.content = content;
		this.regdate = regdate;
		this.tripdate = tripdate;
		this.tdLikeCnt = tdLikeCnt;
		this.pickNum = pickNum;
		this.mainOrgFileName = mainOrgFileName;
		this.mainStoreFileName = mainStoreFileName;
		this.mainFileType = mainFileType;
		this.nickname = nickname;
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

	public int getPickNum() {
		return pickNum;
	}

	public void setPickNum(int pickNum) {
		this.pickNum = pickNum;
	}

	public String getMainOrgFileName() {
		return mainOrgFileName;
	}

	public void setMainOrgFileName(String mainOrgFileName) {
		this.mainOrgFileName = mainOrgFileName;
	}

	public String getMainStoreFileName() {
		return mainStoreFileName;
	}

	public void setMainStoreFileName(String mainStoreFileName) {
		this.mainStoreFileName = mainStoreFileName;
	}

	public String getMainFileType() {
		return mainFileType;
	}

	public void setMainFileType(String mainFileType) {
		this.mainFileType = mainFileType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "MainBoardListVo [boardNum=" + boardNum + ", memberNum=" + memberNum + ", place=" + place + ", content="
				+ content + ", regdate=" + regdate + ", tripdate=" + tripdate + ", tdLikeCnt=" + tdLikeCnt
				+ ", pickNum=" + pickNum + ", mainOrgFileName=" + mainOrgFileName + ", mainStoreFileName="
				+ mainStoreFileName + ", mainFileType=" + mainFileType + ", nickname=" + nickname
				+ ", profileOrgFileName=" + profileOrgFileName + ", profileStoreFileName=" + profileStoreFileName
				+ ", profileFileType=" + profileFileType + "]";
	}
	
	
	
}
