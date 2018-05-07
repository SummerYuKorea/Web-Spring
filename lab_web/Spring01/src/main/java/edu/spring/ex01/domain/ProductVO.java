package edu.spring.ex01.domain;

public class ProductVO {
	
	// 필드, 멤버 변수, 프로퍼티(EL에서는 프로퍼티값을 읽어온다고 하지~)
	private String pname; //상품 이름
	private int price; //상품 가격
	
	//생성자
	public ProductVO(){}

	public ProductVO(String pname, int price) {
		super();
		this.pname = pname;
		this.price = price;
	}

	// getter/setter
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {  //EL 통해 값 읽어오려면 getter 메소드 필수
		return price;
	}

	public void setPrice(int price) {  //framework 에서 모델 VO 객체를 생성할 때는 보통 디폴트 생성자를 불러
																// 그럼 값을 넣는 건 따로 setter 부른단 얘기 getter, setter 다필 요~
		this.price = price;
	}
	

}
