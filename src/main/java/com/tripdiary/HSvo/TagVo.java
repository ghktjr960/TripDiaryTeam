package com.tripdiary.HSvo;

public class TagVo {
	private int tagNum;
	private int boardNum;
	private String tag;
	
	public TagVo() {

	}
	
	public TagVo(int tagNum, int boardNum, String tag) {
		this.tagNum = tagNum;
		this.boardNum = boardNum;
		this.tag = tag;
	}
	
	public int getTagNum() {
		return tagNum;
	}
	public void setTagNum(int tagNum) {
		this.tagNum = tagNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "TagVo [tagNum=" + tagNum + ", boardNum=" + boardNum + ", tag=" + tag + "]";
	}
	
}
