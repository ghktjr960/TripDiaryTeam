package com.tripdiary.HSvo;

public class ProfileImgVo {
	private int profileImgNum;
	private int memberNum;
	private String orgFileName;
	private String storeFileName;
	private double fileSize;
	private String fileType;
	
	public ProfileImgVo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProfileImgVo(int profileImgNum, int memberNum, String orgFileName,
			String storeFileName, double fileSize, String fileType) {
		 this.profileImgNum = profileImgNum;
		 this.memberNum = memberNum;
		 this.orgFileName = orgFileName;
		 this.storeFileName = storeFileName;
		 this.fileSize = fileSize;
		 this.fileType = fileType;
	}

	public int getProfileImgNum() {
		return profileImgNum;
	}

	public void setProfileImgNum(int profileImgNum) {
		this.profileImgNum = profileImgNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getStoreFileName() {
		return storeFileName;
	}

	public void setStoreFileName(String storeFileName) {
		this.storeFileName = storeFileName;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "ProfileImgVo [profileImgNum=" + profileImgNum + ", memberNum=" + memberNum + ", orgFileName="
				+ orgFileName + ", storeFileName=" + storeFileName + ", fileSize=" + fileSize + ", fileType=" + fileType
				+ "]";
	}
	
	
	
	
}
