<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>Form 양식 제출 데이터 확인</h1>
<% 	//Scriptlet -  _jspService() 메소드 내부에서 실행되는 코드
	 request.setCharacterEncoding("UTF-8"); //이코드를 서블릿에서 쓸때는 doPost()에서만 설정해주면되겠지

	String name= request.getParameter("user_name");  
	//->이때 한글로 넘겨도 잘되는것은 get방식이기때문(URL이 UTF-8방식이니까)
	//	post방식은 잘 안됨. 데이터가 request의 packet body에 들어있기 때문. request에 setCharacterEncoding해줘야함
	out.write("이름 : "+name+"<br/>");

	int age= Integer.parseInt(request.getParameter("user_age"));  
	//얘를 숫자로 받아들이려면 parseInt필수지 //그냥프린트하려면 그냥해		
	//단 age에 아무것도 안넘어오면 에러나겠지 code500 NumberFormatException// 문자도 넘어갈 수 있네?(한글자)
	out.write("나이: "+age+"살"+"<br/>");
	
	String mailReceive = request.getParameter("mail_receive");
	//라디오 버튼은 원래 널체크해야됨 근데 얘는 checked 설정해놓아서 반드시 뭐하나는 체크되도록 되어있으므로 널생략~
	out.write("메일 수신 여부: "+mailReceive+"<br/>");
	
	//체크 박스:
	// 1) 몸에서 체크박스들 중에서 선택된 버튼이 하나도 없으면 요청 파라미터가 전달되지 않음 -> null 체크가 필요
	// 2) 하나의 파라미터 이름으로 여러개의 값들이 전달될 수 있음 -> getParameterValues() 메소드를 사용 (얘는 스트링배열을 리턴!)
	String [] hobby= request.getParameterValues("<br/>");
	out.write("취미: ");
	if(hobby!=null){
		for(int i=0;i<hobby.length;i++){
			out.write(hobby[i]);
			if(i!=hobby.length-1)out.write(", ");
		}out.write("<br/>");
	}else{//하비가 null
		out.write("없음<br/>");
	}
	
	//단일선택 drop-down리스트
	String email= request.getParameter("email");
	out.write("이메일: rufgksdb"+email+"<br/><hr/>");
	
	System.out.println("user_name: "+name);
	System.out.println("user_age: "+age+"살");
	
	//////////////////////////////////////////////////////////////////////////
	
	//request객체에서 파라미터의 이름들만 찾고자 할 때: getParameterNames()
	Enumeration<String> paraNames = request.getParameterNames();//이거의 리턴값이 이뉴머레이션이었어
	while(paraNames.hasMoreElements()){ //set이나 list랑 쓰는 방법 비슷하대 //set은 for-each가능한데 얘는 iteration이 안된다카네?(ㅇㅎ~얜 인터페이스네)
		out.write(paraNames.nextElement()+"<br/>"); //request로 안넘어온건 안나옴(당연?)
	}
	
	
	
%>

</body>
</html>