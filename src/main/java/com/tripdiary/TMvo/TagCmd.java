package com.tripdiary.TMvo;

import java.util.List;

import org.springframework.stereotype.Component;

public class TagCmd {
	private List<String> tag;
	private int boardNum;
	
	public TagCmd() {
		// TODO Auto-generated constructor stub
	}

	public TagCmd(List<String> tag, int boardNum) {
		super();
		this.tag = tag;
		this.boardNum = boardNum;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	
	
	
}
