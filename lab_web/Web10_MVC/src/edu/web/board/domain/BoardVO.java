package edu.web.board.domain;

import java.util.Date;

// VO: Value Object
// DTO: Data Transfer Object  
		//DT는 DAO랑 비슷한건데 DAO는 테이블의 구조 그~대로 받아오거나 사용하는 반면 
		//DTO는 여러개의 테이블에서 컬럼을 골라와서 새로운 테이블을 만들어서? 쓰는 그런~
public class BoardVO {
	
	public static final String TABLE_NAME="test_board";
	public static final String COL_BNO="bno";
	public static final String COL_TITLE="title";
	public static final String COL_CONTENT="content";
	public static final String COL_USERID="userid";
	public static final String COL_REGDATE="regdate";
	//table이름과 column이름은 사실 대문자로 써도 노상관~
	//결국 넘어갈때 upperCase를 불러서 넘긴대
	
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
