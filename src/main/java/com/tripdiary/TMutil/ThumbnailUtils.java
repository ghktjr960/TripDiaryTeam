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
public class ThumbnailUtils {
	private static final String filePath = "C:\\tripdiary\\board_thumbnail\\"; // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙치

	public Map<String, Object> parseInsertFileInfo(WriteCmd writeCmd, MultipartHttpServletRequest mpRequest)
			throws Exception {

		/*
		 * Iterator占쏙옙 占쏙옙占쏙옙占싶듸옙占쏙옙 占쏙옙占쏙옙체? 占쏙옙占쏙옙 占시뤄옙占쏙옙占쏙옙占싸븝옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쌍댐옙 占쏙옙占쏙옙占쏙옙占싱쏙옙占쌉니댐옙. List占쏙옙 占썼열占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		 * 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙, Map占쏙옙占쏙옙 클占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙. Iterator占쏙옙 占싱울옙占싹울옙 Map占쏙옙 占쌍댐옙 占쏙옙占쏙옙占싶듸옙占쏙옙
		 * while占쏙옙占쏙옙 占싱울옙占싹울옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.
		 */
		MultipartFile multipartFile = mpRequest.getFile("thumbnail");
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		Map<String, Object> listMap = null;

		int num = writeCmd.getBoardNum();

		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

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
		listMap.put("main_img", 1);

		return listMap;
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
