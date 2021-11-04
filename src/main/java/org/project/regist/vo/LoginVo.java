package org.project.regist.vo;

public class LoginVo {

	
	//private String member_NUM;
	private String member_ID;
  //  private String member_NICK;
	private String member_PW;
  //  private boolean Cookie;
    
    
    /*
	public String getMember_NUM() {
		return member_NUM;
	}
	public void setMember_NUM(String member_NUM) {
		this.member_NUM = member_NUM;
	}
	*/
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	/*
	public String getMember_NICK() {
		return member_NICK;
	}
	public void setMember_NICK(String member_NICK) {
		this.member_NICK = member_NICK;
	}
	*/
	public String getMember_PW() {
		return member_PW;
	}
	public void setMember_PW(String member_PW) {
		this.member_PW = member_PW;
	}
	/*
	public boolean isCookie() {
		return Cookie;
	}
	public void setCookie(boolean cookie) {
		Cookie = cookie;
	}
	*/
	@Override
	public String toString() {
		return "LoginVo [member_ID=" + member_ID + ", member_PW=" + member_PW + "]";
	}

	
	
	
	/*
	@Override
	public String toString() {
		return "LoginVo [member_NUM=" + member_NUM + ", member_ID=" + member_ID + ", member_NICK=" + member_NICK
				+ ", member_PW=" + member_PW + ", Cookie=" + Cookie + "]";
	}
*/
 
	
    
	
	
	
}
