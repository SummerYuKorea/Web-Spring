package edu.web.member.domain;

public class MemberVO {
	
	public static final String TABLE_NAME="test_member";
	public static final String COL_USERID="userid";
	public static final String COL_USERPW="userpw";
	public static final String COL_EMAIL="email";
	public static final String COL_ACTIVE="active";
	
	private String userid;
	private String userpw;
	private String email;
	private String active;
	
	
	
	public MemberVO() {
		super();
	}
	public MemberVO(String userid, String userpw, String email, String active) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.email = email;
		this.active = active;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	
	

}
