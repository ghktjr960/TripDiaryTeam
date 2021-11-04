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
	private static final String filePath = "C:\\mp\\board_thumbnail\\"; // ������ ����� ��ġ

	public Map<String, Object> parseInsertFileInfo(WriteCmd writeCmd, MultipartHttpServletRequest mpRequest)
			throws Exception {

		/*
		 * Iterator�� �����͵��� ����ü? ���� �÷������κ��� ������ ���� �� �ִ� �������̽��Դϴ�. List�� �迭�� ���������� ��������
		 * ������ ����������, Map���� Ŭ�������� ���������� ������ ���� �����ϴ�. Iterator�� �̿��Ͽ� Map�� �ִ� �����͵���
		 * while���� �̿��Ͽ� ���������� �����մϴ�.
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

		// ���� �̸�
		originalFileName = multipartFile.getOriginalFilename();
		// ���� Ȯ����
		originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		// ����� ���� �̸�
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
