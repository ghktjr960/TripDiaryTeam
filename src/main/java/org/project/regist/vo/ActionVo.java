package org.project.regist.vo;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ActionVo {

	private int member2Num;
	private int likePressCnt;
	private int pickPressCnt;
	private int boardWriteCnt;
	private int commentWriteCnt;
	private int likeReceiveCnt;
	
	
	
	public int getMemberNum() {
		return member2Num;
	}
	public void setMemberNum(int member2Num) {
		this.member2Num = member2Num;
	}
	public int getLikePressCnt() {
		return likePressCnt;
	}
	public void setLikePressCnt(int likePressCnt) {
		this.likePressCnt = likePressCnt;
	}
	public int getPickPressCnt() {
		return pickPressCnt;
	}
	public void setPickPressCnt(int pickPressCnt) {
		this.pickPressCnt = pickPressCnt;
	}
	public int getBoardWriteCnt() {
		return boardWriteCnt;
	}
	public void setBoardWriteCnt(int boardWriteCnt) {
		this.boardWriteCnt = boardWriteCnt;
	}
	public int getCommentWriteCnt() {
		return commentWriteCnt;
	}
	public void setCommentWriteCnt(int commentWriteCnt) {
		this.commentWriteCnt = commentWriteCnt;
	}
	public int getLikeReceiveCnt() {
		return likeReceiveCnt;
	}
	public void setLikeReceiveCnt(int likeReceiveCnt) {
		this.likeReceiveCnt = likeReceiveCnt;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ActionVo [member2Num=" + member2Num + ", likePressCnt=" + likePressCnt + ", pickPressCnt=" + pickPressCnt
				+ ", boardWriteCnt=" + boardWriteCnt + ", commentWriteCnt=" + commentWriteCnt + ", likeReceiveCnt="
				+ likeReceiveCnt + "]";
	}
	
	
	
	
	
	
	
	
}
