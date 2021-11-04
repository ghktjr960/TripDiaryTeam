package com.tripdiary.TMvo;

public class ProfileCmd {
	private int memberNum;
	private String nickname;
	private String message;
	private String storeFileName;
	private String fileType;
	
	public ProfileCmd() {
		// TODO Auto-generated constructor stub
	}

	public ProfileCmd(int memberNum, String nickname, String message, String storeFileName, String fileType) {
		super();
		this.memberNum = memberNum;
		this.nickname = nickname;
		this.message = message;
		this.storeFileName = storeFileName;
		this.fileType = fileType;
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


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStoreFileName() {
		return storeFileName;
	}

	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
