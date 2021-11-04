package com.tripdiary.HSvo;

public class PageVo {
	// 정렬 검색
	private String sort;
	private String place;
	private String tag;
	
	// 페이징 처리
	private Integer page;			// 현재페이지
	private int startPage;		// 시작페이지 (1~10, 11~20)일때 1, 11
	private int endPage;		// 끝페이지 (1~10, 11~20)일때 10, 20
	private int total;			// 게시글 총 갯수
	private int lastPage;		// 마지막페이지 : 페이징 처리 후 제일 마지막 페이지
	private int startRnum;		// 시작 rnum
	private int endRnum;		// 끝 rnum
	private int cntPage = 9;	// 페이지당 글 갯수
	
	// 찜하기에서 사용
	private int memberNum;
	
	public PageVo() {
		// TODO Auto-generated constructor stub
	}
	
	// 정렬 검색, 페이징 처리에 사용되는 생성자
	
	public PageVo(String sort, String place, String tag) {
		this.sort = sort;
		this.place = place;
		this.tag = tag;
	}
	
	public PageVo(String sort, String place, String tag, int total, Integer page) {
		this.sort = sort;
		this.place = place;
		this.tag = tag;
		
		setPage(page);
		setTotal(total);
		
		calcLastPage(getTotal(), getCntPage());
		calcStartEndPage(getPage(), cntPage);
		calcStartEndRnum(getPage(), getCntPage());
	}
	
	public PageVo(String sort, String place, String tag, int total, Integer page, int memberNum) {
		this.sort = sort;
		this.place = place;
		this.tag = tag;
		this.memberNum = memberNum;
		
		setPage(page);
		setTotal(total);
		
		calcLastPage(getTotal(), getCntPage());
		calcStartEndPage(getPage(), cntPage);
		calcStartEndRnum(getPage(), getCntPage());
	}
	
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPage));
	}
	
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(Integer page, int cntPage) {
		setEndPage(((int) Math.ceil((double)page / (double)cntPage)) * cntPage);
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if(getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	// DB쿼리에서 사용할 start, end값
	public void calcStartEndRnum(Integer page, int cntPage) {
		setEndRnum(page * cntPage);
		setStartRnum(getEndRnum() - cntPage + 1); 
	}
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStartRnum() {
		return startRnum;
	}

	public void setStartRnum(int startRnum) {
		this.startRnum = startRnum;
	}

	public int getEndRnum() {
		return endRnum;
	}

	public void setEndRnum(int endRnum) {
		this.endRnum = endRnum;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "PageVo [sort=" + sort + ", place=" + place + ", tag=" + tag + ", page=" + page + ", startPage="
				+ startPage + ", endPage=" + endPage + ", total=" + total + ", lastPage=" + lastPage + ", startRnum="
				+ startRnum + ", endRnum=" + endRnum + ", cntPage=" + cntPage + ", memberNum=" + memberNum + "]";
	}

	
	
	
	
}
