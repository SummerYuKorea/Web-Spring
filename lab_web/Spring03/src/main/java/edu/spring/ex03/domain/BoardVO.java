package edu.spring.ex03.domain;

import java.util.Date;

public class BoardVO {
	
	private int bno; // 게시글 번호
	private String title; // 게시글 제목
	private String content;
	private String userid;
	private Date regdate;
	
	public BoardVO(){}

	public BoardVO(int bno, String title, String content, String userid, Date regdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content=content;
		this.userid = userid;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	};
	
	
	
}
