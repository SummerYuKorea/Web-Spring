package edu.spring.ex05.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.ex05.util.FileUploadUtil;
import edu.spring.ex05.util.MediaUtil;

@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	// Servlet-context.xml 파일에 설정된 문자열 리소스를 주입(inject)
	// resource의 장점은 name 속성을 줄 수 있다. servlet context.xml의 id를 가져올 수 있는 것. 
	// Autowired라고 해도 된다. 
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/upload", method=RequestMethod.GET)
	public void uploadGet(){
		logger.info("FileUploadController의 uploadGet() 호출");
		
	}//end uploadGet
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public void uploadPost(MultipartFile file, Model model){
		// file을 받고 싶으면 MultipartFile을 매개변수로 넣어준다. 
		// 변수이름을 file이라고 한 것은 upload.jsp의 requestParameter name이 file이기 때문이다.
		
		// 서버로 파일 전달. 
		logger.info("FileUploadController의 uploadPost() 호출");
		logger.info("파일 이름 : " + file.getOriginalFilename());
		logger.info("파일 크기 : " + file.getSize());
		
		
		// 주입 받았으면 메소드 하나를 부르고, 여기에 파일 객체를 넘기자
		String savedFile = saveUploadFile(file);
	      model.addAttribute("savedFile", savedFile);
		
		
	}//end uploadPost
	
	
	
	private String saveUploadFile(MultipartFile source){ 
		
		UUID uuid = UUID.randomUUID();
		// UUID : 업로드하는 파일 이름이 중복되지 않도록
		// 랜덤한 문자열을 만들어냄
		
		String savedName = uuid +  "_" + source.getOriginalFilename();
		//source의 파일이름을 savedName이라고 이름 바꿔버림. 파일 이름이 중복되는 것을 막기 위해서임.
		// 날짜를 붙이거나, 사용자 아이디 등을 붙이는 방법도 있음. 
				
		File target = new File(uploadPath, savedName); 
		// 앞은 파일이 저장될 디렉토리, 뒤는 저장할 파일 이름을 뜻함. 이렇게 메모리에 파일 객체를 만들어줌.
		// 이제 우리는 실제로 하드디스크에 써줘야 한다.
		
		try {
			FileCopyUtils.copy(source.getBytes(), target); 
			// 그냥 파일이 아니기 때문에 데이터들을 가져와야 한다. 전부 byte단위로읽어서 byte 배열을 만듦.
			// source.getBytes()는 실제 이미지 파일 데이터.
			// target은 우리가 쓸 파일. 
			
			logger.info("파일 저장 성공 : " + savedName);
			return savedName;
			// 성공하면, 성공한 이름을 넘기겠다. 
	
		} catch (IOException e) {
			
			logger.error("파일 저장 실패");		
			return null;
		}				
		
	}//end saveUploadFile()
	
	
	
	@RequestMapping(value="/upload2", method=RequestMethod.POST)
	public String uploadPost2(MultipartFile[] files, Model model){ 
		// 파일을 여러개 보내면 Multipartfile의 배열로 선언하면 된다.
		// upload.jsp의 name과 똑같이 files라고 해줘야 한다. 
		
		logger.info("uploadPost2() 호출 : 파일 개수 = " + files.length );
				
		String result = "";
		for(MultipartFile f : files){
			result += saveUploadFile(f) + " ";
		}
		model.addAttribute("savedFile", result);
		return "upload";
	}//end uploadPost2()
	
	
	
	
	//ajax 요청 방식을 위한 메소드
	@RequestMapping(value="upload-ajax", method=RequestMethod.GET)
	public void uploadAjaxGet(){
		logger.info("1. uploadAjaxGet() 호출");
		
		
	}//end uploadAjaxGet()
	
	
	@RequestMapping(value="/upload-ajax", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> uploadAjaxPost(MultipartFile[] files){
		logger.info("3. uploadAjaxPost() 호출 // ajax요청보내짐");		
		/*
		  String result = "";
		for(MultipartFile f : files){
			
			logger.info(f.getOriginalFilename());
					result += saveUploadFile(f) + " ";
		}		
		*/
		
		//파일 하나만 저장하는 것으로 예제를 만들어보자.
		String result = null;
		
		try {
			result = FileUploadUtil.saveUploadedFile(uploadPath, 	
																				files[0].getOriginalFilename(), 
																				files[0].getBytes());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// entity가 바로 client에 전달된다.
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
				
		return entity;
	}//end uploadAjaxPost
	
	
	
	
	
	@RequestMapping(value="display", method=RequestMethod.GET)
	public ResponseEntity<byte[]> display(String fileName) throws IOException{
		// 이미지만 가정하고 만든 메소드.
		// 파일업로드가 성공해서 SUCCESS가 되돌아 왔을 때,
		
		
		logger.info("5. display() 호출 됨//ajax로 SUCCESS가 돌아온 경우(파일업로드성공)"); 
		
		// 리턴 타입
		ResponseEntity<byte[]> entity = null;
		
		// 실제 저장된 파일 스트림
		InputStream in = null;
				
		// uploadPath를 붙여야 저장된 FULL PATH가 나온다.
		String filePath = uploadPath + fileName;
		logger.info("5-1: filePath: "+filePath);
		
		//이미지 파일에서 data를 읽어야 하니까, input stream 만든다. 이걸루 read, write.
		in = new FileInputStream(filePath); 
		
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		
		//파일 확장자를 가지고 온 이유는, 우리가 response를 보낼 때 응답 헤더(response header)에 
		//Content-Type을 설정해야 하기 때문이다.
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaUtil.getMediaType(extension)); 
		//header에 미디어 타입 저장하기. 확장자를 가지고 미디어 타입을 알아야 한다. 
		// jpg인지, gif인지. util클래스를 만들어 몇개 정해줌.
		
		
		//responseEntity객체에 넣음.
		// 사실 읽는 동작에 대해 반복문을 써줘도 되는데 bytearray라는 것을 써준 것 뿐. 
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), // 파일에서 읽은 데이터
																	httpHeaders, // 응답 헤더(png인지,jpg인지)
																	HttpStatus.OK  ); //응답 코드
		
		
		return entity;
	}//end display()
	
	
	
	
	
}//end class FileUploadController

















































