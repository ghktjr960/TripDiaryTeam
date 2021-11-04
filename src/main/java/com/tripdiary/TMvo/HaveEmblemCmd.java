package com.tripdiary.TMvo;

public class HaveEmblemCmd {
	private int emblemNum;
	private int memberNum;
	
	public HaveEmblemCmd() {
		// TODO Auto-generated constructor stub
	}

	public HaveEmblemCmd(int emblemNum, int memberNum) {
		super();
		this.emblemNum = emblemNum;
		this.memberNum = memberNum;
	}

	public int getEmblemNum() {
		return emblemNum;
	}

	public void setEmblemNum(int emblemNum) {
		this.emblemNum = emblemNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
}
