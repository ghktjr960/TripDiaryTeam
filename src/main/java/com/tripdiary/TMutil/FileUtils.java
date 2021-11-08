package com.tripdiary.TMutil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.TMvo.WriteCmd;

@Component
public class FileUtils {
	private static final String filePath = "C:\\tripdiary\\board_img\\"; // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙치
	
	public List<Map<String, Object>> parseInsertFileInfo(WriteCmd writeCmd, 
			MultipartHttpServletRequest mpRequest) throws Exception{
		

		List<MultipartFile> fileList = mpRequest.getFiles("file");
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int num = writeCmd.getBoardNum();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		if(fileList != null) {
			for(int i=0; i<fileList.size(); i++) {
				multipartFile = fileList.get(i);
				// 占쏙옙占쏙옙 占싱몌옙
				originalFileName = multipartFile.getOriginalFilename();
				// 占쏙옙占쏙옙 확占쏙옙占쏙옙
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				// 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占싱몌옙
				storedFileName = getRandomString() + originalFileExtension;
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("board_num", num);
				listMap.put("org_file_name", originalFileName);
				listMap.put("store_file_name", storedFileName);
				listMap.put("file_size", multipartFile.getSize());
				listMap.put("file_type", originalFileExtension);
				listMap.put("main_img", 0);
				list.add(listMap);
			}
		}
		
/*		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(!multipartFile.isEmpty()) {
				// 占쏙옙占쏙옙 占싱몌옙
				originalFileName = multipartFile.getOriginalFilename();
				// 占쏙옙占쏙옙 확占쏙옙占쏙옙
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				// 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占싱몌옙
				storedFileName = getRandomString() + originalFileExtension;
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("board_num", num);
				listMap.put("org_file_name", originalFileName);
				listMap.put("store_file_name", storedFileName);
				listMap.put("file_size", multipartFile.getSize());
				listMap.put("file_type", originalFileExtension);
				list.add(listMap);
				System.out.println("??");
			}
		}*/
		
		
		return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}