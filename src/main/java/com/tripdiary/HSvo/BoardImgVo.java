package com.tripdiary.HSvo;

public class BoardImgVo {
	private int boardImgNum;
	private int boardNum;
	private String orgFileName;
	private String storeFileName;
	private double fileSize;
	private String fileType;
	private boolean mainImg;
	
	public BoardImgVo() {

	}
	
	public int getBoardImgNum() {
		return boardImgNum;
	}
	public void setBoardImgNum(int boardImgNum) {
		this.boardImgNum = boardImgNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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
	public boolean isMainImg() {
		return mainImg;
	}
	public void setMainImg(boolean mainImg) {
		this.mainImg = mainImg;
	}

	@Override
	public String toString() {
		return "BoardImgVo [boardImgNum=" + boardImgNum + ", boardNum=" + boardNum + ", orgFileName=" + orgFileName
				+ ", storeFileName=" + storeFileName + ", fileSize=" + fileSize + ", fileType=" + fileType
				+ ", mainImg=" + mainImg + "]";
	}
	
	
}
