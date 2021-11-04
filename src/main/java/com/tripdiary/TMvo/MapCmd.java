package com.tripdiary.TMvo;

public class MapCmd {
	private int memberNum;
	private int boardNum;
	private double markerLng;
	private double markerLat;
	
	public MapCmd() {
		// TODO Auto-generated constructor stub
	}

	public MapCmd(int memberNum, int boardNum, double markerLng, double markerLat) {
		super();
		this.memberNum = memberNum;
		this.boardNum = boardNum;
		this.markerLng = markerLng;
		this.markerLat = markerLat;
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
	public double getMarkerLng() {
		return markerLng;
	}
	public void setMarkerLng(double markerLng) {
		this.markerLng = markerLng;
	}
	public double getMarkerLat() {
		return markerLat;
	}
	public void setMarkerLat(double markerLat) {
		this.markerLat = markerLat;
	}
	
	
	
}
