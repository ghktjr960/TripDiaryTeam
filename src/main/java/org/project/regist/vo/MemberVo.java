package org.project.regist.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {

	  /*
     * @Valid 어노테이션을 이용해서 model의 값을 지정하는 경우 아래의 방식으로 통해서 데이터 유효성 검증을 진행 할 수 있습니다.
     * 
     * @AssertFalse : false 값만 통과 가능
     * @AssertTrue : true 값만 통과 가능
     * @DecimalMax(value=) : 지정된 값 이하의 실수만 통과 가능
     * @DecimalMin(value=) : 지정된 값 이상의 실수만 통과 가능
     * @Digits(integer=,fraction=) : 대상 수가 지정된 정수와 소수 자리수보다 적을 경우 통과 가능
     * @Future : 대상 날짜가 현재보다 미래일 경우만 통과 가능
     * @Past : 대상 날짜가 현재보다 과거일 경우만 통과 가능
     * @Max(value) : 지정된 값보다 아래일 경우만 통과 가능
     * @Min(value) : 지정된 값보다 이상일 경우만 통과 가능
     * @NotNull : null 값이 아닐 경우만 통과 가능
     * @Null : null일 겨우만 통과 가능
     * @Pattern(regex=, flag=) : 해당 정규식을 만족할 경우만 통과 가능
     * @Size(min=, max=) : 문자열 또는 배열이 지정된 값 사이일 경우 통과 가능
     * @Valid : 대상 객체의 확인 조건을 만족할 경우 통과 가능
     * */
	
	
	private int memberNum;
	@NotBlank
	@Size(min=2, max =20, message = "2자 이상 20자 이하로 입력해주세요.")
	private String id;
	@NotBlank
	@Length(min=8, max = 13)
	private String password;
	@NotBlank
	@Length(min=2, max= 20)
	private String nickname;
	@NotBlank
	@Email(message = "올바른 이메일 형식을 입력하세요.")
	private String email;
	private String birthyear;
	private String birth;
	private Date regdate;
	private String gender;
	private boolean admin;
	
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(String birthYear) {
		this.birthyear = birthYear;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "MemberVo [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", birthYear=" + birthyear + ", birth=" + birth + ", regdate=" + regdate
				+ ", gender=" + gender + ", admin=" + admin + "]";
	}
	
	
	
	
	
	
	
	
}
