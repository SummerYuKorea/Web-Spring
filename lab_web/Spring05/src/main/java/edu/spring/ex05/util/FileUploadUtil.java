 package edu.spring.ex05.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class FileUploadUtil {

	//우리가 아까 만들었던 save 함수를 바꾼 것.
	
	private static final Logger logger =
			LoggerFactory.getLogger(FileUploadUtil.class);
	
	
	
	
	public static String saveUploadedFile(String uploadPath, 
			String fileName, byte[] data) throws IOException {
		logger.info("4. Util클래스의 saveUploadFile 메소드 불림");
		logger.info("4-1: uploadPath="+uploadPath+"  //fileName="+fileName+"  //data="+data);
		
		UUID uuid = UUID.randomUUID();
		
		String saveName = uuid.toString() + "_" + fileName;
		
		//저장할 폴더를 만듦
		String savePath = getUploadPath(uploadPath);
		
		File target = new File(uploadPath + File.separator + savePath, saveName);  //String parent, String child
		//uploadPath + File.separator + savePath은 전체 저장할 폴더. saveName은 파일 이름을 뜻함.
		System.out.println("4-2: 전체저장할 폴더?:"+uploadPath + File.separator + savePath+"  //파일 이름:"+saveName);
		
		
		FileCopyUtils.copy(data, target); 
		//data를 target에다가 저장하겠다는 뜻.
		
		String extension = 
				fileName.substring(fileName.lastIndexOf(".") + 1); //int beginIndex
		//extension은 파일 확장자이다. .(점) 이후에 나오는 문자열만 잘라내면 확장자.
		
		String result = null;
		if (MediaUtil.getMediaType(extension) != null) {
			result = createThumbnail(uploadPath, savePath, saveName);
			// 이미지 파일이면 섬네일을 만들겠다.
			// 만들어진 섬네일의 위치가 문자열 형태로 리턴된다. 
		} else {
			result = createIcon(uploadPath, savePath, saveName);
		}
		
		return result;
	}
	
	
	
	
	// 파일이 저장되는 폴더 이름을 날짜 형식(yyyy/MM/dd)으로 생성하기 위한 유틸
	// 상위 폴더가 생성되어 있지 않으면 하위 폴더를 생성할 수 없다
	// -> 연도 폴더 생성 -> 달 폴더 생성 -> 날짜 폴더 생성
	// 마지막 리턴은 yyyy/MM/dd 형식으로
	private static String getUploadPath(String uploadPath) {
		Calendar calendar = Calendar.getInstance();
		
		String yearPath = String.valueOf(calendar.get(Calendar.YEAR));
		//logger.info("yearPath: " + yearPath);
		makeDir(uploadPath, yearPath);
		// 2017년 디렉토리를 만들겠다는 뜻.
		
		String monthPath = yearPath
				+ File.separator
				+ new DecimalFormat("00")
					.format(calendar.get(Calendar.MONTH) + 1); // month는 0~11이므로 1을 더해준 것.
		//2017년 폴더 밑에 5월 폴더를 만들겠다는 뜻.
		
		//logger.info("monthPath: " + monthPath);
		makeDir(uploadPath, monthPath);
		
		String datePath = monthPath
				+ File.separator
				+ new DecimalFormat("00")
					.format(calendar.get(Calendar.DATE));
		//logger.info("datePath: " + datePath);
		makeDir(uploadPath, datePath);

		return datePath;
		
		
		// 서브 폴더를 계속 만드는 메소드.
	}//end getUploadPath()
	
	
	
	private static void makeDir(String uploadPath, String path) {
		File dirPath = new File(uploadPath, path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
			logger.info(dirPath.getPath() + " successfully created.");
		} else {
			logger.info(dirPath.getPath() + " already exists.");
		}
		
	}//end makeDir()
	
	
	
	
	
	private static String createThumbnail(String uploadPath,
			String savePath, String fileName) throws IOException {
		//이곳에서는 실제로 이미지를 줄여 섬네일을 만들 것. 
		
		String parent = uploadPath + File.separator + savePath;
		
		BufferedImage source = 
				ImageIO.read(new File(parent, fileName));
		
		BufferedImage destination = 
				Scalr.resize(source, Scalr.Method.AUTOMATIC, 
						Scalr.Mode.FIT_TO_HEIGHT, 200); // 원본이미지를 작은 섬네일로 만들어주는 것.
		
		String thumbnailName = 
				uploadPath + File.separator 
				+ savePath + File.separator
				+ "s_" + fileName; //원본 이미지가 아니라 작게 축소한 이미지라고 s자 하나를 더 붙임.
		
		File thumbnail = new File(thumbnailName); // 섬네일 이름으로 파일 객체 생성.
		
		String formatName = fileName.substring(fileName.lastIndexOf('.') + 1); // 확장자를 뽑아낸 것
		
		boolean result = ImageIO.write(destination, formatName, thumbnail); //파일 객체를 실제로 쓰는 부분
		
		logger.info("create thumbnail result: " + result);
		
		return thumbnailName.substring(uploadPath.length())
				.replace(File.separatorChar, '/'); //섬네일이 만들어진 위치를 리턴하는데, 역슬래쉬를 전부 슬래쉬로 바꿀 것이다. 
	}//end createThumbnail()
	
	
	
	
	private static String createIcon(String uploadPath,
			String savePath, String fileName) {
		
		String iconName = uploadPath + File.separator 
				+ savePath + File.separator + fileName;
		
		return iconName
				.substring(uploadPath.length())
				.replace(File.separatorChar, '/');
		// 문자열을 그대로 리턴하는것이 아니라, 파일 seperator를 무조건 / 로 리턴중.
		// 그대로 리턴하면 윈도우에서 오류가 생기기 때문이다 ㅠㅠ
		
	}//end createIcon()
	
}
