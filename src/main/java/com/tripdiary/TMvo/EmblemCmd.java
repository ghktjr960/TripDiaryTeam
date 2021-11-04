package com.tripdiary.TMvo;

public class EmblemCmd {
	private int emblemNum;
	private String emblemName;
	private String emblemExplain;
	
	public EmblemCmd() {
		// TODO Auto-generated constructor stub
	}
	
	public EmblemCmd(int emblemNum, String emblemName, String emblemExplain) {
		super();
		this.emblemNum = emblemNum;
		this.emblemName = emblemName;
		this.emblemExplain = emblemExplain;
	}

	public int getEmblemNum() {
		return emblemNum;
	}

	public void setEmblemNum(int emblemNum) {
		this.emblemNum = emblemNum;
	}

	public String getEmblemName() {
		return emblemName;
	}

	public void setEmblemName(String emblemName) {
		this.emblemName = emblemName;
	}

	public String getEmblemExplain() {
		return emblemExplain;
	}

	public void setEmblemExplain(String emblemExplain) {
		this.emblemExplain = emblemExplain;
	}

	
	
}
