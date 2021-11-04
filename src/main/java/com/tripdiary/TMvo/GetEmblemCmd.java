package com.tripdiary.TMvo;

public class GetEmblemCmd {
	private int memberNum;
	private int emblemNum;
	public GetEmblemCmd() {
		// TODO Auto-generated constructor stub
	}
	public GetEmblemCmd(int memberNum, int emblemNum) {
		super();
		this.memberNum = memberNum;
		this.emblemNum = emblemNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getEmblemNum() {
		return emblemNum;
	}
	public void setEmblemNum(int emblemNum) {
		this.emblemNum = emblemNum;
	}
	
	
}
