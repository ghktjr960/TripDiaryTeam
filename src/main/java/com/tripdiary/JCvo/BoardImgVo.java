package com.tripdiary.JCvo;
//보드 이미지
public class BoardImgVo {
	private int boardImgNum;
	private int boardNum;
	private String orgFileName;
	private String storeFileName;
	private double fileSize;
	private String fileType;
	private boolean mainImg;

	public BoardImgVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardImgVo(int boardImgNum, int boardNum, String orgFileName, String storeFileName, double fileSize,
			String fileType, boolean mainImg) {
		super();
		this.boardImgNum = boardImgNum;
		this.boardNum = boardNum;
		this.orgFileName = orgFileName;
		this.storeFileName = storeFileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.mainImg = mainImg;
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
