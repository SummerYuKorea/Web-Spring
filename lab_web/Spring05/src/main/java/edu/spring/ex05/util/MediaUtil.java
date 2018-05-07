package edu.spring.ex05.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtil {

	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG); 
		//JPG가 들어오면 MediaType.IMAGE_JPEG를 리턴하겠다는 뜻.
		
		mediaMap.put("JPGG", MediaType.IMAGE_JPEG); 
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	
	
	public static MediaType getMediaType(String type) {
		//type부분에 확장자가 들어온다.
		
		//map에 없는 확장자면 null이 리턴될 것이다.
		// 확장자를 전부 다 대문자로 바꿔버린다. 그리고 비교하도록 만든다. 
		return mediaMap.get(type.toUpperCase());
	}
	
}
