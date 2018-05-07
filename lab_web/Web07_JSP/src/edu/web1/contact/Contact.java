package edu.web1.contact;

/* POJO ( Plain Old Java Object ) */
//그냥 우리가 만드는 일반적인 클래스 //Servlet이나 jsp아니고 only java문법
public class Contact {
	
	private String name;
	private String phone;
	private String email;
	
	
	public Contact() {
		
	}


	public Contact(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
