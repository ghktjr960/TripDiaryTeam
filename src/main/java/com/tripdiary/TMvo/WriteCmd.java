package com.tripdiary.TMvo;

import java.sql.Timestamp;

public class WriteCmd {
	private int boardNum;
	private int memberNum;
	private String placeCheck;
	private String place;
	private String content;
	private Timestamp regdate;
	private String year;
	private String month;
	private String day;
	private String tripdate;
	private int td_like_cnt;
	
	public WriteCmd() {
		// TODO Auto-generated constructor stub
	}

	public WriteCmd(int boardNum, int memberNum, String placeCheck, String place, String content, Timestamp regdate,
			String year, String month, String day, String tripdate, int td_like_cnt) {
		super();
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.placeCheck = placeCheck;
		this.place = place;
		this.content = content;
		this.regdate = regdate;
		this.year = year;
		this.month = month;
		this.day = day;
		this.tripdate = tripdate;
		this.td_like_cnt = td_like_cnt;
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





	public String getPlaceCheck() {
		return placeCheck;
	}

	public void setPlaceCheck(String placeCheck) {
		this.placeCheck = placeCheck;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getTd_like_cnt() {
		return td_like_cnt;
	}

	public void setTd_like_cnt(int td_like_cnt) {
		this.td_like_cnt = td_like_cnt;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTripdate() {
		return tripdate;
	}

	public void setTripdate(String tripdate) {
		this.tripdate = tripdate;
	}
	
	
	
	
}
