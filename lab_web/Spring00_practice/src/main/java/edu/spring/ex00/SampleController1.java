package edu.spring.ex00;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SampleController1 {
	
	//private static final Logger logger= 
	
	@RequestMapping(value="/cart", method= RequestMethod.GET)
	public void getCart(){ //void인 경우는 mapping값을 이용해 view가될 jsp 찾아감
		
	}//getCart()
	
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public void getGiftList(){
		
	}//getGiftList()

}
