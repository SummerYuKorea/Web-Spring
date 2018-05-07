package com.edu.customTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustom1 extends SimpleTagSupport{ //이걸 상속 받으면 태그핸들러클래스가 되는것~

	// <my1:first>의 실행문이었음
//	 @Override
//	public void doTag() throws JspException, IOException {
//		JspContext context = this.getJspContext(); //jsp페이지에 대한 정보
//		JspWriter out =context.getOut();  //출력스트림: 클라이언트와 jsp간의
//		JspFragment body = this.getJspBody();  //tag 몸체(innerHTML)을 처리하는 객체
//		
//		//invoke( Writer out )
//		StringWriter sw =new StringWriter();
//		body.invoke(sw);
//		String str = sw.toString();
//		out.print(str+" -> 한결이 만세");
//	}
	
	//<my1:second>의 실행문
	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = this.getJspContext();
		JspWriter out = context.getOut();
		out.print("num1 + num2 = "+(num1+num2));
	}
	
	private int num1;
	private int num2;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
}
