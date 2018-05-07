package edu.web.bean.model;

public class MyBean {

	private int myNumber;
	private String myName;
	
	public MyBean(){
		this.myNumber=100;
		this.myName="한결이만세";
	}

	public MyBean(int myNumber, String myName) {
		super();
		this.myNumber = myNumber;
		this.myName = myName;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	
}
